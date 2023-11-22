package es.gestorEmpleados.Gestor.repository;

import es.gestorEmpleados.Gestor.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  RepositorioEmpleado extends JpaRepository<Empleado, Integer> {
}
