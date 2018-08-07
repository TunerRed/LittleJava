import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class FileClient extends Thread {
	
	public static void main(String[] args){
		new FileClient(new File("‪F:\\MySQL5.1参考手册官方简体中文版.chm"), null, 8088).start();
	}
	
 private Socket socket;
 private InetAddress ip;
 private int port;
 File file;
 public FileClient(File file,InetAddress ip,int port){
  this.file = file;
  this.ip = ip;
  this.port = port;
  socket = null;
 }
 
 public void run() {
  try {
   socket = new Socket("127.0.0.1",port);
   FileInputStream fis = new FileInputStream(file);
   byte[] buff = new byte[fis.available()];
   fis.read(buff);
   
   OutputStream os = socket.getOutputStream();
   os.write(buff);
   
   os.flush();
   fis.close();
   os.close();
   
  } catch (IOException e) {
   e.printStackTrace();
  }
  
 }
}