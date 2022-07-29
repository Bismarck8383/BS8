package com.bosonit.BS8.BS8.infraestructura.repositorio;

import com.bosonit.BS8.BS8.dominio.EntityPersona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepositorio extends JpaRepository<EntityPersona, Integer> {

}
