package app.block5crudvalidation.Profesor.Infraestructure.DTO;

import app.block5crudvalidation.Persona.Domain.Entities.Persona;
import app.block5crudvalidation.Profesor.Domain.Entities.Branch;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorInputDTO {
    private Long personaId;
    private String coments;
    private Branch branch;
}