package presistencia;


import entidades.Empleado;
import interfaces.Iparametro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class empleadoSQL extends DaoSql{

    public void definirContenidoParamentroInsertar(PreparedStatement ps, Iparametro p) {
        Empleado em = (Empleado) p;
        try {
            ps.setInt(1, em.getId_empleado());
            ps.setString(2, em.getNombre_empleado());
            ps.setString(3, em.getApellido_empleado());
            ps.setInt(4, em.getEdad_empleado());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void definirContenidoParametroEliminar(PreparedStatement ps, Iparametro p) {
        Empleado em = (Empleado) p;
        try {
            ps.setInt(1, em.getId_empleado());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void definirContenidoParamentroModificar(PreparedStatement ps, Iparametro p) {
        Empleado em = (Empleado) p;
        try {
            ps.setString(1, em.getNombre_empleado());
            ps.setString(2, em.getApellido_empleado());
            ps.setInt(3, em.getEdad_empleado());
            ps.setInt(4, em.getId_empleado());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void definirContenidoParamentroConsultar(PreparedStatement ps, Iparametro p) {
        Empleado em = (Empleado) p;
        try {
            ps.setInt(1, em.getId_empleado());
            ps.setString(2, em.getNombre_empleado());
            ps.setString(3, em.getApellido_empleado());
            ps.setInt(4, em.getEdad_empleado());
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

   
    public String definirComandoInsertar() {
        String comando = "";
        comando = "insert into empleado (id_empleado, nombre_empleado, apellido_empleado, edad_empleado)" +
                    "values (?,?,?,?)";
        return comando;
    }

    public String definirComandoEliminar() {
        String comando = "";
        comando = "delete from empleado where id_empleado = ?";
        return comando;
    }

    public String definirComandoModificar() {
        String comando = "";
        comando = "update empleado set nombre_empleado=?,apellido_empleado=?,"+
                    "edad_empleado=? where id_empleado=?";
        return comando;
    }

    public String definirComandoConsultar() {   
        String comando = "";
        comando = "select * from empleado";
        return comando;
    }

    public List<Iparametro> cargarDatos(ResultSet r) {
        List<Iparametro> lista = new ArrayList<Iparametro>();
       // Empleado em = new Empleado();
        try {
            while (r.next()) {
                Empleado em = new Empleado();
                em.setId_empleado(r.getInt("id_empleado"));
                em.setNombre_empleado(r.getString("nombre_empleado"));
                em.setApellido_empleado(r.getString("apellido_empleado"));
                em.setEdad_empleado(r.getInt("edad_empleado"));
                
                lista.add(em);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Iparametro> consulta() {
        return super.consulta();
    }

    @Override
    public void elimina(Iparametro p) {
        super.eliminar(p);
    }

    @Override
    public void inserta(Iparametro p) {
         super.insertar(p);
    }

    @Override
    public void modifica(Iparametro p) {
        super.modificar(p);
    }
    
}
