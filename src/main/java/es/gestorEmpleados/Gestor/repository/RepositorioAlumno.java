package es.gestorEmpleados.Gestor.repository;

import es.gestorEmpleados.Gestor.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioAlumno extends JpaRepository<Alumno, Integer> {


}