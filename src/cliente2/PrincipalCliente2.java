package cliente2;
import java.net.*;
import llamadas.*;


import java.io.*;

public class PrincipalCliente2 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		// TODO Auto-generated method stub
		
		Socket socket= new Socket("127.0.0.1",7000);
		
		DataInputStream datai= new DataInputStream(socket.getInputStream());
		Enviar envios= new Enviar(socket,2);
		
		Escucha escuchar= new Escucha(datai);
		
		escuchar.start();
		envios.start();
		

	}

}
