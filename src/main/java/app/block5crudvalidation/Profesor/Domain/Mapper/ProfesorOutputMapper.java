package app.block5crudvalidation.Profesor.Domain.Mapper;

import app.block5crudvalidation.Persona.Domain.Entities.Persona;
import app.block5crudvalidation.Persona.Infraestructure.DTO.PersonaOutputDTO;
import app.block5crudvalidation.Profesor.Domain.Entities.Profesor;
import app.block5crudvalidation.Profesor.Infraestructure.DTO.ProfesorOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfesorOutputMapper {
    ProfesorOutputDTO OutputProfesorToProfesorDto(Profesor profesor);
    Profesor OutputProfesorDtoToProfesor(ProfesorOutputDTO profesor);
}
