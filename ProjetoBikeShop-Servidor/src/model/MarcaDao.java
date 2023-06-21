package model;

import com.mysql.cj.xdevapi.PreparableStatement;
import factory.Conector;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelDominio.Marca;

/*Dao = data acess object*/
public class MarcaDao {

    private Connection con;

    public MarcaDao() {
        con = Conector.getConnection();
    }

    public ArrayList<Marca> getMarcaLista() {
        ArrayList<Marca> lista = new ArrayList<>();
        Statement stmt = null;
        /*Statement executa um script sem parametro*/

        try {
            String sql = "select * from marca";
            //Criando o Statement para executar o script sql
            stmt = con.createStatement();
            //Executar o script sql
            ResultSet res = stmt.executeQuery(sql);
            //Percorrer o resultado
            while (res.next()) {
                //Criando um objeto de marca
                Marca m = new Marca(res.getInt("codmarca"), res.getString("nomemarca"));
                //Adicionar essa marca na lista
                lista.add(m);
                System.out.println(m);
            }
            //fechando conexões dos objetos
            res.close();
            stmt.close();
            con.close();
            //devolvendo a lista
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Marca> getMarcaListaNome(String nome){
        ArrayList<Marca> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        
        try {
            //com false eu tenho controle das transações
            con.setAutoCommit(false);
            String sql = "SELECT * FROM marca WHERE nomemarca LIKE ?";
            
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%"+nome+"%");
            stmt.executeQuery();
            ResultSet res = stmt.executeQuery(sql);
            //Percorrer o resultado
            while (res.next()) {
                //Criando um objeto de marca
                Marca m = new Marca(res.getInt("codmarca"), res.getString("nomemarca"));
                //Adicionar essa marca na lista
                lista.add(m);
                System.out.println(m);
            }
            //fechando conexões dos objetos
            res.close();
            stmt.close();
            con.close();
            //efetivar a transação
            con.commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
        return lista;
    }

    //método que realiza o Insert na tabela de marca
    //retorna true se deu certo, ou false se ocorreu erro.
    public boolean inserir(Marca m) {
        PreparedStatement stmt = null;

        try {
            //com false eu tenho controle das transações
            con.setAutoCommit(false);
            String sql = "insert into marca (nomemarca) " + "values (?)";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, m.getNomeMarca());
            stmt.execute();
            //efetivar a transação
            con.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return false;
        } finally{//garante que esse código aqui dentro será sempre executado
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public boolean editar(Marca m){
        PreparedStatement stmt = null;
        
        try {
            con.setAutoCommit(false);
            String sql = "UPDATE marca SET nomemarca = ? WHERE codmarca = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, m.getNomeMarca());
            stmt.setInt(2, m.getCodMarca());
            stmt.execute();
            con.commit();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return false;
        } finally{
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }    
    }
    
    public boolean excluir(Marca m){
        PreparedStatement stmt = null;
        
        try {
            con.setAutoCommit(false);
            String sql = "DELETE from marca WHERE codmarca = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, m.getCodMarca());
            stmt.execute();
            con.commit();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return false;
        } finally{
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }    
    }

}
