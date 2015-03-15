package android.demo.adapters;

import android.content.Context;
import android.demo.news.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryAdapter extends ArrayAdapter<String> {
	private Context context;
	private String[] categories;
	private int ivIcon;
	
	public CategoryAdapter(Context context, int ivIcon,
			String[] categories) {
		super(context, ivIcon, categories);
		this.context = context;
		this.categories = categories;
		this.ivIcon = ivIcon;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater infalster = (LayoutInflater) 
				context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View rowView = infalster.inflate(R.layout.category,parent,false);
		ImageView ivIcon = (ImageView) rowView.findViewById(R.id.ivIcon);		
		TextView tvPaper = (TextView) rowView.findViewById(R.id.tvCategory);
		ivIcon.setImageResource(this.ivIcon);
		tvPaper.setText(this.categories[position]); 
		return rowView;
	}
}
