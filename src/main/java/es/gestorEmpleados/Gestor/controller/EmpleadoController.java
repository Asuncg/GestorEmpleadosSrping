package es.gestorEmpleados.Gestor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import es.gestorEmpleados.Gestor.model.Empleado;
import es.gestorEmpleados.Gestor.service.ServicioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("/empleados")
    public String obtenerTodosLosEmpleados(Model model) {
        List<Empleado> empleados = this.servicioEmpleado.obtenerTodosLosEmpleados();
        model.addAttribute("empleados", empleados);
        return "empleados";
    }
    @GetMapping("/empleados/{id}")
    public Empleado obtenerEmpleadoPorId(@PathVariable int id) {
        return this.servicioEmpleado.obtenerEmpleadoPorId(id);
    }
    @PostMapping("/empleados")
    public String crearEmpleado(@ModelAttribute Empleado empleado) {
        this.servicioEmpleado.crearEmpleado(empleado);
        return "redirect:/empleados";
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
