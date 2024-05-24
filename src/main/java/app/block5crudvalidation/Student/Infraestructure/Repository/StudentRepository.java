package app.block5crudvalidation.Student.Infraestructure.Repository;


import app.block5crudvalidation.Student.Domain.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
