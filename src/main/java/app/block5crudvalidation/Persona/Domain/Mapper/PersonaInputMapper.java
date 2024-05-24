package app.block5crudvalidation.Persona.Domain.Mapper;

import app.block5crudvalidation.Persona.Domain.Entities.Persona;
import app.block5crudvalidation.Persona.Infraestructure.DTO.PersonaInputDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonaInputMapper {
    PersonaInputDTO InputPersonaToPersonaDto(Persona persona);
    Persona InputPersonaDtoToPersona(PersonaInputDTO personaDto);
}
