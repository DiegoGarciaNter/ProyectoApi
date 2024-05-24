package app.block5crudvalidation.Asignatura.Domain.Entities;

import app.block5crudvalidation.Student.Domain.Entities.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "asignatura")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_student", nullable = false)
    private Student student;

    @Column(name = "asignatura")
    private String asignatura;

    @Column(name = "coment")
    private String coment;

    @Column(name = "initialDate", nullable = false)
    private Date initialDate;

    @Column(name = "finishDate", nullable = false)
    private Date finishDate;

}
