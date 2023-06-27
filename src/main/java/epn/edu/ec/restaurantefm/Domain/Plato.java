package epn.edu.ec.restaurantefm.Domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "plato")
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "nombre", unique = true)
    @NotEmpty(message = "{NotEmpty.Plato.nombre}")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;

    @Column(name = "descripcion")
    @NotEmpty(message = "{NotEmpty.Plato.descripcion}")
    private String descripcion;

    @Column(name = "precio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor a 0")
    private double precio;

    @Column(name = "resena")
    @Size(max = 1000, message = "La reseña debe tener como máximo 1000 caracteres")
    private String resena;

    @Column(name = "puntuacion")
    @Min(value = 0, message = "La puntuación mínima permitida es 0")
    @Max(value = 5, message = "La puntuación máxima permitida es 5")
    private int puntuacion;
}