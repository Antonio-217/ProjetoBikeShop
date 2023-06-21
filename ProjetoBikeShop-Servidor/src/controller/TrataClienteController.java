package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import model.MarcaDao;
import model.UsuarioDao;
import modelDominio.Marca;
import modelDominio.Usuario;

public class TrataClienteController extends Thread {
    
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private int idUnico;
    
    public TrataClienteController(Socket socket, int idUnico) throws IOException {
        this.socket = socket;
        this.idUnico = idUnico;
        //criar objetos para receber (in) e enviar (out) infos para o cliente   
        try {
            this.in = new ObjectInputStream(this.socket.getInputStream());
            this.out = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //esse metodo ficará rodando e escutando a conexão com o cliente.
    //também receberá e interpretará todos os comandos oriundos do cliente.
    @Override
    public void run() {
        String comando; //comando recebido do cliente
        System.out.println("Esperando comandos do cliente...");
        
        try {
            comando = (String) in.readObject();
            //enquanto o comando NÃO for fim, fica dentro do looping
            while (!comando.equalsIgnoreCase("fim")) {
                System.out.println("Cliente " + idUnico + " enviou o comando: " + comando);
                //teremos que testar todos os comandos recebidos....
                //o sor costuma utilizar vários IFs para realizar os testes
                if (comando.equalsIgnoreCase("UsuarioEfetuarLogin")) {
                    //enviando ok para o cliente
                    out.writeObject("ok");
                    //recebendo um usuario
                    Usuario usr = (Usuario) in.readObject();
                    System.out.println(usr);
                    //aqui teremos que chamar o metodo para consultar
                    //no banco de dados
                    //como ainda não implementamos isso
                    //iremos retornar nulo para o cliente
                    UsuarioDao usdao = new UsuarioDao();
                    out.writeObject(usdao.efetuarLogin(usr));
                    
                } else if (comando.equalsIgnoreCase("MarcaLista")) {
                    MarcaDao mcdao = new MarcaDao();
                    out.writeObject(mcdao.getMarcaLista());
                    
                } else if (comando.equalsIgnoreCase("MarcaListaNome")){
                    out.writeObject("ok");
                    String nome = (String) in.readObject();
                    MarcaDao mcdao = new MarcaDao();
                    out.writeObject(mcdao.getMarcaListaNome(nome));
                
                }else if (comando.equalsIgnoreCase("MarcaInserir")) {
                    out.writeObject("ok");
                    Marca m = (Marca) in.readObject();//recebendo a marca
                    MarcaDao mcdao = new MarcaDao();
                    out.writeObject(mcdao.inserir(m));
                    
                } else if (comando.equalsIgnoreCase("MarcaEditar")) {
                    out.writeObject("ok");
                    Marca m = (Marca) in.readObject();
                    MarcaDao mcdao = new MarcaDao();
                    out.writeObject(mcdao.editar(m));
                            
                } else if (comando.equalsIgnoreCase("MarcaExcluir")) {
                    out.writeObject("ok");
                    Marca m = (Marca) in.readObject();
                    MarcaDao mcdao = new MarcaDao();
                    out.writeObject(mcdao.excluir(m));
                }
                //temos que ler o novo comando
                comando = (String) in.readObject();
            }
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        //cliente encerrou a conexão pois enviou o comando fim
        System.out.println("Cliente " + idUnico + " finalizou a conexão");
        
        try {
            this.in.close();
            this.out.close();
        } catch (IOException e) {
            e.printStackTrace();
            for (int i = 0; i <= e.getStackTrace().length; i++) {
                System.out.println("Classe de erro: " + e.getStackTrace()[i].getClassName());
                System.out.println("Método de erro: " + e.getStackTrace()[i].getMethodName());
                System.out.println("Linha de erro: " + e.getStackTrace()[i].getLineNumber());
                System.out.println("Exceção: " + e.getClass().getName());
            }
        }
    }
}
