import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XPathTest {

 public static void main(String[] args) throws ParserConfigurationException,
   SAXException, IOException, XPathExpressionException {

  // �����ļ�������document����
  DocumentBuilder builder = DocumentBuilderFactory.newInstance()
    .newDocumentBuilder();
  Document document = builder.parse(new File("bookstore.xml"));

  // ����XPath����
  XPath xpath = XPathFactory.newInstance().newXPath();

  // ��ȡ�ڵ�ֵ
  String webTitle = (String) xpath.evaluate(
    "/bookstore/book[@category='WEB']/title/text()", document,
    XPathConstants.STRING);
  System.out.println(webTitle);

  System.out.println("===========================================================");

  // ��ȡ�ڵ�����ֵ
  String webTitleLang = (String) xpath.evaluate(
    "/bookstore/book[@category='WEB']/title/@lang", document,
    XPathConstants.STRING);
  System.out.println(webTitleLang);

  System.out.println("===========================================================");

  // ��ȡ�ڵ����
  Node bookWeb = (Node) xpath.evaluate(
    "/bookstore/book[@category='WEB']", document,
    XPathConstants.NODE);
  System.out.println(bookWeb.getNodeName());

  System.out.println("===========================================================");

  // ��ȡ�ڵ㼯��
  NodeList books = (NodeList) xpath.evaluate("/bookstore/book", document,
    XPathConstants.NODESET);
  for (int i = 0; i < books.getLength(); i++) {
   Node book = books.item(i);
   System.out.println(xpath.evaluate("@category", book,
     XPathConstants.STRING));
  }

  System.out.println("===========================================================");
 }

}