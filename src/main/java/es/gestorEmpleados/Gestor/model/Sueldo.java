package es.gestorEmpleados.Gestor.model;

import es.gestorEmpleados.Gestor.model.Empleado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sueldo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "dni_empleado")
    private String dni;

    private double sueldo;

    @OneToOne
    @JoinColumn(name = "empleado_id", referencedColumnName = "id")
    private Empleado empleado;
}
