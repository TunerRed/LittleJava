public class Number {
	private int id;
	public int getID(){
		return id;
	}
	public void setID(int id){
		this.id = id;
	}
	public void update(){
		id++;
	}
	public void clear(){
		id = 0;
	}
	public boolean equals(Object obj){
		if(((Number)obj).getID() == this.id)
			return true;
		else
			return false;
	}
}
