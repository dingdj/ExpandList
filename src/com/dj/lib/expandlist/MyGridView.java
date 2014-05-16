/**
 * @author dingdj
 * Date:2014-5-16上午9:17:32
 *
 */
package com.dj.lib.expandlist;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * @author dingdj
 * Date:2014-5-16上午9:17:32
 *
 */
public class MyGridView extends GridView {

	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public MyGridView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public MyGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param context
	 */
	public MyGridView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 设置不滚动
	 */
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);

	}

}
