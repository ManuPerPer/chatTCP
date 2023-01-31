package llamadas;

import java.net.*;

import java.io.*;

public class Escucha extends Thread {
	DataInputStream datai;
	

	

	public Escucha(DataInputStream datai) {
		super();

		this.datai= datai;
	}

	@Override
	public void run() {

		// TODO Auto-generated method stub
		super.run();

		try {

		
			
			
			/*
			 * estas variables son para setear color en la pantalla con el pluggin ansi escape in console.
			 * si te dan error, borralas del syso (color1 y reset)
			 */
			
			do {
				String mensajeRecibido = "";
				mensajeRecibido = this.datai.readUTF();
				System.out.println(mensajeRecibido);
				
			} while (true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}