package app.block5crudvalidation.Student.Domain.Entities;


import app.block5crudvalidation.Persona.Domain.Entities.Persona;
import app.block5crudvalidation.Profesor.Domain.Entities.Branch;
import app.block5crudvalidation.Profesor.Domain.Entities.Profesor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    @Column(name = "num_hours_week", nullable = false)
    private int numHoursWeek;

    @Column(name = "coments")
    private String coments;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    @Enumerated(EnumType.STRING)
    @Column(name = "branch", nullable = false)
    private Branch branch;

}
