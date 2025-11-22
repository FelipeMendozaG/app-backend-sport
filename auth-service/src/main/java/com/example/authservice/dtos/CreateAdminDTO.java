package com.example.authservice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAdminDTO {
    private Long id;
    @NotNull(message = "User ID es requerido")
    @JsonProperty("user_id")
    private Long userId;
    private String userName;
    @NotNull(message = "Access Level es requerido")
    @JsonProperty("accessLevel")
    private AccessLevel accessLevel = AccessLevel.PRIVATE;
}
