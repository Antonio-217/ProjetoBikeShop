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
            
            stmt.setString(1, bk.getModelo());
            stmt.setInt(2, bk.getMarca().getCodMarca());
            stmt.setDouble(3, bk.getPreco());
            stmt.setBytes(4, bk.getImagem());
            stmt.setDate(5, new java.sql.Date(bk.getDataLancamento().getTime()));
            
            stmt.execute();
            con.commit();
            return true;
            
        } catch (SQLException e) {
            try {
                con.rollback();
                e.printStackTrace();
                return false;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
    }
    
}
