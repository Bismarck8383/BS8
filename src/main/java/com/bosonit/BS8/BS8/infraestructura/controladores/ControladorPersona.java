package com.bosonit.BS8.BS8.infraestructura.controladores;

import com.bosonit.BS8.BS8.aplicacion.port.CrearPersonaI;
import com.bosonit.BS8.BS8.aplicacion.port.DeletePersonaI;
import com.bosonit.BS8.BS8.aplicacion.port.MostrarPersonaI;
import com.bosonit.BS8.BS8.aplicacion.port.UpdatePersonaI;
import com.bosonit.BS8.BS8.infraestructura.dtos.input.PersonaInputDTO;
import com.bosonit.BS8.BS8.infraestructura.dtos.output.PersonaOutputDTO;
import com.bosonit.BS8.BS8.infraestructura.exceptions.NotFoundException;
import com.bosonit.BS8.BS8.infraestructura.exceptions.UnprocesableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class ControladorPersona {
    @Autowired
    DeletePersonaI deletePersonaI;
    @Autowired
    CrearPersonaI crearPersonaI;
    @Autowired
    UpdatePersonaI updatePersonaI;
    @Autowired
    MostrarPersonaI mostrarPersonaI;

    @GetMapping("/id/{id_persona}")
    public  ResponseEntity<PersonaOutputDTO> mostrarId(@PathVariable int id_persona) throws NotFoundException {
        mostrarPersonaI.mostrarId(id_persona);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<PersonaOutputDTO>> buscarTodos () throws Exception {
        return new ResponseEntity<>(mostrarPersonaI.mostrarTodos(), HttpStatus.OK);
    }
    @PostMapping("/addPersona")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonaOutputDTO addPersona (@RequestBody PersonaInputDTO personaInputDTO) throws Exception {
        return crearPersonaI.addPersona(personaInputDTO);
    }

    @DeleteMapping("/deletePersona/{id_persona}")
    public ResponseEntity<Object> deletePersona (@PathVariable int id_persona) throws NotFoundException {
        deletePersonaI.deletePersona(id_persona);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/updatePersona/{id_persona}")
    public ResponseEntity<Object> updatePersona (@PathVariable int id_persona, @RequestBody PersonaInputDTO personaInputDTO) throws NotFoundException {
        updatePersonaI.updatePersona(id_persona, personaInputDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void checkPersona(PersonaInputDTO personaInputDTO){
        if(personaInputDTO == null){
            throw new UnprocesableException("No se puede introducir una persona sin información");
        }
        if (personaInputDTO.getUsuario() == null || personaInputDTO.getUsuario().isBlank()) {
            throw new UnprocesableException("El campo Usuario no puede ser nulo ni estar vacío");
        }
        if (personaInputDTO.getUsuario().length() > 10) {
            throw new UnprocesableException("El campo Usuario debe tener como máximo 10 caracteres de longitud");
        }
        if (personaInputDTO.getUsuario().length() < 6) {
            throw new UnprocesableException("El campo Usuario debe tener como mínimo 6 caracteres de longitud");
        }
        if (personaInputDTO.getPassword() == null || personaInputDTO.getPassword().isBlank()) {
            throw new UnprocesableException("El campo Password no puede ser nulo ni estar vacío");
        }
        if (personaInputDTO.getName() == null || personaInputDTO.getName().isBlank()) {
            throw new UnprocesableException("El campo nombre no puede ser nulo ni estar vacío");
        }
        if (personaInputDTO.getCompany_email() == null || personaInputDTO.getCompany_email().isBlank()) {
            throw new UnprocesableException("El campo Company_Email no puede ser nulo ni estar vacío");
        }
        if (personaInputDTO.getPersonal_email() == null || personaInputDTO.getPersonal_email().isBlank()) {
            throw new UnprocesableException("El campo Personal_Email no puede ser nulo ni estar vacío");
        }
        if (personaInputDTO.getCity() == null || personaInputDTO.getCity().isBlank()) {
            throw new UnprocesableException("El campo Ciudad no puede ser nulo ni estar vacío");
        }
        if (personaInputDTO.getCreated_date() == null) {
            throw new UnprocesableException("El campo Created-Date no puede ser nulo ni estar vacío");
        }
    }


}
