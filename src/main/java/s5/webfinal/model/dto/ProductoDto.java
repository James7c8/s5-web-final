package s5.webfinal.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
    private Long id;

    @NotBlank(message = "Es obligatorio incluir una descripción")
    @Size(min = 5, message = "La descripción tiene un mínimo de 5 caracteres")
    private String descripcion;

    @NotNull(message = "Si no hay existencia debe ponerle 0")
    private Integer existencia;

    @NotNull(message = "El precio debe tener un valor")
    private Double precio;

    private LocalDate fechaUltIngreso;
    private boolean disponible;

    @NotBlank(message = "La categoría no puede estar vacía")
    private String categoria;
}
