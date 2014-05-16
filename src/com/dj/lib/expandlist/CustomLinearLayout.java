/**
 * @author dingdj
 * Date:2014-5-16上午10:51:13
 *
 */
package com.dj.lib.expandlist;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * @author dingdj
 * Date:2014-5-16上午10:51:13
 *
 */
public class CustomLinearLayout extends LinearLayout {

	private boolean isOnTouchScaleState;
	
	private ClickStateShow clickStateShow = new ClickStateShow();
	
	/**
	 * @param context
	 */
	public CustomLinearLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public CustomLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (isOnTouchScaleState) {
			isOnTouchScaleState = false;
			clickStateShow.draw(canvas, getWidth()/2, getWidth()/2);
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
	
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			isOnTouchScaleState = true;
			this.invalidate();
			break;
		case MotionEvent.ACTION_UP:
			isOnTouchScaleState = false;
			this.invalidate();
			break;
		case MotionEvent.ACTION_CANCEL:
			isOnTouchScaleState = false;
			this.invalidate();
			break;
		default:
			break;

		}
		
		return super.onTouchEvent(event);
	}
	
	public class ClickStateShow {
	
		float onTouchScale = 0.9f;

		public void draw(Canvas canvas, float centX, float centY) {
			canvas.scale(onTouchScale, onTouchScale, centX, centY);
		}
	}

}
