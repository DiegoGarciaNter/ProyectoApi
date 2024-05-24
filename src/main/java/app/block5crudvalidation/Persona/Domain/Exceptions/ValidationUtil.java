package app.block5crudvalidation.Persona.Domain.Exceptions;
import java.util.regex.Pattern;

import app.block5crudvalidation.Persona.Domain.Entities.Persona;

public class ValidationUtil {
    private static final Pattern email = Pattern.compile("^[A-Za-z0-9._%+-]+@gmail\\.com$");

    public static void validatePersona(Persona persona) {

        if (persona.getName().length() > 20 || persona.getName().length() < 4 ) {
            throw new UnprocessableEntityException("Problema con la longitud del  al insertar la entidad");
        }
        if (persona.getPassword().length() < 7 ) {
            throw new UnprocessableEntityException("Contraseña muy corta");
        }
        if (!email.matcher(persona.getCompany_email()).matches()) {
            throw new UnprocessableEntityException("El correo electrónico debe ser un correo de Gmail");
        }
        if (!email.matcher(persona.getPersonal_email()).matches()) {
            throw new UnprocessableEntityException("El correo electrónico debe ser un correo de Gmail");
        }
        if (persona.getName().isEmpty()  ) {
            throw new UnprocessableEntityException("El nombre no puede estar vacio");
        }

    }
}
