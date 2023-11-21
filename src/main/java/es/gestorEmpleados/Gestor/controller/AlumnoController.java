package es.gestorEmpleados.Gestor.controller;

import es.gestorEmpleados.Gestor.model.Alumno;
import es.gestorEmpleados.Gestor.service.ServicioAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class AlumnoController {
    private final ServicioAlumno servicioAlumno;
    @Autowired
    public AlumnoController(ServicioAlumno servicioAlumno) {
        this.servicioAlumno = servicioAlumno;
    }
    @GetMapping("/alumnos")
    public List<Alumno> obtenerTodosLosAlumnos() {
        return this.servicioAlumno.obtenerTodosLosAlumnos();
    }
    @GetMapping("/alumnos/{id}")
    public Alumno obtenerAlumnoPorId(@PathVariable int id) {
        return this.servicioAlumno.obtenerAlumnoPorId(id);
    }
    @PostMapping("/alumnos")
    public void crearAlumno(@RequestBody Alumno alumno) {
        this.servicioAlumno.crearAlumno(alumno);
    }
    @PutMapping("/alumnos")
    public void modificarAlumno(@RequestBody Alumno alumno) {
        this.servicioAlumno.modificarAlumno(alumno);
    }
    @DeleteMapping("/alumnos/{id}")
    public void eliminarAlumno(@PathVariable int id) {
        this.servicioAlumno.eliminarAlumno(id);
    }
}
