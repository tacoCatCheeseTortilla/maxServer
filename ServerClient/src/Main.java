import java.net.*;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args){
		
		boolean TRUE = true;
		boolean FALSE = false;
		
		int port = 1234;
		
		Scanner pscan = new Scanner(System.in);
		
		System.out.println("welcome to the maxserver 1.0 client");
		
		
		System.out.print("please set your port number : ");
		
		String	input = pscan.nextLine();
		
		port = Integer.parseInt(input);
		
		System.out.print(""
				+ ""
				+ " "
				+ " ");

		
		
		//if server CLIENT does not work properly re write this

		Socket s = getSocket(port);
		//String msgToServer = "";
		
		Scanner servTalk = new Scanner(System.in);
		try{
			System.out.println("Connected on port: " + port);
			Scanner in =
					new Scanner(s.getInputStream());
			PrintWriter out =
					new PrintWriter(s.getOutputStream(),
							true);
			//discard the welcome message
			in.nextLine();
			
			//discard the exit instructions 
			in.nextLine();
			
			//get a quote 
			System.out.println("type EXIT to exit");

			boolean connected = TRUE;
			
			while (connected){
				System.out.print(": ");

				String msgToServer = servTalk.nextLine();
				
				out.println(msgToServer);
				
				//	in.nextLine();	//added in to prevent socket from closing to see why data isnt being showed to the client
					
					String quote = in.nextLine();
					
					System.out.println("Server: " + quote);
					
					if(servTalk.equals("EXIT")){
						out.println("EXIT");
						s.close();
						connected = FALSE;
						//break;
						
						
						
					}
					else{
						System.out.println("");

					}
					//break;
					
			}
			
			
			
			//disconnect from the server 
			
			
			
				
			}
		catch (Exception e){
			
			e.printStackTrace();
			
		}
		
			
			
			
			
			
		}
		
	private static Socket getSocket(int port){
		Socket s;
		String host;
		InetAddress ip;
		
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("What sever do you want to connect to? : ");
			
			host = sc.nextLine();
			try{
				ip = InetAddress.getByName(host);
				s = new Socket(ip, port);
				return s;
				
			}
			catch (UnknownHostException e){
				System.out.println("Unknown Host");
				
			}
			catch (IOException e){
				System.out.println("Network Error");
			}
			
		}
		
	}	
	
}
