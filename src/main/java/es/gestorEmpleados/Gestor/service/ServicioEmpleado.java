package es.gestorEmpleados.Gestor.service;

import es.gestorEmpleados.Gestor.exceptions.EmpleadoException;
import es.gestorEmpleados.Gestor.model.Empleado;

import java.util.List;

public interface ServicioEmpleado {
    List<Empleado> obtenerTodosLosEmpleados();
    void crearEmpleado(Empleado empleado);
    void modificarEmpleado(Empleado empleado);
    void  eliminarEmpleado(int id);

    Empleado obtenerEmpleadoPorId(int id) throws EmpleadoException;
}
