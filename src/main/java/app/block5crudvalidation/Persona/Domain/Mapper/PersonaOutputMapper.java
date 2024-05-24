package app.block5crudvalidation.Persona.Domain.Mapper;

import app.block5crudvalidation.Persona.Domain.Entities.Persona;
import app.block5crudvalidation.Persona.Infraestructure.DTO.PersonaOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonaOutputMapper {
    @Mapping(source = "id_persona", target = "id_persona")
    @Mapping(source = "usuario", target = "usuario")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    PersonaOutputDTO OutputPersonaToPersonaDto(Persona persona);

    Persona OutputPersonaDtoToPersona(PersonaOutputDTO personaDto);
}
