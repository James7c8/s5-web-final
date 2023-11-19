package s5.webfinal.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ProductoDto {
    private Long id;
    private String descripcion;
    private Integer existencia;
    private Double precio;
    private LocalDate fechaUltIngreso;
    private boolean disponible;
    private String categoria;
}
