package app.block5crudvalidation.Persona.Domain.Entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomError {
    private Date timestamp;
    private int HttpCode;
    private String mensaje;

}
