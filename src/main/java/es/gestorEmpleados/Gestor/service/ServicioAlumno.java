package es.gestorEmpleados.Gestor.service;

import es.gestorEmpleados.Gestor.model.Alumno;
import es.gestorEmpleados.Gestor.exceptions.AlumnoException;

import java.util.List;

public interface ServicioAlumno {
    List<Alumno> obtenerTodosLosAlumnos();
    void crearAlumno(Alumno alumno);
    void modificarAlumno(Alumno alumno);
    void  eliminarAlumno(int id);

    Alumno obtenerAlumnoPorId(int id) throws AlumnoException;

}