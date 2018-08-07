package media;

import java.awt.Component;

import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.PrefetchCompleteEvent;
import javax.media.RealizeCompleteEvent;
import javax.swing.JFrame;

public class MediaPlay extends JFrame implements ControllerListener{
	
	String media;
	Component comp1,comp2;
	Player player;
	
	public static void main(String[] args){
		new MediaPlay();
	}
	
	public MediaPlay(){
		setTitle("balabala");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setVisible(true);
		media = "F:\\Java\\media\\序列.mp4";
		play();
	}
	
	@Override
	public synchronized void controllerUpdate(ControllerEvent arg0) {
		// TODO 自动生成的方法存根
		if(arg0 instanceof RealizeCompleteEvent){
			if((comp1=player.getVisualComponent())!=null){
				add("Center",comp1);
			}
			if((comp2=player.getControlPanelComponent())!=null){
				add("South",comp2);
			}
		}
		else if(arg0 instanceof PrefetchCompleteEvent){
			player.start();
		}
	}
	
	
	public void play(){
		try{
			MediaLocator mrl = new MediaLocator(media);
			player = Manager.createPlayer(mrl);
			player.addControllerListener(this);
		}catch(Exception e){
			System.out.println("bug");
			e.printStackTrace();
		}
		
		if(player != null){
			player.prefetch();
		}
	}

}
