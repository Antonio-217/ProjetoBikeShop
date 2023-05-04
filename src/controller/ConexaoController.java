
package controller;

//classe responsavel por cuidar da comunicação com o servidor.

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//ela irá enviar os comandos e receber as respostas.
public class ConexaoController {
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public ConexaoController(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }
    
    //aqui iremos implementar vários métodos para se comunicar com o servidor
    
    
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
