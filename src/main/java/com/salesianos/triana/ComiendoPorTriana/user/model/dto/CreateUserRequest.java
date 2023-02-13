package com.salesianos.triana.ComiendoPorTriana.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@PasswordValueMatch.List({

        @PasswordValueMatch(

                field = "password",

                fieldMatch = "confirmPassword",

                message = "Passwords do not match!"

        )

})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRequest {

    @NotEmpty(message = "{createUserRequest.username.notempty}")
    private String username;


    private String password;

    private String verifyPassword;

    private String avatar;

    @NotEmpty(message = "createUserRequest.fullname.notempty")
    private String fullName;

}
