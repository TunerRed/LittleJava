import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;

public class Main {
	public static void main(String[] args){
		//new Main().downloadPic("http://www.fgowiki.com/petdetail/2");
		
		try {
			final WebClient mWebClient = new WebClient(BrowserVersion.CHROME);
			mWebClient.getOptions().setCssEnabled(true);
			mWebClient.getOptions().setJavaScriptEnabled(true);
			HtmlPage mHtmlPage;
			mHtmlPage = mWebClient.getPage("http://www.fgowiki.com/petdetail/196");
			
			List<Object> list = ((HtmlElement)mHtmlPage
					.getByXPath("//ul[@class='Pic-ul swiper-wrapper yingling']").get(0)).getByXPath("li");
			for(int i = 0; i < list.size(); i++){
				System.out.println("==============================");
				HtmlElement he = (HtmlElement)list.get(i);
				System.out.println(he.getAttribute("style"));
				System.out.println("++++++++++++++++++++++++++++++");
			}
			
			//System.out.println(mHtmlPage.asXml());
			File f = new File("style.txt");
			FileWriter writer=new FileWriter(f);
			writer.write(mHtmlPage.asXml());
			writer.close();
			
			mWebClient.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	public void downloadPic(final String url){
	        new Thread()
	        {
	            public void run()
	            {
	                Document doc = null;
	                try {
						doc = Jsoup.connect(url).get();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
	                System.out.println("run doc finished");
	                if (doc != null){
	                	System.out.println("run doc not null");
	                	
	                    Element element =
	                            doc.select("ul[class='Pic-ul swiper-wrapper yingling']").first();
	                    System.out.println(element.html());
	                }
	                System.out.println("run finished");
	            }
	        }.start();

	    }

}
