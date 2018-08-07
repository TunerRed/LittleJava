import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFileChooser;

public class FileServer extends Thread{
	
	public static void main(String[] args){
		new FileServer().start();;
	}
	
 private ServerSocket server;
 private Socket socket;
 private boolean flag;
 
 public FileServer(){
  server = null;
  socket = null;
  flag = true;
 }
 
 public void run(){
  try {
   server = new ServerSocket(8088);
   while(flag){
    socket = server.accept();   
    JFileChooser chooser = new JFileChooser("E:/");
    int result = chooser.showSaveDialog(null);
    if(result == JFileChooser.APPROVE_OPTION){
     File file = chooser.getSelectedFile();
     InputStream is = socket.getInputStream();
     OutputStream os = new FileOutputStream(file);
     byte[] buff = new byte[is.available()];
     is.read(buff);
     
     os.write(buff);
     os.flush();
     is.close();
     os.close();
    }
   }
   
  } catch (IOException e) {
   e.printStackTrace();
  }  
 }
}