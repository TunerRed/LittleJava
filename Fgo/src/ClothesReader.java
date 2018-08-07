import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ClothesReader {
	public static final String base_url = "http://fgowiki.com/guide/equipdetail/";
	public void parse(String filePath) {  
		new Thread(){
			@Override
			public void run(){
				
				FileWriter fw=null;
				BufferedWriter bw=null; 
				try {
					fw = new FileWriter(filePath, true);
					bw = new BufferedWriter(fw);
					List<String> ip=null;
    				try {
						ip = getHtml();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					String[] r;
    		        int curIP = 0;
    				for(int i = 139; i < 712; ){
    					try {
    						r = ip.get(curIP).split(":");
							System.getProperties().setProperty("http.proxyHost", r[0]);
		    		        System.getProperties().setProperty("http.proxyPort", r[1]);
		    		        curIP = (int)(Math.random()*ip.size());
							if(ReaderConn.getPetDetail(bw,i)){
								sleep(10000+(int)(Math.random()*5000));
								i++;
								if(i%10==0)
									System.out.println();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
    				}
    				bw.close();  
    		        fw.close();
    				System.out.println("finished");
				} catch (IOException e2) {
					e2.printStackTrace();
					System.exit(-1);
				}
			}
			
		}.start();
	  }
        public static void main(String[] args){  
        	new ClothesReader().parse("equip.txt");
        } 
    	
    	public static boolean getPetDetail(BufferedWriter bw,int id){
    		
    		String serieInfo = base_url+id;
    		
			try {
				Document document = Jsoup.connect(serieInfo)
						.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0))")
						.header("Accept", "text/html, application/xhtml+xml, */*")
						.header("Content-Type", "application/x-www-form-urlencoded")
						.get();

	    		Elements e = document.getElementsByTag("script");
	    		
	    		for (Element element : e) {
	    			String[] data = element.data().toString().split("var ");
	    			
	    			for(String variable : data){
	    				if(variable.startsWith("datadetail")){
	    					try{
	    						bw.append(decode(variable)+"\r\n");
	    						System.out.print("succeed-id="+id+"  ");
	    					}catch(IOException e2){
	    						e2.printStackTrace();
	    					}
	    				}
	    			}
	    		}
			} catch (IOException e1) {
				System.out.print("failed-id="+id+"  ");
				return false;
			}
			return true;
    		
    	}
    	
    	public static String decode(String unicode){
    		StringBuffer sb = new StringBuffer();
    		unicode = unicode.substring(unicode.indexOf('[')+1,unicode.lastIndexOf(']'));
    		
    		String[] hex = unicode.split("\\\\u");
    		
    		for(int i = 0; i < unicode.length(); i++){
    			if(unicode.charAt(i)=='\\'&&unicode.charAt(i+1)=='u'){
    				int data = Integer.parseInt(unicode.substring(i+2, i+6), 16);  
                    sb.append((char) data);
                    i+=5;
    			}else if(unicode.charAt(i)=='\\'&&unicode.charAt(i+1)=='n'){
    				i+=1;
    			}else{
    				sb.append(unicode.charAt(i));
    			}
    		}
    		
    		return sb.toString();
    	}
    	
    	 private static List<String> getHtml() throws IOException {
    	        Document doc = null;
    	        try {
    	            doc = Jsoup.connect("http://www.xicidaili.com/nt/3")
    	            // .data("query", "Java")
    	                    .userAgent("Mozilla")
    	                    // .cookie("auth", "token")
    	                    // .timeout(3000)
    	                    .get();
    	        } catch (IOException e) {
    	            // TODO Auto-generated catch block
    	            e.printStackTrace();
    	        }
    	        List<String> list = new ArrayList<String>();
    	        Elements elements = doc.select("tr.odd");
    	        int len = elements.size();
    	        Element element = null;
    	        for (int i = 0; i < len; i++) {
    	            element = elements.get(i);
    	            StringBuilder sBuilder = new StringBuilder(20);
    	            sBuilder.append(element.child(1).text());
    	            sBuilder.append(":");
    	            sBuilder.append(element.child(2).text());
    	            list.add(sBuilder.toString());
    	        }
    	        // System.out.println(doc.html());
    	        doc = null;
    	        elements.clear();
    	        elements = null;
    	        return list;
    	    }
}
