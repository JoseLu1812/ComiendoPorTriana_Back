package com.salesianos.triana.ComiendoPorTriana.user.model.dto;

import com.salesianos.triana.ComiendoPorTriana.validation.annotation.UsernameNotRepeat;
import com.salesianos.triana.ComiendoPorTriana.validation.annotation.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRequest {

    @NotEmpty(message = "{createUserRequest.username.notempty}")
    @UsernameNotRepeat
    private String username;

    @ValidPassword
    private String password;

    @ValidPassword
    private String verifyPassword;

    private String avatar;

    @NotEmpty(message = "createUserRequest.fullname.notempty")
    private String fullName;

}
