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
        validarCampos(empleado);

        repositorioEmpleado.save(empleado);
    }

    @Override
    public void eliminarEmpleado(int id) {

    }


    @Override
    public Empleado obtenerEmpleadoPorDni(String dni) throws EmpleadoException {
        Empleado optionalEmpleado = repositorioEmpleado.findByDni(dni);
        return optionalEmpleado;
    }

    @Override
    public Empleado obtenerEmpleadoPorNombre(String nombre) {
        return repositorioEmpleado.findByNombre(nombre);
    }

    @Override
    public Empleado obtenerEmpleadoPorId(int id) {
        return null;
    }

    // Método para validar campos
    private void validarCampos(Empleado empleado) {
        // Implementa la lógica de validación aquí
    }

}
