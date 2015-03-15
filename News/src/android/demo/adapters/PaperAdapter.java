package android.demo.adapters;

import android.content.Context;
import android.demo.news.R;
import android.demo.utils.Variables;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PaperAdapter extends ArrayAdapter<String> {
	private Context context;
	private String[] papers;
		
	public PaperAdapter(Context context, int textViewResourceId,
			String[] papers) {
		super(context, textViewResourceId, papers);
		this.context = context;
		this.papers = papers;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater infalster = (LayoutInflater) 
				context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View rowView = infalster.inflate(R.layout.paper,parent,false);
		ImageView ivIcon = (ImageView) rowView.findViewById(R.id.ivIcon);		
		TextView tvPaper = (TextView) rowView.findViewById(R.id.tvPaper);
		ivIcon.setImageResource(Variables.ICONS[position]);
		tvPaper.setText(papers[position]); 
		return rowView;
	}
	
}
