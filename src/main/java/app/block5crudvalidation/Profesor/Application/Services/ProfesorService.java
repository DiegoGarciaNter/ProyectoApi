package app.block5crudvalidation.Profesor.Application.Services;

import java.util.List;
import app.block5crudvalidation.Profesor.Domain.Entities.Profesor;

public interface ProfesorService {

    Profesor findById(Long id);

    Profesor save(Profesor profesor);

    void deleteById(Long id);

    List<Profesor> findAll();

    List<Profesor> saveAll(List<Profesor> profesor);

}
