import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MesThread implements Runnable {

	private Socket s;
	//@SuppressWarnings("unused") //temp
	private Message mes;
	
	public MesThread(Socket socket, Message mes) {

		this.s = socket;
		this.mes = mes;
		
	}

	@Override
	public void run() {
		String client = s.getInetAddress().toString();
		System.out.println("Connected to: " + client);
		
		double versNum = 1.3;
		try{
			Scanner in = new Scanner(s.getInputStream());
			PrintWriter out;
			out = new PrintWriter(s.getOutputStream(),
					true);
			out.println("Welcome to MaxServer " + versNum);
			out.println("Enter EXIT to exit.");
			
			
			while(true){
				String input = in.nextLine();
				
				
				if(input.equalsIgnoreCase("EXIT")){
					break;

				}
				else if(input.equalsIgnoreCase("LIST")){
					//out.println("helolololo");
					  
					String sentmsg = mes.getMessage();
					
					out.println(sentmsg);
					//System.out.println("serving: " + client);
					

					System.out.println(client + " requested: [" + input +"]  |  " +"responding ["+ sentmsg +"]" + " to " + client);
					
					
				}
				
				
				
				else{
					
					String unknownInputResponse = "unkown input";
					
					System.out.println(client + " requested: [" + input +"]  |  " +"responding ["+ unknownInputResponse +"]" + " to " + client);

					out.println(unknownInputResponse);
				}
			}
			out.println("exiting maxserver " + versNum);
			s.close();
			in.close();
			
			
		}
		catch (Exception e){
			
			e.printStackTrace();
			
		}
		
		System.out.println("closed connection to: " + client);

	}

}
