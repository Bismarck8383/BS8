package com.bosonit.BS8.BS8.aplicacion;

import com.bosonit.BS8.BS8.aplicacion.port.DeletePersonaI;
import com.bosonit.BS8.BS8.dominio.EntityPersona;
import com.bosonit.BS8.BS8.infraestructura.exceptions.NotFoundException;
import com.bosonit.BS8.BS8.infraestructura.repositorio.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class DeletePersonaUse implements DeletePersonaI {
    @Autowired
    PersonaRepositorio personaRepositorio;

    @Override
    public void deletePersona(int id_persona) throws NotFoundException {

        EntityPersona personadel;
        personadel = personaRepositorio.findById(id_persona)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_ACCEPTABLE));
        personaRepositorio.deleteById(id_persona);
    }
}
