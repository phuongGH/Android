package android.demo.adapters;

import java.util.List;

import android.content.Context;
import android.demo.models.RssItem;
import android.demo.news.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsAdapter extends ArrayAdapter<RssItem>{

	private Context context;
	private List<RssItem> items;
	private int ivIcon;
	
	public NewsAdapter(Context context, int ivIcon, List<RssItem> items) {
		super(context, ivIcon, items);
		
		this.context = context;
		this.items = items;
		this.ivIcon = ivIcon;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater infalster = (LayoutInflater) 
				context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View rowView = infalster.inflate(R.layout.news,parent,false);
		ImageView ivIcon = (ImageView) rowView.findViewById(R.id.ivIcon);		
		TextView tvPaper = (TextView) rowView.findViewById(R.id.tvNews);
		ivIcon.setImageResource(this.ivIcon);
		tvPaper.setText(items.get(position).getTitle()); 
		return rowView;
	}

}
