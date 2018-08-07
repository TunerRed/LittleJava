import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Datas implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> s,item_list;
	private int n;
	public Datas(List<String> item_list,int n_items){
		n = n_items;
		this.item_list = item_list;
		s = new ArrayList<String>();
	}
	public String getData(int day){
		return s.get(day-1);
	}
	public List<String> getItemList(){
		return item_list;
	}
	public void add(String data){
		if(data.length() == n)
			s.add(data);
		else
		{
			System.out.println("error format");
			System.exit(-1);
		}
	}
	public double score(){
		int total = 0;
		String temp = "";
		for(int i = 0; i < s.size(); i++)
		{
			temp = s.get(i);
			for(int j = 0; j < n; j++)
				if(temp.charAt(j) == '1')
					total++;
		}
		return total/(s.size() * n * 1.0);
	}
}
