package android.demo.utils;

import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.demo.models.RssItem;

public class RssParser {
	public List<RssItem> getList(String link)
	{
		try {
			URL url = new URL(link);
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			XMLReader reader = parser.getXMLReader();
			RssHandler handler = new RssHandler();
			reader.setContentHandler(handler);
			InputSource source = new InputSource(url.openStream());
			reader.parse(source);
			return handler.getItemList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;		
	}
}
