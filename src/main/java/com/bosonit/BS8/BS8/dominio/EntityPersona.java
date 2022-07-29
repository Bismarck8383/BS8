package com.bosonit.BS8.BS8.dominio;

import com.bosonit.BS8.BS8.infraestructura.dtos.input.PersonaInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.server.NotAcceptableStatusException;

import javax.persistence.*;
import java.util.Date;

@Table(name = "Persona")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntityPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_persona", nullable = false)
    int id_persona;
    @Column(name="usuario",length = 10, columnDefinition = "varchar", nullable = false)

    private String usuario;
    @Column(name="password",nullable = false)
    private String password;
    @Column(name ="name",nullable = false)
    private String name;
    @Column(name ="surname",nullable = false)
    private String surname;
    @Column(name="company_email",nullable = false)
    private String company_email;
    @Column(name="personal_email",nullable = false)
    private String personal_email;
    @Column(name="city",nullable = false)
    private String city;
    @Column(name="active",nullable = false)
    private boolean active;
    @Column(name="created_date",nullable = false)
    private Date created_date;
    @Column(name="image_url")
    private String imagen_url;
    @Column(name="termination_date")
    private Date termination_date;


    public EntityPersona(PersonaInputDTO personaInputDTO) {
        setId_persona(personaInputDTO.getId_persona());
        setUsuario(personaInputDTO.getUsuario());
        setPassword(personaInputDTO.getPassword());
        setName(personaInputDTO.getName());
        setSurname(personaInputDTO.getSurname());
        setCompany_email(personaInputDTO.getCompany_email());
        setPersonal_email(personaInputDTO.getPersonal_email());
        setCity(personaInputDTO.getCity());
        setActive(personaInputDTO.isActive());
        setCreated_date(personaInputDTO.getCreated_date());
        setImagen_url(personaInputDTO.getImagen_url());
        setTermination_date(personaInputDTO.getTermination_date());
    }

    public void actualizarDatos(PersonaInputDTO personaInputDTO) throws NotAcceptableStatusException {
        if (personaInputDTO.getUsuario() != null && personaInputDTO.getUsuario().length() <= 10 && personaInputDTO.getUsuario().length() >= 6) {
            setUsuario(personaInputDTO.getUsuario());
        }
        if (personaInputDTO.getName() != null) {
            setName(personaInputDTO.getName());
        }
        if (personaInputDTO.getPassword() != null) {
            setPassword(personaInputDTO.getPassword());
        }
        if (personaInputDTO.getCompany_email() != null) {
            setCompany_email(personaInputDTO.getCompany_email());
        }
        if (personaInputDTO.getPersonal_email() != null) {
            setPersonal_email(personaInputDTO.getPersonal_email());
        }
        if (personaInputDTO.getCity() != null) {
            setCity(personaInputDTO.getCity());
        }
        if (personaInputDTO.getSurname() != null) {
            setSurname(personaInputDTO.getSurname());
        }
        if (personaInputDTO.getImagen_url() != null) {
            setImagen_url(personaInputDTO.getImagen_url());
        }
    }
}
