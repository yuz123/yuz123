package com.yuz123.play.shoutcast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.htmlcleaner.TagNode;

import com.yuz123.play.HtmlHelper;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements
		MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener,
		MediaPlayer.OnErrorListener, MediaPlayer.OnBufferingUpdateListener {

	private String TAG = getClass().getSimpleName();
	private MediaPlayer mp = null;
	TextView songText;
	ToggleButton QB;
	private ImageButton stop;
	private ImageButton imageButton1;
	String QUALITY_48 = "http://radio.bigbeats.ru:9056/";
	String QUALITY_128 = "http://radio.bigbeats.ru:9054/";
	
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_main);
		TextView songText = (TextView) findViewById(R.id.textView1);
		ListView listView1 = (ListView) findViewById(R.id.listView1);
		songText.setTypeface(Typeface.createFromAsset(getAssets(), "lets_go_digital.ttf"));
		songText.setTextSize(40);
		songText.setTextColor(Color.parseColor("#FF8C00"));
		stop = (ImageButton) findViewById(R.id.stop);
		imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
		imageButton1.setBackgroundResource(R.drawable.image_button);
		QB = (ToggleButton) findViewById(R.id.togglebutton);
		
		imageButton1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (imageButton1.isSelected()) {
					imageButton1.setSelected(false);
					pause();
				} else {
					imageButton1.setSelected(true);
					play();
					hasInternetConnection();
					imageButton1.setEnabled(false);
									}
			}
		});

		stop.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				stop();
			}
		});
		
	}
	
	
	
	private void play() {
		Uri myUri;
		if (QB.isChecked()){
			myUri = Uri.parse(QUALITY_128);
		}
			else {
				myUri = Uri.parse(QUALITY_48);
			}
		try {
			if (mp == null) {
				this.mp = new MediaPlayer();
			} else {
				mp.stop();
				mp.reset();
			}
			Timer myTimer = new Timer(); // Создаем таймер
			final Handler uiHandler = new Handler();
			final TextView songText = (TextView) findViewById(R.id.textView1);
			
			myTimer.schedule(new TimerTask(){ // Определяем задачу
			    @Override
			    public void run() {
			        final String result = titleUpdate();
			        uiHandler.post(new Runnable() {
			            @Override
			            public void run() {
			                songText.setText(result);
			            }
			        });
			    };
			}, 0L, 30000); // интервал - 60000 миллисекунд, 0 миллисекунд до первого запуска.
			
			mp.setDataSource(this, myUri); // Go to Initialized state
			mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
			mp.setOnPreparedListener(this);
			mp.setOnBufferingUpdateListener(this);

			mp.setOnErrorListener(this);
			mp.prepareAsync();
			
			
		
			Log.d(TAG, "LoadClip Done");
		} catch (Throwable t) {
			Log.d(TAG, t.toString());
		}
	}		
	
	
	protected String titleUpdate() {
		// TODO Auto-generated method stub
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpGet httppost = new HttpGet("http://bigbeats.ru/title.php");
		HttpResponse response;
		StringBuilder total = new StringBuilder();
		try {
			response = httpclient.execute(httppost);
			HttpEntity ht = response.getEntity();

	        BufferedHttpEntity buf = new BufferedHttpEntity(ht);

	        InputStream is = buf.getContent();


	        BufferedReader r = new BufferedReader(new InputStreamReader(is));

	        String line;
	        while ((line = r.readLine()) != null) {
	        	
	            total.append(line + "\n");
	        }

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total.toString();
	}
		



	@Override
	public void onPrepared(MediaPlayer mp) {
		Log.d(TAG, "Stream is prepared");
		imageButton1.setEnabled(true);
		mp.start();
	}

	private void pause() {
		mp.pause();
	}

	private void stop() {
		imageButton1.setEnabled(false);
		mp.stop();

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		//mp.stop();
		//mp.release();

	}

	
	
	public void onCompletion(MediaPlayer mp) {
		stop();
	}

	public boolean onError(MediaPlayer mp, int what, int extra) {
		StringBuilder sb = new StringBuilder();
		sb.append("Media Player Error: ");
		switch (what) {
		case MediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK:
			sb.append("Not Valid for Progressive Playback");
			break;
		case MediaPlayer.MEDIA_ERROR_SERVER_DIED:
			sb.append("Server Died");
			break;
		case MediaPlayer.MEDIA_ERROR_UNKNOWN:
			sb.append("Unknown");
			break;
		default:
			sb.append(" Non standard (");
			sb.append(what);
			sb.append(")");
		}
		sb.append(" (" + what + ") ");
		sb.append(extra);
		Log.e(TAG, sb.toString());
		return true;
	}

	public void onBufferingUpdate(MediaPlayer mp, int percent) {
		Log.d(TAG, "PlayerService onBufferingUpdate : " + percent + "%");
				
	}

	public void onToggleClicked(View view) {
	   	    	play();
	}
	
	public boolean hasInternetConnection() {
	    ConnectivityManager cm =        (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
	    if (cm == null) {
	    	return false;
	    }
	    NetworkInfo[] netInfo = cm.getAllNetworkInfo();
	    if (netInfo == null) {
	    	return false;
	    }	    
	    for (NetworkInfo ni : netInfo)
	    {
	        if (ni.getTypeName().equalsIgnoreCase("WIFI"))
	            if (ni.isConnected()) {
	                Log.d(this.toString(), "test: wifi conncetion found");
	                Toast.makeText(this, "wifi conncetion found", Toast.LENGTH_LONG).show();
					return true;
	            }
	        if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
	            if (ni.isConnected()) {
	                Log.d(this.toString(), "test: mobile connection found");
	                Toast.makeText(this, "mobile conncetion found", Toast.LENGTH_LONG).show();
					return true;
	            }
	    }
		return false;
	}
}
	
class ParseSite extends AsyncTask<String, Void, List<String>> {
    //Фоновая операция
    protected List<String> doInBackground(String... arg) {
      List<String> output = new ArrayList<String>();
      try
      {
        HtmlHelper hh = new HtmlHelper(new URL(arg[0]));
        List<TagNode> links = hh.getLinksByClass("question-hyperlink");

        for (Iterator<TagNode> iterator = links.iterator(); iterator.hasNext();)
        {
          TagNode divElement = (TagNode) iterator.next();
          output.add(divElement.getText().toString());
        }
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
      return output;
    }

    //Событие по окончанию парсинга
    protected void onPostExecute(List<String> output) {
      //Находим ListView
      
      //Загружаем в него результат работы doInBackground
      listView1.setAdapter(new ArrayAdapter<String>(StackParser.this,
          android.R.layout.simple_list_item_1 , output));
    }
  }

	/*public class TitleAsyncTask extends AsyncTask<Void, Void, String> {
 
		protected String doInBackground(Void... s) {
			DefaultHttpClient httpclient = new DefaultHttpClient();
			HttpGet httppost = new HttpGet("http://bigbeats.ru/title.php");
			HttpResponse response;
			StringBuilder total = new StringBuilder();
			try {
				response = httpclient.execute(httppost);
				HttpEntity ht = response.getEntity();

		        BufferedHttpEntity buf = new BufferedHttpEntity(ht);

		        InputStream is = buf.getContent();


		        BufferedReader r = new BufferedReader(new InputStreamReader(is));

		        String line;
		        while ((line = r.readLine()) != null) {
		        	
		            total.append(line + "\n");
		        }

			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return total.toString();
		}

		protected void onPostExecute(String result) {
			songText.setText(result);
		}
	}
	}*/
