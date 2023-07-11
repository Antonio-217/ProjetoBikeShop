
package controller;

//classe responsavel por cuidar da comunicação com o servidor.

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelDominio.Bike;
import modelDominio.Marca;
import modelDominio.Usuario;

//ela irá enviar os comandos e receber as respostas.
public class ConexaoController {
    private ObjectOutputStream out;
    private ObjectInputStream in;
    //atributo que guardará o usuario que efetuou login na tela de login
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ConexaoController(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }
    
    //aqui iremos implementar vários métodos para se comunicar com o servidor
    public Usuario efetuarLogin(Usuario usr){
        
        try {
            out.writeObject("UsuarioEfetuarLogin");
            String msg = (String) in.readObject();
            out.writeObject(usr);
            return (Usuario) in.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
       }
    }
    public ArrayList<Bike> bikeLista(){
        String msg;
        try {
            //enviando o comando para o servidor 
            //comando: MarcaLista
            out.writeObject("BikeLista");
            ArrayList<Bike> listabike = (ArrayList<Bike>) in.readObject();
            return listabike;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Marca> marcaLista(){
        try {
            //enviando o comando para o servidor 
            //comando: MarcaLista
            out.writeObject("MarcaLista");
            /*recebendo a lista do servidor e retornando para a tela que chamar este comando*/
            return (ArrayList<Marca>) in.readObject();
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Marca> marcaListaNome(String nome){
        try {
            //enviando o comando para o servidor 
            //comando: MarcaListaNome
            out.writeObject("MarcaListaNome");
            in.readObject();
            out.writeObject(nome);
            /*recebendo a lista do servidor e retornando para a tela que chamar este comando*/
            return (ArrayList<Marca>) in.readObject();
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean marcaInserir(Marca m){
        try {
            out.writeObject("MarcaInserir");
            in.readObject();//recebendo OK
            out.writeObject(m);
            return (boolean) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean marcaEditar(Marca m){
        try {
            out.writeObject("MarcaEditar");
            in.readObject();//recebendo OK
            out.writeObject(m);
            return (boolean) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean marcaExcluir(Marca m){
        try {
            out.writeObject("MarcaEditar");
            in.readObject();//recebendo OK
            out.writeObject(m);
            return (boolean) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void fim(){
        try {
            out.writeObject("fim");
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
