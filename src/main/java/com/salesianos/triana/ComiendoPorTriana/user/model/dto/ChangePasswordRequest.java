package com.salesianos.triana.ComiendoPorTriana.user.model.dto;

import com.salesianos.triana.ComiendoPorTriana.validation.annotation.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChangePasswordRequest {


    private String oldPassword;
    @ValidPassword
    private String newPassword;
    @ValidPassword
    private String verifyNewPassword;
}
