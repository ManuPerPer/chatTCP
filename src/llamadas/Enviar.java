package llamadas;

import java.net.*;
import java.io.*;

public class Enviar extends Thread {
	

	static Socket socket;
	private int numCliente;
	
	public static Socket getSocket() {
		return socket;
	}

	public static void setSocket(Socket socket) {
		Enviar.socket = socket;
		
	}

	public Enviar(Socket socket, int numCliente) {
		super();

		this.socket = socket;
		this.numCliente=numCliente;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
				super.run();

		try {
			Thread.sleep(1500);
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			DataOutputStream enviado;
			System.out.println("Escribe todo lo que quieras en la consola");
			enviado = new DataOutputStream(socket.getOutputStream());
			do {

				String mensaje;
				
				mensaje = in.readLine();
				
				enviado.writeUTF("\t\t\tCliente "+numCliente+" dice: "+mensaje);
				
			} while (true);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
