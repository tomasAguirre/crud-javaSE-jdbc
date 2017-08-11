
package entidades;

import interfaces.Iparametro;

public class Empleado implements Iparametro{
    int id_empleado;
    String nombre_empleado;
    String apellido_empleado;
    int edad_empleado;

    public Empleado() {
    }

    public Empleado(int id_empleado, String nombre_empleado, String apellido_empleado, int edad_empleado) {
        this.id_empleado = id_empleado;
        this.nombre_empleado = nombre_empleado;
        this.apellido_empleado = apellido_empleado;
        this.edad_empleado = edad_empleado;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getApellido_empleado() {
        return apellido_empleado;
    }

    public void setApellido_empleado(String apellido_empleado) {
        this.apellido_empleado = apellido_empleado;
    }

    public int getEdad_empleado() {
        return edad_empleado;
    }

    public void setEdad_empleado(int edad_empleado) {
        this.edad_empleado = edad_empleado;
    }

    @Override
    public String toString() {
        return "empleado{" + "id_empleado=" + id_empleado + ", nombre_empleado=" + nombre_empleado + ", apellido_empleado=" + apellido_empleado + ", edad_empleado=" + edad_empleado + '}';
    }
    
}
