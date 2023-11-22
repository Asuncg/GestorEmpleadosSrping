package es.gestorEmpleados.Gestor.exceptions;

public class EmpleadoException extends RuntimeException{

    private static final long serialVersionUID = 1234567890;
    public EmpleadoException(String msg) {
        super(msg);
    }

}
