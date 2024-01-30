package valid_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable{

	private final Socket clienteSocket;
	private final Boolean livre;

    public ServerThread(Socket clienteSocket, Boolean livre) {
        this.clienteSocket = clienteSocket;
		this.livre = true;
    }

    @Override
    public void run() {
        try (
            BufferedReader entradaCliente = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            PrintWriter saidaCliente = new PrintWriter(clienteSocket.getOutputStream(), true)
        ) {
            String mensagemCliente;
            while ((mensagemCliente = entradaCliente.readLine()) != null) {
                System.out.println("Mensagem recebida do cliente: " + mensagemCliente);

                // Processa a mensagem (aqui você pode implementar a lógica desejada)

                // Envia uma resposta ao cliente
                saidaCliente.println("Mensagem recebida com sucesso: " + mensagemCliente);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clienteSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
