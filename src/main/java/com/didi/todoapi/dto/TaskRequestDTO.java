package com.didi.todoapi.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TaskRequestDTO {
    @NotBlank(message = "A descrição é obrigatória")
    private String description;

    @NotBlank(message = "O título é obrigatório")
    private String title;
}
