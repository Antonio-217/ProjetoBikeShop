package model;

import java.sql.*;
import factory.Conector;
import java.util.ArrayList;
import modelDominio.Bike;
import modelDominio.Marca;

public class BikeDao {
    
    private Connection con;
    
    public BikeDao(){
        con = Conector.getConnection();
    }
    
    public ArrayList<Bike> getLista(){
        Statement stmt = null;
        ArrayList<Bike> ListaBikes = new ArrayList<Bike>();
        
        try {
            //cria o objeto para rodar o sql
            stmt = con.createStatement();
            //passando a string sql que faz o select
            ResultSet res = stmt.executeQuery(" select bike.*, marca.nomemarca from bike "+
                                              " inner join marca on (marca.codmarca = bike.codmarca) "+
                                              " order by bike.codbike ");
            
            //percorrendo o resultado = res
            while (res.next()) {                
                Bike bk = new Bike(res.getInt("codbike"),
                res.getString("modelo"),
                new Marca(res.getInt("codmarca"), res.getString("nomemarca")),
                res.getDate("datalancamento"),
                res.getFloat("preco"),
                res.getBytes("imagem"));
                //adicionando na lista auxiliar
                ListaBikes.add(bk);
            }
            res.close();
            stmt.close();
            con.close();
            return ListaBikes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean inserir(Bike bk){
        //vai receber o sql de insert
        PreparedStatement stmt = null;
        try {
            con.setAutoCommit(false);
            String sql = "insert into bike (modelo, codmarca, preco, imagem, datalancamento) "
                    + " values (?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            //Substituir oa ? do script SQL
            stmt.setString(1, bk.getModelo());
            stmt.setInt(2, bk.getMarca().getCodMarca());
            stmt.setDouble(3, bk.getPreco());
            stmt.setBytes(4, bk.getImagem());
            stmt.setDate(5, new java.sql.Date(bk.getDataLancamento().getTime()));
            
            stmt.execute();
            //efetivar a transação
            con.commit();
            return true; //<- indica que deu tudo certo
            
        } catch (SQLException e) {
            try {
                con.rollback(); //cancelando a transação
                e.printStackTrace();
                return false;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        } finally { //isto será executado
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
    }
    
    public boolean alterar(Bike bk){
        //vai receber o script SQL de insert
        PreparedStatement stmt = null;
        try {
            //desliga o autocommit
            con.setAutoCommit(false);
            //o ? será substituido pelo valor
            String sql = "update bike set preco = ?, modelo = ?, codmarca = ?, "
                    + " imagem = ?, datalancamento = ? "
                    + " where codbike = ?";
            stmt = con.prepareStatement(sql);
            //substituir os ? do script SQL
            stmt.setDouble(1, bk.getPreco());
            stmt.setString(2, bk.getModelo());
            stmt.setInt(3, bk.getMarca().getCodMarca());
            stmt.setBytes(4, bk.getImagem());
            stmt.setDate(5, new java.sql.Date(bk.getDataLancamento().getTime()));
            stmt.setInt(6, bk.getCodBike());
            //executar o SCRIPT SQL
            stmt.execute();
            //efetivar a transação
            con.commit();
            return true;
        } catch (SQLException e) {
            try {
                con.rollback(); //cancelando a transação
                return false;
            } catch (SQLException ex) {
                return false;
            }
        } finally { //isto será executado
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                return false;
            }
        }
    }
    
    public boolean excluir(Bike bk){
        //vai receber o script SQL de insert
        PreparedStatement stmt = null;
        try {
            //desliga o autocommit
            con.setAutoCommit(false);
            //o ? será substituido pelo valor
            String sql = "delete from bike where codbike = ?";
            stmt = con.prepareStatement(sql);
            //substituir os ? do script SQL
            stmt.setInt(1, bk.getCodBike());
            //executar o SCRIPT SQL
            stmt.execute();
            //efetivar a transação
            con.commit();
            return true;
        } catch (SQLException e) {
            try {
                con.rollback(); //cancelando a transação
                return false;
            } catch (SQLException ex) {
                return false;
            }
        } finally { //isto será executado
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                return false;
            }
        }
    }
    
}
