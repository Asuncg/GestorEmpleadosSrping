package es.gestorEmpleados.Gestor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@Table(name = "alumno")
@NoArgsConstructor
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String nombre;
    private  String apellidos ;
    private   String sexo;
    private  String nacionalidad;
    private  int edad;

}