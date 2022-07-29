package com.bosonit.BS8.BS8.aplicacion.port;

import com.bosonit.BS8.BS8.infraestructura.exceptions.NotFoundException;

public interface DeletePersonaI {
    void deletePersona (int id_persona) throws NotFoundException;
}
