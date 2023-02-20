package com.salesianos.triana.ComiendoPorTriana.user.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.salesianos.triana.ComiendoPorTriana.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserResponse {

    protected String id;
    protected String username, fullName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    protected LocalDateTime createdAt;


    public static UserResponse fromUser(User user) {

        return UserResponse.builder()
                .id(user.getId().toString())
                .username(user.getUsername())
                .fullName(user.getFullName())
                .createdAt(user.getCreatedAt())
                .build();
    }

}
