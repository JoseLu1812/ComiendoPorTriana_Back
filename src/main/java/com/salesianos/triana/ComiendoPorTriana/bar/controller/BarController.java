package com.salesianos.triana.ComiendoPorTriana.bar.controller;

import com.salesianos.triana.ComiendoPorTriana.bar.model.Bar;
import com.salesianos.triana.ComiendoPorTriana.bar.model.dto.BarDto;
import com.salesianos.triana.ComiendoPorTriana.bar.model.dto.CreateBarDto;
import com.salesianos.triana.ComiendoPorTriana.bar.model.dto.EditBarDto;
import com.salesianos.triana.ComiendoPorTriana.bar.service.BarService;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Tag(name = "Bar", description = "Controlador para manejar peticiones de objetos tipo Bar")
public class BarController {

    private final BarService service;


    @Operation(
            summary = "Obtener un bar",
            description = "Devuelve el bar solicitado por Id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "El bar existe",
                    content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BarDto.class)),
                            examples = @ExampleObject("""
                                    {
                                        "name": "Bar Ruperto",
                                        "description": "Este clasico bar trianero lleva desde 1970 sirviendo codornices fritas y adobadas y son los pajaritos mas celebrados de toda Sevilla.",
                                        "owner": {
                                                "id": "d9554666-0096-469d-96c2-eb20e31dcb23",
                                                "username": "Juliaeh",
                                                "password": "{bcrypt}$2a$12$CPcJtGCLIQzdNqkbSSfnzebwvMnIDgiY0IQ5QZwqkc8ncCXyCFG4u",
                                                "email": "jeh@gmail.com",
                                                "fullName": "Julia Estevez Hidalgo",
                                                "favList": [],
                                                "accountNonExpired": true,
                                                "accountNonLocked": true,
                                                "credentialsNonExpired": true,
                                                "enabled": true,
                                                "roles": [
                                                    "BARMAN"
                                                ],
                                                "createdAt": "2023-02-02T00:00:00",
                                                "lastPasswordChangeAt": "2023-02-02T00:00:00",
                                                "authorities": [
                                                    {
                                                        "authority": "ROLE_BARMAN"
                                                    }
                                                ]
                                            },
                                        "direction": "Avenida Santa Cecilia, 2",
                                        "comments": [],
                                        "image": "ruperto.jpg"
                                    }
                                    """))}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "El Bar solicitado no ha sido encontrado",
                    content = {@Content()}
            )
    })
    @GetMapping("/bar/{id}")
    public BarDto findById(@Parameter(name = "Id", description = "Id aportado para obtener el Bar indicado")@PathVariable UUID id) {
        return service.findById(id);
    }



    @Operation(
            summary = "Obtener una lista de Bares",
            description = "Devuelve una lista de Bares, con paginado y filtros, sin necesidad de tener estos últimos"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La lista contiene bares",
                    content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Bar.class)),
                            examples = @ExampleObject("""
                                    {
                                        
                                        {
                                            "content": [
                                                {
                                                    "id": "80adfa7a-6a63-42f3-8a1e-153039544e7b",
                                                    "name": "Bar Cibeles 2",
                                                    "description": "Bar de toda la vida al mÃ¡s puro estilo sevillano. Caracterizado por sus serranitos, tambiÃ©n destacar su alioli y su flamenquin.",
                                                    "owner": {
                                                        "id": "c8d2cf0d-1868-4ced-892a-27bea770def6",
                                                        "username": "Franjdn",
                                                        "password": "{bcrypt}$2a$12$yQyiJvrPoU4K5TfRG7UpVOdjDm36APuJFk6XpywwEq.9XsV3aWDam",
                                                        "email": "fjdn@gmail.com",
                                                        "fullName": "Francisco Jose Dominguez Navas",
                                                        "favList": [],
                                                        "accountNonExpired": true,
                                                        "accountNonLocked": true,
                                                        "credentialsNonExpired": true,
                                                        "enabled": true,
                                                        "roles": [
                                                        "BARMAN"
                                                        ],
                                                        "createdAt": "2023-02-01T00:00:00",
                                                        "lastPasswordChangeAt": "2023-02-01T00:00:00",
                                                        "authorities": [
                                                            {
                                                                "authority": "ROLE_BARMAN"
                                                            }
                                                        ]
                                                    },
                                                    "direction": "C/Justino Matute, 6",
                                                    "image": "cibeles.jpg",
                                                    "comments": [],
                                                    "createdAt": "2023-02-05T00:00:00"
                                                },
                                                {
                                                ...
                                                }
                                    }
                                    """))}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Lista de bares no encontrada",
                    content = {@Content()}
            )
    })
    @GetMapping("/bar/")
    public Page<Bar> search(@Parameter(name = "Search", description = "Filtros de busqueda para la petición")@RequestParam(value = "search", defaultValue = "") String search,
                            @PageableDefault(size = 6, page = 0) Pageable pageable){
        return service.findAll(search, pageable);
    }




    @Operation(
            summary = "Crear un bar",
            description = "Crea un Bar a partir de un cuerpo dado por el usuario"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Bar creado",
                    content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BarDto.class)),
                            examples = @ExampleObject("""
                                    {
                                        {
                                            "name": "Bar Joselu",
                                            "description": "Bar creado por mi, solo para mi, donde se come de mi...miercoles a domingo.",
                                            "owner": {
                                                "id": "53395e14-60d3-46d8-804f-fafd86c72a19",
                                                "username": "Joseluhn",
                                                "password": "{bcrypt}$2a$12$MDdQ80jBSFBCzQy1EUrrGeXjZ6VpHGTrML8AUPbVdoMgHZxOYlNMO",
                                                "email": "jlhn@gmail.com",
                                                "fullName": "Jose Luis Hidalgo Navas",
                                                "favList": [],
                                                "accountNonExpired": true,
                                                "accountNonLocked": true,
                                                "credentialsNonExpired": true,
                                                "enabled": true,
                                                "roles": [
                                                    "BARMAN"
                                                ],
                                                "createdAt": "2023-01-31T00:00:00",
                                                "lastPasswordChangeAt": "2023-02-01T00:00:00",
                                                "authorities": [
                                                    {
                                                        "authority": "ROLE_BARMAN"
                                                    }
                                                ]
                                            },
                                            "direction": "C/La Tierra, 1",
                                            "comments": [],
                                            "image": "bar-joselu_495710.jpg"
                                        }
                                    }
                                    """))}
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bar no creado",
                    content = {@Content()}
            )
    })
    @PostMapping("/bar/")
    public ResponseEntity<BarDto> createNewBar(@Parameter(name = "Logged", description = "Sesión de usuario autenticado") @AuthenticationPrincipal User logged,
                                               @Parameter(name = "Dto", description = "Cuerpo aportado para crear el Bar") @Valid @RequestPart("dto") CreateBarDto dto,
                                               @Parameter(name = "File", description = "Archivo aportado para la imagen") @RequestPart("file") MultipartFile file) {
        Bar bar = service.add(dto, logged, file);
        URI createdURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bar.getId()).toUri();

        return ResponseEntity
                .created(createdURI)
                .body(BarDto.of(bar));
    }




    @Operation(
            summary = "Editar un bar",
            description = "Damos un cuerpo de CreateBarDto pra editar un Bar obtenido mediante el Id."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Bar editado",
                    content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BarDto.class)),
                            examples = @ExampleObject("""
                                    {
                                        "name": "Negra Paloma",
                                            "description": "Ahora la paloma es negra.",
                                            "owner": {
                                                "id": "9d6076d7-233d-4111-bd19-1c589d2a2764",
                                                "username": "MPilarnt",
                                                "password": "{bcrypt}$2a$12$67RB4S92tG.MbeyrffgeC.XNT.8/u/tV1xVZvp6SeejovhEAIbayu",
                                                "email": "mpnt@gmail.com",
                                                "fullName": "Maria del Pilar Navas Tenor",
                                                "favList": [],
                                                "accountNonExpired": true,
                                                "accountNonLocked": true,
                                                "credentialsNonExpired": true,
                                                "enabled": true,
                                                "roles": [
                                                    "BARMAN"
                                                ],
                                                "createdAt": "2023-02-20T00:00:00",
                                                "lastPasswordChangeAt": "2023-02-20T00:00:00",
                                                "authorities": [
                                                    {
                                                        "authority": "ROLE_BARMAN"
                                                    }
                                                ]
                                            },
                                            "direction": "C/San Jacinto, 49",
                                            "comments": [],
                                            "image": "paloma-negra.jpg"
                                    }
                                    """))}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "El Bar no existe",
                    content = {@Content()}
            )
    })
    @PutMapping("/bar/{id}")
    public BarDto edit(@Parameter(name = "Logged", description = "Sesión de usuario autenticado")@AuthenticationPrincipal User logged,
                       @Parameter(name = "Id", description = "Id aportado para obtener el Bar indicado")@PathVariable UUID id,
                       @Parameter(name = "Dto", description = "Cuerpo aportado para editar el Bar")@RequestPart("dto") EditBarDto dto,
                       @Parameter(name = "File", description = "Archivo aportado para la imagen")@RequestPart("file") MultipartFile file) {
        return BarDto.of(service.edit(id,dto, logged, file));
    }





    @Operation(
            summary = "Borra un bar",
            description = "Eliminamos un bar mediante un id, con autorizacion del usuario propietario."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Bar eliminado",
                    content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BarDto.class)),
                            examples = @ExampleObject("""
                                    {
                                    }
                                    """))}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "El Bar no existe",
                    content = {@Content()}
            )
    })
    @DeleteMapping("/bar/{id}")
    public ResponseEntity<?> delete(@Parameter(name = "Logged", description = "Sesión de usuario autenticado")@AuthenticationPrincipal User logged,
                                    @Parameter(name = "Id", description = "Id aportado para obtener el Bar indicado")@PathVariable UUID id) {
        service.delete(id, logged);

        return ResponseEntity.noContent().build();
    }




}

