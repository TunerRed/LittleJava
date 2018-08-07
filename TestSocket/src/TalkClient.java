import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TalkClient {
	public static void main(String[] args){
		Socket s = null;
		
		String strC = null;
		String strS = null;
		Pattern pattern1 = Pattern.compile("bye");
		Pattern pattern2 = Pattern.compile("∞›");
		
		Scanner scan = new Scanner(System.in);
		
		try{          
			
			InputStream is;
			OutputStream os;
			DataInputStream dis;
			DataOutputStream dos;
			while(true){
				s = new Socket("127.0.0.1",10801);
				is = s.getInputStream();
				dis = new DataInputStream(is);
				os = s.getOutputStream();
				dos = new DataOutputStream(os);
				try{
					strC = scan.nextLine();
					dos.writeUTF(strC);
					
					strS = dis.readUTF();
					System.out.println("Server: "+strS);
				}catch(SocketException se){
					System.out.println("¡¨Ω”÷–∂œ£°");
				}
				
				dis.close();
				dos.close();
				
				if(pattern1.matcher(strC).matches()&&pattern1.matcher(strS).matches()){
					System.exit(0);
				}
				if(pattern2.matcher(strC).matches()&&pattern2.matcher(strS).matches()){
					System.exit(0);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				s.close();
				scan.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
