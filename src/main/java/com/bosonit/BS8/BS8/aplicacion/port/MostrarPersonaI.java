package com.bosonit.BS8.BS8.aplicacion.port;

import com.bosonit.BS8.BS8.infraestructura.dtos.output.PersonaOutputDTO;
import com.bosonit.BS8.BS8.infraestructura.exceptions.NotFoundException;

import java.util.List;

public interface MostrarPersonaI {
    PersonaOutputDTO mostrarId(int id_persona) throws NotFoundException;

    // Mostrar todos las Persona
    List<PersonaOutputDTO> mostrarTodos() throws Exception;

    //Buscar por nombre
    List<PersonaOutputDTO> mostrarNombre(String nombre) throws  Exception;
}
