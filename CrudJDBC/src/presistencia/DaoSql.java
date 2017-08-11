package presistencia;


import interfaces.InterfazCrud;
import interfaces.Iparametro;
//import java.sql.Connection;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static java.util.Collections.list;
import java.util.List;


public abstract class DaoSql implements InterfazCrud{
    
    public abstract void definirContenidoParamentroInsertar(PreparedStatement ps, Iparametro p);
    
    public abstract void definirContenidoParametroEliminar(PreparedStatement ps, Iparametro p);
    
    public abstract void definirContenidoParamentroModificar(PreparedStatement ps, Iparametro p);
    
    public abstract void definirContenidoParamentroConsultar(PreparedStatement ps, Iparametro p);
    
    public abstract String definirComandoInsertar();
    
    public abstract String definirComandoEliminar();
    
    public abstract String definirComandoModificar();
    
    public abstract String definirComandoConsultar();
    
    public abstract List<Iparametro> cargarDatos(ResultSet r);
    
    public Connection cargarConexion() {
        Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa?user=root&password=root");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cn;
    }
    
    
    public void insertar(Iparametro p) {
        PreparedStatement psx = null;
        try {
            psx = this.cargarConexion().prepareStatement(definirComandoInsertar());
            definirContenidoParamentroInsertar(psx, p);
            psx.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void eliminar(Iparametro p) {
        PreparedStatement psx = null;
        try {
            psx = this.cargarConexion().prepareStatement(definirComandoEliminar());
            definirContenidoParametroEliminar(psx, p);
            psx.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void modificar(Iparametro p) {
       PreparedStatement psx = null; 
        try {
            psx = this.cargarConexion().prepareStatement(definirComandoModificar());
            definirContenidoParamentroModificar(psx, p);
            psx.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Iparametro> consulta() {
        PreparedStatement psx = null;
        List<Iparametro> lista = null;
        ResultSet rs = null;
        try {
            psx = this.cargarConexion().prepareStatement(definirComandoConsultar());
            rs = psx.executeQuery();
            lista = cargarDatos(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
