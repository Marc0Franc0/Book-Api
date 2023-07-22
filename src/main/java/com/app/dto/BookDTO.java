package com.app.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BookDTO {
    @NotBlank(message = "Verificar nombre")
    String name;
    @NotBlank(message = "Verificar autor")
    String author;
}
