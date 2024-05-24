package app.block5crudvalidation.Persona.Application.Services;

import app.block5crudvalidation.Persona.Domain.Entities.Persona;
import java.util.List;

public interface PersonaService {

    Persona findById(Long id);

    Persona save(Persona persona);

    void deleteById(Long id);

    List<Persona> findAll();

    void saveAll(List<Persona> personas);

}
