import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class TalkServer {
	public static void main(String[] args){
		ServerSocket ss = null;
		
		String strC = null;
		String strS = null;
		
		Scanner scan = new Scanner(System.in);
		try {
			ss = new ServerSocket(10801);
			Socket s;
			InputStream is;
			OutputStream os;
			DataInputStream dis;
			DataOutputStream dos;
			while(true){
				s = ss.accept();
				is = s.getInputStream();
				dis = new DataInputStream(is);
				os = s.getOutputStream();
				dos = new DataOutputStream(os);
				
				try{
					strC = dis.readUTF();
					System.out.println("Client: "+strC);
					strS = scan.nextLine();
					dos.writeUTF(strS);
				}catch(SocketException se){
					System.out.println("¡¨Ω”÷–∂œ£°");
				}
				
				dis.close();
				dos.close();
				s.close();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				ss.close();
				scan.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
