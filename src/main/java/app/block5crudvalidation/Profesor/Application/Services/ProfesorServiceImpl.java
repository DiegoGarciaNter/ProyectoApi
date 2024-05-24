package app.block5crudvalidation.Profesor.Application.Services;

import app.block5crudvalidation.Persona.Domain.Exceptions.EntityNotFoundException;
import app.block5crudvalidation.Profesor.Domain.Entities.Profesor;
import app.block5crudvalidation.Profesor.Domain.Mapper.ProfesorInputMapper;
import app.block5crudvalidation.Profesor.Infraestructure.Repository.ProfesorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository profesorRepository;
    private final ProfesorInputMapper profesorMapper;

    @Override
    public Profesor findById(Long id) {
        return profesorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profesor no encontrado con id: " + id));
    }

    @Override
    public Profesor save(Profesor profesor) {
//        ValidationUtil.validateProfesor(profesor);
        return profesorRepository.save(profesor);
    }

    @Override
    public void deleteById(Long id) {
        if (!profesorRepository.existsById(id)) {
            throw new EntityNotFoundException("No se puede eliminar, Profesor no encontrado con id: " + id);
        }
        profesorRepository.deleteById(id);
    }

    @Override
    public List<Profesor> findAll() {
        return profesorRepository.findAll();
    }

    public List<Profesor> saveAll(List<Profesor> profesores) {
//        for (Profesor profesor : profesores) {
//            ValidationUtil.validateProfesor(profesor);
//        }
        return profesorRepository.saveAll(profesores);
    }

}
