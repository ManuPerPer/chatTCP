package servidor;

import java.net.*;

import java.io.*;

public class EscuchaServer extends Thread {

	
	
	static DataInputStream dataIn1;
	



	public EscuchaServer(DataInputStream datai) {
		super();
		this.dataIn1= datai;
	
		
	}
	


	public void escuchaCliente(DataInputStream datai) {
		
		try {

			
			
			do {
				
				String mensajeRecibido = this.dataIn1.readUTF();
				
				
				System.out.println(mensajeRecibido);

			} while (true);

		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		escuchaCliente(this.dataIn1);
		
		

	}

}
