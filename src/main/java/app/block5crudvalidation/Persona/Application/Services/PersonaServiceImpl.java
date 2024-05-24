package app.block5crudvalidation.Persona.Application.Services;

import app.block5crudvalidation.Persona.Domain.Entities.Persona;
import app.block5crudvalidation.Persona.Domain.Exceptions.EntityNotFoundException;
import app.block5crudvalidation.Persona.Domain.Exceptions.ValidationUtil;
import app.block5crudvalidation.Persona.Domain.Mapper.PersonaInputMapper;
import app.block5crudvalidation.Persona.Infraestructure.Repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;
    private final PersonaInputMapper personaMapper;

    @Override
    public Persona findById(Long id) {
        return personaRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new EntityNotFoundException("Persona no encontrada con id: " + id));
    }

    @Override
    public Persona save(Persona persona) {
        ValidationUtil.validatePersona(persona);
        return personaRepository.save(persona);
    }

    @Override
    public void deleteById(Long id) {
        if (!personaRepository.existsById(Math.toIntExact(id))) {
            throw new EntityNotFoundException("No se puede eliminar, Persona no encontrada con id: " + id);
        }
        personaRepository.deleteById(Math.toIntExact(id));
    }

    @Override
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public void saveAll(List<Persona> personas) {
        for (Persona persona : personas) {
            ValidationUtil.validatePersona(persona);
        }
        personaRepository.saveAll(personas);
    }

}
