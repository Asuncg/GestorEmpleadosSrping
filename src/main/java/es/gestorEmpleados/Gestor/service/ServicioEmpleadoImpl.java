package es.gestorEmpleados.Gestor.service;

import es.gestorEmpleados.Gestor.exceptions.EmpleadoException;
import es.gestorEmpleados.Gestor.model.Empleado;
import es.gestorEmpleados.Gestor.repository.RepositorioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEmpleadoImpl implements ServicioEmpleado {

    private RepositorioEmpleado repositorioEmpleado;

    @Autowired
    public ServicioEmpleadoImpl(RepositorioEmpleado repositorioEmpleado) {
        this.repositorioEmpleado = repositorioEmpleado;
    }

    @Override
    public List<Empleado> obtenerTodosLosEmpleados() {
        return repositorioEmpleado.findAll();
    }

    @Override
    public Empleado crearEmpleado(Empleado empleado) {
            return repositorioEmpleado.save(empleado);
    }

    @Override
    public void modificarEmpleado(Empleado empleado) {

    }

    @Override
    public void eliminarEmpleado(int id) {

    }

    @Override
    public Empleado obtenerEmpleadoPorId(int id) throws EmpleadoException {
        return null;
    }

}
