package view;

import controller.TrataClienteController;
import factory.Conector;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Principal {

    public static void main(String[] args) {

        //variaveis
        ServerSocket servidor;
        int idUnico = 0;

        try {
            //inicializando o servidor
            servidor = new ServerSocket(12345);
            System.out.println("Servidor inicializado. Aguardando clientes... ");
            if (Conector.getConnection() != null) {
                System.out.println("Conectado no banco com sucesso!");
            }

            //Possibilita a conexão de vários clientes
            while (true) {
                //recebe novas conexões
                Socket cliente = servidor.accept();
                System.out.println("Um novo cliente conectou: " + cliente);
                idUnico++;

                System.out.println("Iniciando uma thread para o cliente: " + idUnico);

                TrataClienteController trataCliente = new TrataClienteController(cliente, idUnico);
                trataCliente.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
