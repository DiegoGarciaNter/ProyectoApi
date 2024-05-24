package app.block5crudvalidation.Profesor.Infraestructure.Controller;

import app.block5crudvalidation.Persona.Application.Services.PersonaService;
import app.block5crudvalidation.Persona.Domain.Entities.Persona;
import app.block5crudvalidation.Profesor.Application.Services.ProfesorService;
import app.block5crudvalidation.Profesor.Domain.Entities.Branch;
import app.block5crudvalidation.Profesor.Domain.Entities.Profesor;
import app.block5crudvalidation.Profesor.Domain.Mapper.ProfesorInputMapper;
import app.block5crudvalidation.Profesor.Domain.Mapper.ProfesorOutputMapper;
import app.block5crudvalidation.Profesor.Infraestructure.DTO.ProfesorInputDTO;
import app.block5crudvalidation.Profesor.Infraestructure.DTO.ProfesorOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profesores")
public class ProfesorController {

    private final ProfesorInputMapper profesorInputMapper;
    private final ProfesorOutputMapper profesorOutputMapper;
    private final ProfesorService profesorService;
    private final PersonaService personaService;

    @GetMapping
    public ResponseEntity<?> getAllProfesores() {
        List<Profesor> result = profesorService.findAll();
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            List<ProfesorOutputDTO> dtoList = result.stream()
                    .map(profesorOutputMapper::OutputProfesorToProfesorDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorOutputDTO> getProfesorById(@PathVariable Long id) {
        Profesor profesor = profesorService.findById(id);
        ProfesorOutputDTO profesorDTO = profesorOutputMapper.OutputProfesorToProfesorDto(profesor);
        return ResponseEntity.ok(profesorDTO);
    }

    @PostMapping
    public List<ProfesorInputDTO> createAll(@RequestBody List<ProfesorInputDTO> profesorInputDTOs) {
        List<Profesor> profesores = profesorInputDTOs.stream().map(profesorInputDTO -> {
            Persona persona = personaService.findById(1L);
            Profesor profesor = profesorInputMapper.profesorDtoToProfesor(profesorInputDTO);
            profesor.setPersona(persona);
            profesor.setBranch(Branch.BACK);

            return profesor;
        }).collect(Collectors.toList());

        profesorService.saveAll(profesores);
        return profesores.stream()
                .map(profesorInputMapper::profesorToProfesorDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfesorOutputDTO> updateProfesor(@PathVariable Long id, @RequestBody ProfesorInputDTO profesorInputDTO) {
        Persona persona = personaService.findById(profesorInputDTO.getPersonaId());
        Profesor profesor = profesorService.findById(id);
        profesor.setPersona(persona);
        profesor.setComents(profesorInputDTO.getComents());
        profesor.setBranch(profesorInputDTO.getBranch());

        Profesor updatedProfesor = profesorService.save(profesor);
        ProfesorOutputDTO profesorOutputDTO = profesorOutputMapper.OutputProfesorToProfesorDto(updatedProfesor);
        return ResponseEntity.ok(profesorOutputDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProfesorOutputDTO> deleteProfesor(@PathVariable Long id) {
        Profesor profesor = profesorService.findById(id);
        profesorService.deleteById(id);
        ProfesorOutputDTO profesorOutputDTO = profesorOutputMapper.OutputProfesorToProfesorDto(profesor);
        return ResponseEntity.ok(profesorOutputDTO);
    }
}
