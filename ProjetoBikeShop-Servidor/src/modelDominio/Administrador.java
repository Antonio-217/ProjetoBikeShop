package modelDominio;

import java.io.Serializable;

public class Administrador extends Usuario implements Serializable {

    private static final long serialVersionUID = 123l;

    public Administrador(int codeUsuario) {
        super(codeUsuario);
    }

    public Administrador(String nomeUsuario, String login, String senha, String email) {
        super(nomeUsuario, login, senha, email);
    }

    public Administrador(int codeUsuario, String nomeUsuario, String login, String senha, String email) {
        super(codeUsuario, nomeUsuario, login, senha, email);
    }

    public Administrador(String login, String senha) {
        super(login, senha);
    }

    @Override
    public String toString() {
        return super.toString() + "Administrador{" + '}';
    }

}
