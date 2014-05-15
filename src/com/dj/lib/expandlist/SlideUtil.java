/**
 * @author dingdj
 * Date:2014-5-15下午4:13:30
 *
 */
package com.dj.lib.expandlist;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/**
 * @author dingdj
 * Date:2014-5-15下午4:13:30
 *
 */
public class SlideUtil {
	
	public static final int SLIDELEFT = 1;
	
	public static final int SLIDERIGHT = 2;
	
	public static final int SLIDENOACTION = 3;
	
	private VelocityTracker mVelocityTracker;
	
	private int mMaximumVelocity;
	
	public static final int SNAP_VELOCITY = 300;
	
	private static SlideUtil instance;
	
	public static SlideUtil getInstance(Context context){
		if(instance == null){
			instance = new SlideUtil(context);
		}
		return instance;
	}
	
	private SlideUtil(Context context){
		final ViewConfiguration configuration = ViewConfiguration.get(context);
        mMaximumVelocity = configuration.getScaledMaximumFlingVelocity();
	}
	
	public int slide(MotionEvent event){
		final int action  = event.getAction();
        final float x = event.getX();
        final float y = event.getY();
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(event);
        switch (action){
            case MotionEvent.ACTION_UP:
                mVelocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
                int velocityX = (int) mVelocityTracker.getXVelocity();
                if(velocityX > SNAP_VELOCITY){
                    return SLIDERIGHT;
                }else if(velocityX < -SNAP_VELOCITY){
                    return SLIDELEFT;
                }
                break;
        }
        return SLIDENOACTION;
	}

}
