package com.salesianos.triana.ComiendoPorTriana.comment.controller;

import com.salesianos.triana.ComiendoPorTriana.bar.model.dto.BarDto;
import com.salesianos.triana.ComiendoPorTriana.bar.service.BarService;
import com.salesianos.triana.ComiendoPorTriana.comment.model.Comment;
import com.salesianos.triana.ComiendoPorTriana.comment.model.dto.CommentDto;
import com.salesianos.triana.ComiendoPorTriana.comment.model.dto.CreateCommentDto;
import com.salesianos.triana.ComiendoPorTriana.comment.model.dto.EditCommentDto;
import com.salesianos.triana.ComiendoPorTriana.comment.service.CommentService;
import com.salesianos.triana.ComiendoPorTriana.user.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Tag(name = "Comment", description = "Controlador para manejar peticiones de objetos tipo Comment")
public class CommentController {

    private final CommentService service;

    private final BarService barService;






    @Operation(
            summary = "Obtener un Comentarios",
            description = "Esta petición devuelve un ComentarioDto"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Existe el Comentario del Bar indicado",
                    content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Comment.class)), examples = @ExampleObject("""
                            {
                                "author": "",
                                "title": "",
                                "text": "",
                                "createdAt": ""
                            }
                            """))}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No se encontró el Comentario en el Bar indicado",
                    content = {@Content()}
            )
    })@GetMapping("/bar/{barId}/comment/{comId}")
    public CommentDto findBarComment(@Parameter(name = "BarId", description = "Id del Bar")@PathVariable UUID barId,
                                     @Parameter(name = "ComId", description = "Id del Comentario")@PathVariable UUID comId){
        BarDto bar = barService.findById(barId);

        return service.findCommentFromBar(barId, comId);
    }



    @Operation(
            summary = "Obtener todas los Comentarios",
            description = "Esta petición devuelve una Page de Comentarios de un Bar"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Existe una lista de Comentarios en el Bar",
                    content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Comment.class)), examples = @ExampleObject("""
                            {
                                {
                                     "content":  [
                                        { 
                                            "id": "",
                                            "bar": "",
                                            "author": "",
                                            "title": "",
                                            "text": "",
                                            "createdAt": ""
                                        },
                                        {
                                            "id": "",
                                            "bar": "",
                                            "author": "",
                                            "title": "",
                                            "text": "",
                                            "createdAt": ""
                                        },
                                        ...
                                      ]  
                                }
                            }
                            """))}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No se enconto lista de Comentarios en el Bar",
                    content = {@Content()}
            )
    })
    @GetMapping("/bar/{barId}/comment/")
    public Page<Comment> searchBarComments(@Parameter(name = "Search", description = "Filtros de busqueda para la petición")@RequestParam(value = "search", defaultValue = "") String search,
                                           @PageableDefault(size = 12, page = 0) Pageable pageable,
                                           @Parameter(name = "BarId", description = "Id del Bar")@PathVariable UUID barId){
        return service.findAll(search, pageable, barId);
    }




    @Operation(
            summary = "Crear un Comentario",
            description = "Esta petición devuelve una BarDto"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Comentario creado",
                    content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Comment.class)), examples = @ExampleObject("""
                            {
                                "author": "",
                                "title": "",
                                "text": "",
                                "createdAt": ""
                            }
                            """))}
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Comentario no creado",
                    content = {@Content()}
            )
    })
    @PostMapping("bar/{barId}/comment/")
    public ResponseEntity<CommentDto> createNewComment(@Parameter(name = "Dto", description = "Cuerpo aportado para crear el Comentario")@Valid @RequestBody CreateCommentDto dto,
                                                       @Parameter(name = "BarId", description = "Id del Bar")@PathVariable UUID barId){
        Comment comment = service.add(dto, barId);
        URI createdURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(comment.getId()).toUri();

        return ResponseEntity
                .created(createdURI)
                .body(CommentDto.of(comment));
    }





    @Operation(
            summary = "Editar un Comentario",
            description = "Esta petición devuelve una BarDto"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Comentario editado",
                    content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Comment.class)), examples = @ExampleObject("""
                            {
                                "author": "",
                                "title": "",
                                "text": "",
                                "createdAt": ""
                            }
                            """))}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "El Comentario no existe",
                    content = {@Content()}
            )
    })
    @PutMapping("bar/{barId}/comment/{comId}")
    public CommentDto edit(@Parameter(name = "Logged", description = "Sesión de usuario autenticado")@AuthenticationPrincipal User logged,
                           @Parameter(name = "ComId", description = "Id del Comentario")@PathVariable UUID comId,
                           @Parameter(name = "BarId", description = "Id del Bar")@PathVariable UUID barId,
                           @Parameter(name = "Dto", description = "Cuerpo aportado para editar el Comentario")@RequestBody EditCommentDto dto){
        return CommentDto.of(service.edit(barId,comId,dto, logged));
    }





    @Operation(
            summary = "Borrar un Comentario",
            description = "Esta petición elimina un Comentario"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Comentario eliminado",
                    content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Comment.class)), examples = @ExampleObject("""
                            {

                            }
                            """))}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "El Comentario no existe",
                    content = {@Content()}
            )
    })
    @DeleteMapping("bar/{barId}/comment/{comId}")
    public ResponseEntity<?> delete(@Parameter(name = "Logged", description = "Sesión de usuario autenticado")@AuthenticationPrincipal User logged,
                                    @Parameter(name = "ComId", description = "Id del Comentario")@PathVariable UUID comId,
                                    @Parameter(name = "BarId", description = "Id del Bar")@PathVariable UUID barId){
        service.delete(barId,comId, logged);
        return ResponseEntity.noContent().build();
    }


}
