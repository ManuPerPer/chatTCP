package servidor;

import java.net.*;

import java.io.*;

public class EnvioServer extends Thread {

	
	static DataOutputStream enviado;
	static DataOutputStream enviado2;
	static DataOutputStream enviado3;

	

	public EnvioServer(DataOutputStream dataou1) {
		
		this.enviado= dataou1;
	}
	
	public EnvioServer( DataOutputStream dataou1, DataOutputStream dataou2 , DataOutputStream dataou3) {
		
	
		this.enviado= dataou1;
		this.enviado2= dataou2;
		this.enviado3=dataou3;
		
	
	}
	
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();

		try {

			String mensaje;
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			

			do {

				

				mensaje = in.readLine();
				mensaje= "\t\t\tServidor dice: "+mensaje;
				
				enviado.writeUTF(mensaje);
				enviado2.writeUTF(mensaje);
				enviado3.writeUTF(mensaje);


			} while (true);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
