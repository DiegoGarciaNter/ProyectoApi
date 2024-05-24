package app.block5crudvalidation.Profesor.Infraestructure.Repository;

import app.block5crudvalidation.Profesor.Domain.Entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
