/**
 * @author dingdj
 * Date:2014-5-15下午3:50:36
 *
 */
package com.dj.lib.expandlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.ddj.lib.expandlist.R;

/**
 * @author dingdj
 * Date:2014-5-15下午3:50:36
 *
 */
public class MainActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int code = SlideUtil.getInstance(this.getBaseContext()).slide(event);
		if(code == SlideUtil.SLIDELEFT){
			Log.e("MainActivity", "SLIDELEFT");
			 Intent intent = new Intent();
			 intent.setClass(MainActivity.this, ExpandListActivity.class);
			 intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			 startActivity(intent);
			 overridePendingTransition(R.anim.sliderightin, R.anim.slideleftout);
		}
		return super.onTouchEvent(event);
	}
	
	
	

	
	
}
