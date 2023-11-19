package s5.webfinal.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Es obligatorio incluir una descripción")
    @Size(min = 5, message = "La descripción tiene un mínimo de 5 caracteres")
    @Column(nullable = false)
    private String descripcion;

    @NotNull(message = "Si no hay existencia debe ponerle 0")
    @Column(nullable = false)
    private Integer existencia;

    @Column(nullable = false)
    @NotNull(message = "El precio debe tener un valor")
    private Double precio;

    // Por defecto DATE se escribe yyyy-MM-dd
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "fecha_ultimo_ingreso")
    private LocalDate fechaUltIngreso;

    private boolean disponible;

    @Column(nullable = false)
    @NotBlank(message = "Si no hay categoria debe ponerle NA")
    private String categoria;
}
