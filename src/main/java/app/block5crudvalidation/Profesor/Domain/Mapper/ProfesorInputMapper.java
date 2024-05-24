package app.block5crudvalidation.Profesor.Domain.Mapper;


import app.block5crudvalidation.Profesor.Domain.Entities.Profesor;
import app.block5crudvalidation.Profesor.Infraestructure.DTO.ProfesorInputDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfesorInputMapper {
    Profesor profesorDtoToProfesor(ProfesorInputDTO dto);
    ProfesorInputDTO profesorToProfesorDto(Profesor profesor);
}
