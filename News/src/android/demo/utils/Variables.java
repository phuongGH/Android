package android.demo.utils;

import java.util.HashMap;
import java.util.List;

import android.demo.models.RssItem;
import android.demo.news.R;
import android.demo.news.R.integer;


public class Variables {
	public static final String[] PAPERS = {"vnexpress","24h"};
	public static final int[] ICONS = {R.drawable.vnexpress_logo72x72,R.drawable.logo24h_72x72};
	
	//vnexpress
	public static final String[] VNEXPRESS_CATEGORIES = {"Trang chủ","Thời sự"};
	public static final String[] VNEXPRESS_LINKS = {"http://vnexpress.net/rss/tin-moi-nhat.rss","http://vnexpress.net/rss/thoi-su.rss"};
	
	//24h
	public static final String[] NEW_24H_CATEGORIES = {"Trang chủ","Bóng đá","An ninh - Hình sự","Thời trang","Thời trang Hi-tech"};
	public static final String[] NEW_24H_LINKS = {"http://www.24h.com.vn/upload/rss/tintuctrongngay.rss",
													"http://www.24h.com.vn/upload/rss/bongda.rss",
													"http://www.24h.com.vn/upload/rss/anninhhinhsu.rss",
													"http://www.24h.com.vn/upload/rss/thoitrang.rss",
													"http://www.24h.com.vn/upload/rss/thoitranghitech.rss"};
	
	//all
	public static final String[][] CATEGORIES = {VNEXPRESS_CATEGORIES,NEW_24H_CATEGORIES};
	public static final String[][] LINKS = {VNEXPRESS_LINKS,NEW_24H_LINKS};
	
	
	public static final String PAPER = "paper";
	public static final String CATEGORY = "category";
	public static final String LINK = "link";
	
	public static HashMap<Integer, List<RssItem>> newsMap = new HashMap<Integer, List<RssItem>>(); 
}
