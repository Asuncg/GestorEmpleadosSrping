package es.gestorEmpleados.Gestor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa los datos de un sueldo asociado a un empleado.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sueldo {

    private String dni;
    private double sueldo;

    /**
     * Obtiene el DNI del empleado asociado al sueldo.
     *
     * @return El DNI del empleado.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Obtiene el sueldo asociado al empleado.
     *
     * @return El sueldo del empleado.
     */
    public double getSueldo() {
        return sueldo;
    }

}
