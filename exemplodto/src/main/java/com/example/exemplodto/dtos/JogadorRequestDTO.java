package com.example.exemplodto.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record JogadorRequestDTO(
        @NotBlank @Size(min = 3) String nome,
        @NotBlank String apelido,
        @Min(value = 18) Integer idade
) {}
