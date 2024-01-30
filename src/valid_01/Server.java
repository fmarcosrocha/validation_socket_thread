package valid_01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
        int porta = 12345;

        try (ServerSocket servidorSocket = new ServerSocket(porta)) {
            System.out.println("Servidor aguardando conexões na porta " + porta);

            while (true) {
                Socket clienteSocket = servidorSocket.accept();
                System.out.println("Novo cliente conectado");

                // Cria uma nova thread para lidar com o cliente
                Thread threadCliente = new Thread(new ServerThread(clienteSocket));
                threadCliente.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
