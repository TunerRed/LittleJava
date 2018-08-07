package Colliders;

import modle.GObject;

public class Colliders {
	static Collider1 head;
	static {
		try {
			head = new Collider1();
			head.next = new Collider2();
			head.next.next = new Collider3();
		    head.next.next.next=new Collider4();
		    head.next.next.next.next=new Collider5();
		    head.next.next.next.next.next=new Collider6();
		    head.next.next.next.next.next.next=new Collider7();
		} finally {
			System.out.println("Collidersc³õÊ¼»¯Íê±Ï");
		}
	}

	public static void DowithCollide(GObject go1, GObject go2) {
		
		head.DowithCollide(go1, go2);
		

	}

}
