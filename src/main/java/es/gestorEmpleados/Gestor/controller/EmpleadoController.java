package es.gestorEmpleados.Gestor.controller;

import es.gestorEmpleados.Gestor.model.Empleado;
import es.gestorEmpleados.Gestor.model.Sueldo;
import es.gestorEmpleados.Gestor.service.ServicioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpleadoController {
    private final ServicioEmpleado servicioEmpleado;

    @Autowired
    public EmpleadoController(ServicioEmpleado servicioEmpleado) {
        this.servicioEmpleado = servicioEmpleado;
    }

    @GetMapping("/")
    public String mostrarPaginaInicio() {
        return "index";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrearEmpleado() {
        return "crear";
    }

    @GetMapping("/buscar")
    public String mostrarPaginaBuscar() {
        return "buscarEmpleados";
    }

    @GetMapping("/buscar-sueldo")
    public String mostrarFormularioBuscarSueldo() {
        return "buscarsueldoempleado";
    }

    @GetMapping("/empleados")
    public String obtenerTodosLosEmpleados(Model model) {
        List<Empleado> empleados = this.servicioEmpleado.obtenerTodosLosEmpleados();
        model.addAttribute("empleados", empleados);
        return "empleados";
    }

    @PostMapping("/empleados")
    public String crearEmpleado(@ModelAttribute Empleado empleado) {
        this.servicioEmpleado.crearEmpleado(empleado);
        return "redirect:/empleados";
    }

    @PostMapping("/buscar/dni")
    public String buscarEmpleadoPorDni(@RequestParam String dni, Model model) {
        Empleado empleado = this.servicioEmpleado.obtenerEmpleadoPorDni(dni);
        if (empleado != null) {
            model.addAttribute("empleado", empleado);
            return "resultadoBusqueda";
        } else {
            return "empleadonoencontrado";
        }
    }

    // Agregar método para procesar la búsqueda por Nombre
    @PostMapping("/buscar/nombre")
    public String buscarEmpleadoPorNombre(@RequestParam String nombre, Model model) {
        Empleado empleado = this.servicioEmpleado.obtenerEmpleadoPorNombre(nombre);
        if (empleado != null) {
            model.addAttribute("empleado", empleado);
            return "resultadoBusqueda";
        } else {
            return "resultadoBusqueda";
        }
    }

    @PostMapping("/buscar-sueldo")
    public String buscarSueldoEmpleado(@RequestParam String dni, Model model) {
        Sueldo sueldo = this.servicioEmpleado.obtenerSueldoPorDni(dni);
        if (sueldo != null) {
            model.addAttribute("empleado", sueldo.getEmpleado());
            model.addAttribute("sueldo", sueldo);
            return "sueldoempleado";
        } else {
            return "empleadonoencontrado"; // Otra página de error si no se encuentra el sueldo
        }
    }

    @PutMapping("/empleados")
    public void modificarEmpleado(@ModelAttribute Empleado empleado) {
        this.servicioEmpleado.modificarEmpleado(empleado);
    }

    @DeleteMapping("/empleados/{id}")
    public void eliminarEmpleado(@PathVariable int id) {
        this.servicioEmpleado.eliminarEmpleado(id);
    }
}
