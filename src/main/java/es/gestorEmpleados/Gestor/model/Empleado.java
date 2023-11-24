package es.gestorEmpleados.Gestor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Asun C.G
 * La clase Empleado extiende de la clase Persona añadiendo categoría y anyos.
 */
@Entity
@AllArgsConstructor
@Data
@Table(name = "empleado")
@NoArgsConstructor

public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    private int categoria;
    public double anyos;
    private int alta;
    public String nombre;
    public String dni;
    public Character sexo;

}
