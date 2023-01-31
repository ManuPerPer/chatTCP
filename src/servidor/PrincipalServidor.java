package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PrincipalServidor {

DataInputStream datai;

	
static DataInputStream datai1;
static DataInputStream datai2;
static DataInputStream datai3;
static DataOutputStream dataou1;
static	DataOutputStream dataou2;
static	DataOutputStream dataou3;


	public static void main(String[] args) throws IOException {
		

	
		ServerSocket socket;
		socket = new ServerSocket(7000);
		System.out.println("Esperando que alguien se conecte.....");
		Socket cli = socket.accept();
		String cliente = cli.getRemoteSocketAddress().toString();
		
		System.out.println(" cliente 1 conectado");
		
		Socket cli2= socket.accept();
		String cliente2= cli2.getRemoteSocketAddress().toString();
		
		System.out.println(" cliente 2 conectado");
		
		Socket cli3= socket.accept();
		String cliente3= cli3.getRemoteSocketAddress().toString();
		System.out.println(" cliente 3 conectado");
	
	
		System.out.println("Se ha conectado: "+ cliente +", "+ cliente2+ " y "+ cliente3);
		
		//dataoutput para escritura en cliente 1 2 y 3
		dataou1 = new DataOutputStream(cli.getOutputStream());
		dataou2 = new DataOutputStream(cli2.getOutputStream());
		dataou3 = new DataOutputStream(cli3.getOutputStream());
		datai1= new DataInputStream(cli.getInputStream());
		datai2= new DataInputStream(cli2.getInputStream());
		datai3= new DataInputStream(cli3.getInputStream());
		
		//escribimos saludo
		String saludo = "Bienvenido al Chat";
		dataou1.writeUTF(saludo);
		dataou2.writeUTF(saludo);
		dataou3.writeUTF(saludo);

		
		/*
		 * he comentado las 3 escuchas del server y sus hilos por que queria probar si realmente hacian falta
		 * ya que el servidor en los espejos ya esta escuchando los dataInputs de cada cliente y printeando desde ahi
		 * y funciona correctamente
		 */
		
		
//		EscuchaServer escucha1= new EscuchaServer(datai1);
//		EscuchaServer escucha2= new EscuchaServer(datai2);
//		EscuchaServer escucha3= new EscuchaServer(datai3);
		Espejo espejo1= new Espejo(datai1, dataou2,dataou3);
		Espejo espejo2= new Espejo(datai2, dataou1,dataou3);
		Espejo espejo3= new Espejo(datai3, dataou1,dataou2);
		
		EnvioServer enviaATodos= new EnvioServer(dataou1, dataou2, dataou3);
		enviaATodos.start();
		espejo1.start();
		espejo2.start();
		espejo3.start();
		/*
		escucha1.start();
		escucha2.start();
		escucha3.start();
		
		*/
		
		
	
		
		
		
	}
	

	

}
