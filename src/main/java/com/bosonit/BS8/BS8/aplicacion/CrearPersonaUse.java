package com.bosonit.BS8.BS8.aplicacion;

import com.bosonit.BS8.BS8.aplicacion.port.CrearPersonaI;
import com.bosonit.BS8.BS8.dominio.EntityPersona;
import com.bosonit.BS8.BS8.infraestructura.dtos.input.PersonaInputDTO;
import com.bosonit.BS8.BS8.infraestructura.dtos.output.PersonaOutputDTO;
import com.bosonit.BS8.BS8.infraestructura.exceptions.UnprocesableException;
import com.bosonit.BS8.BS8.infraestructura.repositorio.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class CrearPersonaUse implements CrearPersonaI {
    @Autowired
    PersonaRepositorio personaRepositorio;


    @Override
    public PersonaOutputDTO addPersona(PersonaInputDTO personaInputDTO) throws Exception {
        EntityPersona persona = new EntityPersona(personaInputDTO);
        PersonaOutputDTO personaOutputDTO= new PersonaOutputDTO(persona);

        if (persona == null) {
            throw new Exception("Persona Sin datos");
        }
        personaRepositorio.saveAndFlush(persona);
        return personaOutputDTO;
    }
}
