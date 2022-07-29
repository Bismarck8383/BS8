package com.bosonit.BS8.BS8.aplicacion;

import com.bosonit.BS8.BS8.aplicacion.port.UpdatePersonaI;
import com.bosonit.BS8.BS8.dominio.EntityPersona;
import com.bosonit.BS8.BS8.infraestructura.dtos.input.PersonaInputDTO;
import com.bosonit.BS8.BS8.infraestructura.dtos.output.PersonaOutputDTO;
import com.bosonit.BS8.BS8.infraestructura.exceptions.NotFoundException;
import com.bosonit.BS8.BS8.infraestructura.repositorio.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class UpdatePersonaUse implements UpdatePersonaI {
    @Autowired
    PersonaRepositorio personaRepositorio;

    @Override
    public PersonaOutputDTO updatePersona(int id_persona, PersonaInputDTO personaInputDTO)throws NotFoundException {
        EntityPersona persona;
        persona = personaRepositorio.findById(id_persona)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_ACCEPTABLE));
        persona.actualizarDatos(personaInputDTO);
        personaRepositorio.save(persona);
        return new PersonaOutputDTO(persona);
    }

}
