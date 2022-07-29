package com.bosonit.BS8.BS8.aplicacion.port;

import com.bosonit.BS8.BS8.infraestructura.dtos.input.PersonaInputDTO;
import com.bosonit.BS8.BS8.infraestructura.dtos.output.PersonaOutputDTO;
import com.bosonit.BS8.BS8.infraestructura.exceptions.UnprocesableException;

public interface CrearPersonaI {
    PersonaOutputDTO addPersona(PersonaInputDTO personaInputDTO) throws Exception;
}
