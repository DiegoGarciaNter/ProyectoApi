package app.block5crudvalidation.Profesor.Domain.Entities;

import app.block5crudvalidation.Persona.Domain.Entities.Persona;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "profesor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    @Column(name = "coments")
    private String coments;

    @Enumerated(EnumType.STRING)
    @Column(name = "branch", nullable = false)
    private Branch branch;

}
