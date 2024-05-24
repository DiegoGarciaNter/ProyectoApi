package app.block5crudvalidation.Persona.Infraestructure.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaOutputDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_persona;
    private String usuario;
    private String password;
    private String name;
    private String surname;
}
