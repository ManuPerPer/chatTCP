package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Espejo extends Thread{

	private DataInputStream escuchadelcliente;
	private DataOutputStream escrituraPara3;
	private DataOutputStream escrituraPara2;
	
	
	
	




	public Espejo(DataInputStream cliente, DataOutputStream escrituraPara2, DataOutputStream escrituraPara3) {
		super();
		this.escuchadelcliente=cliente;
		this.escrituraPara2=escrituraPara2;
		this.escrituraPara3= escrituraPara3;
	
	}








	public void escucharTodos(DataInputStream cliente, DataOutputStream escrituraPara2, DataOutputStream escrituraPara3) throws IOException {
		DataInputStream es1 = this.escuchadelcliente;
		DataOutputStream wr2 = this.escrituraPara3; // al datao que le paso
		DataOutputStream wr1 = this.escrituraPara2; // al datao que le paso
		
		do {
		
		String mensaje = es1.readUTF();
		System.out.println(mensaje);
		
				
		wr1.writeUTF(mensaje);
		wr2.writeUTF(mensaje);
		
		}while(true);
	}

	@Override
	public void run() {
		
		try {
			escucharTodos(this.escuchadelcliente, this.escrituraPara2, this.escrituraPara3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
	}
	
}
