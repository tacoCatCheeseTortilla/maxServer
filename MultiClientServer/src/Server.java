import java.net.*;
import java.util.*;
import java.io.*;
public class Server {

	public static void main(String[] args){
		
		int port = 1234;
		
		Message mes = new Message();
		
		
		try{
			System.out.println("MaxServer 2.0");
			System.out.println("Now with multi client support!");
			System.out.println("Listening on port: " + port);

			ServerSocket ss = new ServerSocket(port);
			
			while(true){
				Socket s = ss.accept();
				System.out.println("Connection established!");
				Thread t = new Thread(
						new MesThread(s, mes)); //KEEP EYE ON THIS AND MESTHREAD.JAVA YOU HAD NO IDEA WHAT YOU WERE DOING MAX
				t.start();
			}

		}
		catch (Exception e){
			
			System.out.println("System exception");
			e.printStackTrace();

		}
		
		
	}
}
