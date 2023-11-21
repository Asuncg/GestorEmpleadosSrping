package es.gestorEmpleados.Gestor.service;

import es.gestorEmpleados.Gestor.exceptions.AlumnoException;
import es.gestorEmpleados.Gestor.model.Alumno;
import es.gestorEmpleados.Gestor.repository.RepositorioAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioAlumnoImpl implements ServicioAlumno {

    private final RepositorioAlumno repositorioAlumno;

    @Autowired
    public ServicioAlumnoImpl(RepositorioAlumno repositorioAlumno) {
        this.repositorioAlumno = repositorioAlumno;
    }

    @Override
    public List<Alumno> obtenerTodosLosAlumnos() {
        return repositorioAlumno.findAll();
    }

    @Override
    public void crearAlumno(Alumno alumno) {

    }

    @Override
    public void modificarAlumno(Alumno alumno) {

    }

    @Override
    public void eliminarAlumno(int id) {

    }

    @Override
    public Alumno obtenerAlumnoPorId(int id) throws AlumnoException {
        return null;
    }
}
