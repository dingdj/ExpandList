/**
 * @author dingdj
 * Date:2014-5-16上午9:50:57
 *
 */
package com.dj.lib.expandlist;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.SparseArray;

/**
 * @author dingdj
 * Date:2014-5-16上午9:50:57
 *
 */
public class ShapeUtil {
	
	
	public static SparseArray<GradientDrawable> shapeCache = new SparseArray<GradientDrawable>(6);
	
	public static GradientDrawable getShapeByColor(int color) {
		GradientDrawable gp = shapeCache.get(color);
		if(shapeCache.get(color) != null){
			return gp;
		}
		//int strokeWidth = 5;
		int roundRadius = 15; 
		//int strokeColor = Color.parseColor("#2E3135");
		//int fillColor = Color.parseColor("#DFDFE0");

		GradientDrawable gd = new GradientDrawable();
		gd.setColor(color);
		gd.setCornerRadius(roundRadius);
		//gd.setStroke(strokeWidth, strokeColor);
		shapeCache.put(color, gd);
		return gd;
	}

}
