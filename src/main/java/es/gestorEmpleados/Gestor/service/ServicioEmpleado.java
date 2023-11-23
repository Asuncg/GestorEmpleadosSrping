package es.gestorEmpleados.Gestor.service;

import es.gestorEmpleados.Gestor.exceptions.EmpleadoException;
import es.gestorEmpleados.Gestor.model.Empleado;
import es.gestorEmpleados.Gestor.model.Sueldo;

import java.util.List;

public interface ServicioEmpleado {
    List<Empleado> obtenerTodosLosEmpleados();

    Empleado crearEmpleado(Empleado empleado);

    void modificarEmpleado(Empleado empleado);

    void eliminarEmpleado(int id);

    Empleado obtenerEmpleadoPorDni(String dni) throws EmpleadoException;
    Empleado obtenerEmpleadoPorNombre(String nombre);

    Sueldo obtenerSueldoPorDni(String dni);

}