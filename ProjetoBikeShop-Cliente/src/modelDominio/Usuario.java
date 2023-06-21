
package modelDominio;

import java.io.Serializable;

public class Usuario implements Serializable{
    private static final long serialVersionUID = 123l;
    
    private int codeUsuario;
    private String nomeUsuario;
    private String login;
    private String senha;
    private String email;

    public Usuario(int codeUsuario) { //usado para delete
        this.codeUsuario = codeUsuario;
    }

    public Usuario(String nomeUsuario, String login, String senha, String email) { //usado para inserts
        this.nomeUsuario = nomeUsuario;
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    public Usuario(int codeUsuario, String nomeUsuario, String login, String senha, String email) { //usado para select e update
        this.codeUsuario = codeUsuario;
        this.nomeUsuario = nomeUsuario;
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    
    public int getCodeUsuario() {
        return codeUsuario;
    }

    public void setCodeUsuario(int codeUsuario) {
        this.codeUsuario = codeUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codeUsuario=" + codeUsuario + ", nomeUsuario=" + nomeUsuario + ", login=" + login + ", senha=" + senha + ", email=" + email + '}';
    }
    
    
}
