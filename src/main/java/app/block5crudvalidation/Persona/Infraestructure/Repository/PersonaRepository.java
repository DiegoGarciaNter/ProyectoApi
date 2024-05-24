package app.block5crudvalidation.Persona.Infraestructure.Repository;

import app.block5crudvalidation.Persona.Domain.Entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
