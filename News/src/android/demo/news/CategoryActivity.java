package android.demo.news;

import java.util.List;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.demo.adapters.CategoryAdapter;
import android.demo.models.RssItem;
import android.demo.utils.RssParser;
import android.demo.utils.Variables;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class CategoryActivity extends ListActivity{

	private int paper;
	private ProgressDialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Bundle bundle = getIntent().getExtras();
		paper  = bundle.getInt(Variables.PAPER);
		setTitle(Variables.PAPERS[paper]);
		
		CategoryAdapter adapter = new 
				CategoryAdapter(this, Variables.ICONS[paper], Variables.CATEGORIES[paper]);
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		int key = paper*1000 + position;
		if(Variables.newsMap.get(key)==null)
		{
			dialog = ProgressDialog.show(this, "", "Loading " + Variables.CATEGORIES[paper][position]);
			new categorytask().execute(position);
		}
		else {
			Intent intent = new Intent(CategoryActivity.this, NewsListActivity.class);
			intent.putExtra(Variables.PAPER, paper);
			intent.putExtra(Variables.CATEGORY, position);
			startActivity(intent);
		}
	}
	
	class categorytask extends AsyncTask<Integer, Void, Void>{

		private int position;
		
		@Override
		protected Void doInBackground(Integer... params) {
			
			position =  params[0];
			int key = paper*1000 + position;
			RssParser parser = new RssParser();
			List<RssItem> items = parser.getList(Variables.LINKS[paper][position]);
			System.out.println("Rss Size : " + items.size());
			Variables.newsMap.put(key, items);
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			if(dialog != null)
			{
				dialog.dismiss();
			}
			Intent intent = new Intent(CategoryActivity.this, NewsListActivity.class);
			intent.putExtra(Variables.PAPER, paper);
			intent.putExtra(Variables.CATEGORY, position);
			startActivity(intent);
			super.onPostExecute(result);
		}
		
		
		
	}

}
