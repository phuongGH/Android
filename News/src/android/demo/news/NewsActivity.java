package android.demo.news;

import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.demo.models.RssItem;
import android.demo.news.CategoryActivity.categorytask;
import android.demo.news.R.string;
import android.demo.utils.RssParser;
import android.demo.utils.Variables;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NewsActivity extends Activity {

	private WebView webView;
	private ProgressDialog dialog;
	private String link;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.article);
		Bundle bundle = getIntent().getExtras();
		setTitle(R.string.app_name);
		String link = bundle.getString(Variables.LINK);
		webView = (WebView) findViewById(R.id.wvNews);
		webView.getSettings().setSupportZoom(true);
		webView.setInitialScale(1);
		webView.getSettings().setLoadWithOverviewMode(true);
		webView.getSettings().setUseWideViewPort(true);
		webView.setScrollBarStyle(webView.SCROLLBARS_OUTSIDE_OVERLAY);
		webView.setScrollbarFadingEnabled(false);
		
		//webView.setWebViewClient(new sysWebViewClient());
		//dialog = ProgressDialog.show(this, "", "Loading " + link);
		//new NewsTask().execute();
		webView.loadUrl(link);
	}
	
	class NewsTask extends AsyncTask<Void, Void, Void>{

		
		@Override
		protected Void doInBackground(Void... params) {
			webView.loadUrl(link);
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			if(dialog != null)
			{
				dialog.dismiss();
			}
		}
		

	}
	
	class sysWebViewClient extends WebViewClient{

		@Override
		public void onPageFinished(WebView view, String url) {
			if(dialog != null)
			{
				dialog.dismiss();
			}
			
		}
		
	}

}
