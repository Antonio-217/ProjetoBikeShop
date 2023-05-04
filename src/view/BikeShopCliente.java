
package view;

import controller.ConexaoController;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class BikeShopCliente {
    
    public static ConexaoController ccont;
    
    public static void main(String[] args) {
        Socket socket;
        ObjectInputStream in;
        ObjectOutputStream out;
        
        try {
            System.out.println("Tentando conectar no servidor...");
            socket = new Socket ("127.0.0.1", 12345);
            System.out.println("Conectado com sucesso!");
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            
            //voltaremos para abrir a tela de login e criar um objeto 
            //que irá controlar toda a comunicação com o servidor
            ccont = new ConexaoController (out, in);
            
            FormLogin frmLogin = new FormLogin();
            frmLogin.setVisible(true);
                     
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
}
