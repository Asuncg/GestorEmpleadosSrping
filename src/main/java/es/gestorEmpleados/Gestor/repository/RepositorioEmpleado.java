package es.gestorEmpleados.Gestor.repository;

import es.gestorEmpleados.Gestor.model.Empleado;
import es.gestorEmpleados.Gestor.model.Sueldo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  RepositorioEmpleado extends JpaRepository<Empleado, Integer> {
    Empleado findByDni(String dni);
    Empleado findByNombre(String nombre);

    Sueldo findSueldoByDni(String dni);


}
