package epn.edu.ec.restaurantefm.Domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false)
    @NotEmpty(message = "Ingresa el nombre")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;

    @Column(name = "apellido", nullable = false)
    @NotEmpty(message = "Ingresa el Apellido")
    @Size(min = 3, max = 50, message = "El apellido debe tener entre 3 y 50 caracteres")
    private String apellido;

    @Column(name = "direccion", nullable = false)
    @NotEmpty(message = "Ingresa la Dirección")
    private String direccion;

    @Column(name = "telefono", nullable = false, length = 10)
    @NotEmpty(message = "Ingresa tu número telefónico")
    private String telefono;

    @Column(name = "correo_electronico", nullable = false)
    @NotEmpty(message = "Ingresa el correo electrónico")
    @Email(message = "El correo electrónico debe tener un formato válido")
    private String correo_electronico;


    @Column(name = "genero")
    @NotNull(message = "Selecciona la fecha de nacimiento")
    @NotEmpty(message = "Selecciona el género")
    private String genero;

    @Column(name = "numero_identificacion", unique = true, nullable = false)
    @NotEmpty(message = "Ingresa el número de identificación")
    private String numero_identificacion;
}
