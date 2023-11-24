package es.gestorEmpleados.Gestor.controller;

import es.gestorEmpleados.Gestor.model.Empleado;
import es.gestorEmpleados.Gestor.model.Sueldo;
import es.gestorEmpleados.Gestor.service.ServicioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @GetMapping("/darDeBajaEmpleado/{id}")
    public String darDeBajaEmpleado(@PathVariable int id) {
        servicioEmpleado.darDeBajaEmpleado(id);
        return "redirect:/empleados";
    }

    @GetMapping("/reactivarEmpleado/{id}")
    public String reactivarEmpleado(@PathVariable int id) {
        servicioEmpleado.reactivarEmpleado(id);
        return "redirect:/empleados";
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

    @GetMapping("/modificarEmpleado/{id}")
    public String mostrarFormularioModificar(@PathVariable int id, Model model) {
        Empleado empleado = this.servicioEmpleado.obtenerEmpleadoPorId(id);
        model.addAttribute("empleado", empleado);
        return "modificarempleado";
    }


    // Agregar método para procesar la búsqueda por Nombre
    @PostMapping("/buscar/nombre")
    public String buscarEmpleadoPorNombre(@RequestParam String nombre, Model model) {
        Empleado empleado = this.servicioEmpleado.obtenerEmpleadoPorNombre(nombre);
        if (empleado != null) {
            model.addAttribute("empleado", empleado);
            return "resultadoBusqueda";
        } else {
            return "empleadonoencontrado";
        }
    }

    @PostMapping("/buscar-sueldo")
    public String buscarSueldoEmpleadoPorDni(@RequestParam String dni, Model model) {
        Empleado empleado = this.servicioEmpleado.obtenerEmpleadoPorDni(dni);

        if (empleado != null) {
            Sueldo sueldo = new Sueldo();
            double sueldoEmpleado = sueldo.calculaSueldo(empleado.getCategoria(), empleado.anyos);
            model.addAttribute("sueldo", sueldoEmpleado);
            model.addAttribute("empleado", empleado);
            return "sueldoempleado";
        } else {
            return "empleadonoencontrado";
        }
    }


    @PutMapping("/empleados")
    public void modificarEmpleado(@ModelAttribute Empleado empleado) {
        this.servicioEmpleado.modificarEmpleado(empleado);
    }

    @PostMapping("/guardarCambios")
    public String guardarCambios(@ModelAttribute Empleado empleado, BindingResult bindingResult) {
        // Validar que no haya DNI duplicados y campos no vacíos
        // ...

        if (bindingResult.hasErrors()) {
            // Manejar los errores, por ejemplo, redirigir a una página de error
            return "error";
        }

        this.servicioEmpleado.modificarEmpleado(empleado);
        return "redirect:/empleados";
    }


    @DeleteMapping("/empleados/{id}")
    public void eliminarEmpleado(@PathVariable int id) {
        this.servicioEmpleado.eliminarEmpleado(id);
    }
}
