package com.nodrex.tvtorch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static int RESTART_TRY_COUNTER;
	private static String TRY_COUNTER_KEY;
	
	static{
		try {
			RESTART_TRY_COUNTER = 2;
			TRY_COUNTER_KEY = "nodrex.TVSleepr.app.restratTryCounterKey";
		} catch (Exception e) {}
		  catch (Throwable t) {}
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);

			Window window = getWindow();
			if (window == null){
				autoRestartApp();
				return;
			}
			WindowManager.LayoutParams params = window.getAttributes();
			if (params == null) {
				autoRestartApp();
				return;
			}
			params.screenBrightness = 1;
			window.setAttributes(params);
		} catch (Exception e) {
			message();
		} catch(Throwable t){
			message();
		}
	}

	protected void onStart() {
		try {
			super.onStart();
		} catch (Exception e) {
			message();
		} catch (Throwable t) {
			message();
		}
	}
	
	protected void onRestart() {
		try {
			super.onRestart();
		} catch (Exception e) {
			message();
		} catch (Throwable t) {
			message();
		}
	}
	
	protected void onResume() {
		try {
			super.onResume();
		} catch (Exception e) {
			message();
		} catch (Throwable t) {
			message();
		}
	}
	
	protected void onDestroy() {
		try {
			super.onDestroy();
		} catch (Exception e) {}
		  catch (Throwable t) {}
	}
	
	protected void onStop() {
		try {
			super.onStop();
		} catch (Exception e) {}
		  catch (Throwable t) {}
	}
	
	protected void onUserLeaveHint() {
		try {
			super.onUserLeaveHint();
		} catch (Exception e) {}
		  catch (Throwable t) {}
	}
	
	protected void onPause() {
		try {
			super.onPause();
		} catch (Exception e) {}
		  catch (Throwable t) {}
	}
	
	private void autoRestartApp() {
		try {
			int tmpRestartTrycounter = RESTART_TRY_COUNTER;
			if(TRY_COUNTER_KEY == null) TRY_COUNTER_KEY = "nodrex.TVSleepr.app.restratTryCounterKey";
			Intent intent = getIntent();
			if(intent != null){
				Bundle extras = intent.getExtras();
				if(extras != null){
					Object object = extras.get(TRY_COUNTER_KEY);
					if(object !=null){
						if(object instanceof Integer){
							tmpRestartTrycounter = ((Integer)object) - 1;
							if(tmpRestartTrycounter < 0){
								message();
								return;
							}
						}
					}
				}
			}
			Intent newIntent = new Intent(this,MainActivity.class);
			newIntent.putExtra(TRY_COUNTER_KEY, tmpRestartTrycounter);
			startActivity(newIntent);
			finish();
		} catch (Exception e) {
			message();
		} catch (Throwable t) {
			message();
		}
	}

	private void message(){
		try {
			String text = "There was some problem please restart app";
			Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
		} catch (Exception e) {} 
		  catch (Throwable t) {}
	}

	
	
}
