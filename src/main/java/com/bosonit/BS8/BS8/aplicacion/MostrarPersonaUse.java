package com.bosonit.BS8.BS8.aplicacion;

import com.bosonit.BS8.BS8.aplicacion.port.MostrarPersonaI;
import com.bosonit.BS8.BS8.dominio.EntityPersona;
import com.bosonit.BS8.BS8.infraestructura.dtos.output.PersonaOutputDTO;
import com.bosonit.BS8.BS8.infraestructura.exceptions.NotFoundException;
import com.bosonit.BS8.BS8.infraestructura.repositorio.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Service
public class MostrarPersonaUse implements MostrarPersonaI {
    @Autowired
    PersonaRepositorio personaRepositorio;

    // Mostrar todas las Persona
    @Override
    public List<PersonaOutputDTO> mostrarTodos() throws Exception {
        List<PersonaOutputDTO> listaUsuarios = new ArrayList<>();

        personaRepositorio.findAll().forEach(persona -> {
            PersonaOutputDTO personaDTO = new PersonaOutputDTO(persona);
            listaUsuarios.add(personaDTO);
        });


        if (listaUsuarios.isEmpty()) {
            throw new Exception("No hay usuarios en la base de datos");
        }
        return listaUsuarios;
    }


    //Buscar por nombre
    @Override
    public  List<PersonaOutputDTO> mostrarNombre(String nombre)throws Exception{

        List<PersonaOutputDTO> listaUsuarios = new ArrayList<>();

        personaRepositorio.findAll().forEach(p -> {
            if (p.getName().equalsIgnoreCase(nombre)) {
                PersonaOutputDTO personaDTO = new PersonaOutputDTO(p);
                listaUsuarios.add(personaDTO);
            }
        });

        if (listaUsuarios.isEmpty()){
            throw new Exception("No hay registro con ese nombre");
        }
        return listaUsuarios;
    }

    //mostrar por id
    @Override
    public PersonaOutputDTO mostrarId(int id_persona) throws NotFoundException {
        EntityPersona personaAux;
        PersonaOutputDTO personaDTO;

        personaAux = personaRepositorio.findById(id_persona)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        personaDTO = new PersonaOutputDTO(personaAux);

        return personaDTO;
    }
}
