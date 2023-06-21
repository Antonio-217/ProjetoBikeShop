package modelDominio;

import java.io.Serializable;

public class Marca implements Serializable {

    private static final long serialVersionUID = 123l;

    private int codMarca;
    private String nomeMarca;

    public Marca(int codMarca) { //será utilizado para fazer delete
        this.codMarca = codMarca;
    }

    public Marca(String nomeMarca) { //será utilizado para insert
        this.nomeMarca = nomeMarca;
    }

    public Marca(int codMarca, String nomeMarca) { //será usado para update e select
        this.codMarca = codMarca;
        this.nomeMarca = nomeMarca;
    }

    @Override
    public String toString() {
        return "Marca{" + "codMarca=" + codMarca + ", nomeMarca=" + nomeMarca + '}';
    }

    public int getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(int codMarca) {
        this.codMarca = codMarca;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

}
