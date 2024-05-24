package app.block5crudvalidation.Persona.Infraestructure.Controller;

import app.block5crudvalidation.Persona.Application.Services.PersonaService;
import app.block5crudvalidation.Persona.Domain.Entities.Persona;
import app.block5crudvalidation.Persona.Domain.Mapper.PersonaInputMapper;
import app.block5crudvalidation.Persona.Domain.Mapper.PersonaOutputMapper;
import app.block5crudvalidation.Persona.Infraestructure.DTO.PersonaInputDTO;
import app.block5crudvalidation.Persona.Infraestructure.DTO.PersonaOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaInputMapper personaInputMapper;
    private final PersonaOutputMapper personaOutputMapper;
    private final PersonaService personaService;

    @GetMapping
    public ResponseEntity<?> getAllPersonas() {
        List<Persona> result = personaService.findAll();
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            List<PersonaOutputDTO> dtoList = result.stream()
                    .map(personaOutputMapper::OutputPersonaToPersonaDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaOutputDTO> getPersonaById(@PathVariable Long id) {
        Persona persona = personaService.findById(id);
        return ResponseEntity.ok(personaOutputMapper.OutputPersonaToPersonaDto(persona));
    }

    @PostMapping
    public List<PersonaInputDTO> createAll(@RequestBody List<Persona> personas) {
        personaService.saveAll(personas);
        return personas.stream()
                .map(personaInputMapper::InputPersonaToPersonaDto)
                .collect(Collectors.toList());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable Long id, @RequestBody Persona personaDetails) {
        Persona persona = personaService.findById(id);
        persona.setUsuario(personaDetails.getUsuario());
        persona.setPassword(personaDetails.getPassword());
        persona.setName(personaDetails.getName());
        persona.setSurname(personaDetails.getSurname());
        persona.setCompany_email(personaDetails.getCompany_email());
        persona.setPersonal_email(personaDetails.getPersonal_email());
        persona.setCity(personaDetails.getCity());
        persona.setActive(personaDetails.isActive());
        persona.setCreated_date(personaDetails.getCreated_date());
        persona.setImagen_url(personaDetails.getImagen_url());
        persona.setTermination_date(personaDetails.getTermination_date());

        Persona updatedPersona = personaService.save(persona);
        return ResponseEntity.ok(updatedPersona);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Persona> deletePersona(@PathVariable Long id) {
        Persona persona = personaService.findById(id);
        personaService.deleteById(id);
        return ResponseEntity.ok(persona);
    }
}
