package model;

//DAO vem de data acess object
import factory.Conector;
import java.sql.*;
import modelDominio.Administrador;
import modelDominio.Comum;
import modelDominio.Usuario;

//dentro dessa classe iremos implementar toda a comunicação com a tabela usuario
//do banco de dados, iremos usar aqui INSERTS, DELETE e UPDATE
public class UsuarioDao {

    private Connection con;

    public UsuarioDao() {
        con = Conector.getConnection();
    }

    public Usuario efetuarLogin(Usuario usr) {
        //criando uma variavel para rodar o script SQL
        PreparedStatement stmt = null; /*Statement executa um script com parametros*/
        //usuario selecionado do banco
        Usuario usrSel = null;
        try {
            String sql = "select * from usuario where "
                    + "login=? and senha=?";

            //criando o statement para substituir os parametros
            stmt = con.prepareCall(sql);
            //substituir os ?
            stmt.setString(1, usr.getLogin());
            stmt.setString(2, usr.getSenha());
            //executar o scipt SQL
            ResultSet res = stmt.executeQuery();
            //percorrer o res e montar o objeto de usuario
            //no qual pode ser um administrador ou um comum
            if (res.next()) {
                //o usuario existe, o login e senha estão corretos
                if (res.getInt("tipo") == 1) {
                    //é um administrador
                    System.out.println("O cara é um adm");
                    usrSel = new Administrador(res.getInt("codUsuario"),
                                               res.getString("nomeUsuario"),
                                               res.getString("login"),
                                               res.getString("senha"),
                                               res.getString("email"));
                } else {
                    //é um usuario comum
                    usrSel = new Comum(res.getInt("codUsuario"),
                                       res.getString("nomeUsuario"),
                                       res.getString("login"),
                                       res.getString("senha"),
                                       res.getString("email"));
                }
            }
            res.close(); //fechar o resultado
            stmt.close(); //fechar o statement
            con.close(); //fechar a conexão
            System.out.println(usrSel);
            return usrSel;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
