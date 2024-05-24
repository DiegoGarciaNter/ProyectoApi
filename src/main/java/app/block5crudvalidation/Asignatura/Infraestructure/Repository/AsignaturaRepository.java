package app.block5crudvalidation.Asignatura.Infraestructure.Repository;

import app.block5crudvalidation.Asignatura.Domain.Entities.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
}
