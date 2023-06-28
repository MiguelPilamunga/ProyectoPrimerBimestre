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
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plato_id", nullable = false)
    private Plato plato;

    @Column(name = "cantidad")
    @Min(value = 1, message = "La cantidad mínima permitida es 1")
    private int cantidad;
}
