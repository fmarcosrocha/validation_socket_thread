package valid_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	 public static void main(String[] args) {
	        String host = "localhost";
	        int porta = 12345;

	        try (
	            Socket socket = new Socket(host, porta);
	            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);
	            BufferedReader leitorConsole = new BufferedReader(new InputStreamReader(System.in))
	        ) {
	            String mensagemUsuario;
	            while (true) {
	                System.out.print("Digite uma mensagem para o servidor (ou 'sair' para encerrar): ");
	                mensagemUsuario = leitorConsole.readLine();

	                if ("sair".equalsIgnoreCase(mensagemUsuario)) {
	                    break;
	                }

	                // Envia a mensagem para o servidor
	                saida.println(mensagemUsuario);

	                // Recebe a resposta do servidor
	                String respostaServidor = entrada.readLine();
	                System.out.println("Resposta do servidor: " + respostaServidor);
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
