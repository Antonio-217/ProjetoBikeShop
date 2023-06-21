
package modelDominio;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bike implements Serializable{
     private static final long serialVersionUID = 123l;
    
     private int codBike;
     private String modelo;
     private Marca marca;
     private Date dataLancamento;
     private float preco;
     private byte[] imagem;
     
    public Bike(int codBike) { //usado para delete
        this.codBike = codBike;
    }

    public Bike(String modelo, Marca marca, Date dataLancamento, float preco, byte[] imagem) { //usado para insert
        this.modelo = modelo;
        this.marca = marca;
        this.dataLancamento = dataLancamento;
        this.preco = preco;
        this.imagem = imagem;
    }

    public Bike(int codBike, String modelo, Marca marca, Date dataLancamento, float preco, byte[] imagem) { //usado para update e select
        this.codBike = codBike;
        this.modelo = modelo;
        this.marca = marca;
        this.dataLancamento = dataLancamento;
        this.preco = preco;
        this.imagem = imagem;
    }
    

    public int getCodBike() {
        return codBike;
    }

    public void setCodBike(int codBike) {
        this.codBike = codBike;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return "Bike{" + "codBike=" + codBike + ", modelo=" + modelo + ", marca=" + marca + ", dataLancamento=" + dataLancamento + ", preco=" + preco + ", imagem=" + imagem + '}';
    }

    public String getDataLancamentoString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dataLancamento);
    }
    
    public String getPrecoString(){
        DecimalFormat dcf = new DecimalFormat("#,##0.00");
        return dcf.format(preco);
    }
    
}
