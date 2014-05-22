/**
 * @author dingdj
 * Date:2014-5-22下午2:18:37
 *
 */
package com.dj.lib.expandlist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

import com.ddj.lib.expandlist.R;

/**
 * @author dingdj Date:2014-5-22下午2:18:37
 * 
 */
public class ExpandGridView extends GridView {

	private float lineWidth;
	private Paint mPaint;
	private Paint mPaintLine;
	private Path mPath;
	private Path mPathLine;

	/**
	 * @param context
	 */
	public ExpandGridView(Context context) {
		super(context);
		initPaint();
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public ExpandGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initPaint();
	}

	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public ExpandGridView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initPaint();
	}

	/**
	 * 
	 * @author dingdj Date:2014-5-22下午2:22:16
	 */
	private void initPaint() {
		this.lineWidth = 0.25F;
		this.mPaint = new Paint(1);
		this.mPaint.setStyle(Paint.Style.STROKE);
		this.mPaint.setColor(getContext().getResources().getColor(R.color.child_gridview_septal_line));
		this.mPaint.setStrokeWidth(this.lineWidth);
		DashPathEffect localDashPathEffect = new DashPathEffect(new float[] { 2.0F, 2.0F }, 1.0F);
		this.mPaint.setPathEffect(localDashPathEffect);
		this.mPath = new Path();
		this.mPaintLine = new Paint(1);
		this.mPaintLine.setStyle(Paint.Style.STROKE);
		this.mPaintLine.setColor(getContext().getResources().getColor(R.color.child_gridview_septal_line));
		this.mPaintLine.setStrokeWidth(this.lineWidth);
		this.mPathLine = new Path();
	}

	public void draw(Canvas paramCanvas) {
		super.draw(paramCanvas);
		int i = getChildCount();
		if (i > 0)
			drawEdge(paramCanvas, i);
	}

	protected void onDraw(Canvas paramCanvas) {
		super.onDraw(paramCanvas);
	}

	private void drawEdge(Canvas paramCanvas, int paramInt) {
		int i = getChildAt(0).getWidth();
		if (i <= 0)
			return;
		int j = getWidth();
		getHeight();
		int k = getWidth() / i;
		int m = (int) Math.ceil(paramInt / k);
		this.mPath.reset();
		this.mPathLine.reset();
		this.mPathLine.moveTo(0.0F, getChildAt(0).getTop());
		this.mPathLine.lineTo(j, getChildAt(0).getTop());
		this.mPathLine.moveTo(0.0F, m * getChildAt(0).getBottom() - getChildAt(0).getTop());
		this.mPathLine.lineTo(j, m * getChildAt(0).getBottom() - getChildAt(0).getTop());
		for (int n = 0;; n++) {
			if (n >= m - 1) {
				paramCanvas.drawPath(this.mPath, this.mPaint);
				paramCanvas.drawPath(this.mPathLine, this.mPaintLine);
				return;
			}
			int i1 = getChildAt(n * k).getBottom();
			this.mPathLine.moveTo(0.0F, i1);
			this.mPathLine.lineTo(j, i1);
		}
	}

	public void onMeasure(int paramInt1, int paramInt2) {
		super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, -2147483648));
	}
}
