
package modelDominio;

import java.io.Serializable;

public class Comum extends Usuario implements Serializable{
    private static final long serialVersionUID = 123l;

    public Comum(int codeUsuario) {
        super(codeUsuario);
    }

    public Comum(String nomeUsuario, String login, String senha, String email) {
        super(nomeUsuario, login, senha, email);
    }

    public Comum(int codeUsuario, String nomeUsuario, String login, String senha, String email) {
        super(codeUsuario, nomeUsuario, login, senha, email);
    }

    public Comum(String login, String senha) {
        super(login, senha);
    }

    @Override
    public String toString() {
        return super.toString()+"Comum{" + '}';
    }
    
    
    
}
