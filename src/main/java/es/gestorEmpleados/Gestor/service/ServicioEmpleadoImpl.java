package es.gestorEmpleados.Gestor.service;

import es.gestorEmpleados.Gestor.exceptions.EmpleadoException;
import es.gestorEmpleados.Gestor.model.Empleado;
import es.gestorEmpleados.Gestor.repository.RepositorioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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
        Optional<Empleado> optionalEmpleado = repositorioEmpleado.findById(id);

        // Desempaqueta el Optional para obtener el Empleado
        Empleado empleado = optionalEmpleado.orElse(null);

        return empleado;
    }

    // Método para validar campos
    private void validarCampos(Empleado empleado) {
        // Implementa la lógica de validación aquí
    }

    @Override
    public void darDeBajaEmpleado(int id) {
        Optional<Empleado> optionalEmpleado = repositorioEmpleado.findById(id);
        if (optionalEmpleado.isPresent()) {
            Empleado empleado = optionalEmpleado.get();
            empleado.setAlta(0);
            repositorioEmpleado.save(empleado);
        }
    }

    @Override
    public void reactivarEmpleado(int id) {
        Optional<Empleado> optionalEmpleado = repositorioEmpleado.findById(id);
        if (optionalEmpleado.isPresent()) {
            Empleado empleado = optionalEmpleado.get();
            empleado.setAlta(1);
            repositorioEmpleado.save(empleado);
        }
    }


}