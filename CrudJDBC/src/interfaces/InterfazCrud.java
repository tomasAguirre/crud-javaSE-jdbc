
package interfaces;

import java.util.List;

public interface InterfazCrud {
    List<Iparametro> consulta();

    void elimina(Iparametro p);

    void inserta(Iparametro p);

    void modifica(Iparametro p);
}
