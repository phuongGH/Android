package android.demo.utils;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.demo.models.RssItem;

public class RssHandler extends DefaultHandler{

	public static final String ITEM = "item";
	public static final String TITLE = "title";
	public static final String DESCRIPTION = "description";
	public static final String LINK = "link";
	public static final String PUB_DATE = "pubDate";
	
	private RssItem item;
	private List<RssItem> itemList = new ArrayList<RssItem>();
	private boolean stated = false;
	
	private StringBuilder strBuilder = new StringBuilder();
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		
		if(stated && strBuilder != null)
		{
			strBuilder.append(ch,start,length);			
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
		System.out.println("localName ............... " + localName);
		if(localName.equalsIgnoreCase(ITEM))
		{
			itemList.add(item);
			stated = true;
			System.out.println("add item ..............");
		}
		if(stated)
		{
			if(localName.equalsIgnoreCase(TITLE))
			{
				item.setTitle(strBuilder.toString().trim());
			}
			if(localName.equalsIgnoreCase(DESCRIPTION))
			{
				item.setDescription(strBuilder.toString().trim());
			}	
			if(localName.equalsIgnoreCase(LINK))
			{
				item.setLink(strBuilder.toString().trim());
			}	
			if(localName.equalsIgnoreCase(PUB_DATE))
			{
				item.setPubDate(strBuilder.toString().trim());
			}	
			strBuilder = new StringBuilder();
		}
		
	}
	

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		
		System.out.println("localName ............... " + localName);
		if(localName.equalsIgnoreCase(ITEM))
		{
			item = new RssItem();
			
		}
	}
	
	public List<RssItem> getItemList() {
		return itemList;
	}
	
}
