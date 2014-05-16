/**
 * @author dingdj
 * Date:2014-5-15下午3:09:00
 *
 */
package com.dj.lib.expandlist;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ddj.lib.expandlist.R;
import com.dj.lib.expandlist.util.ConvertToPinyin;

/**
 * @author dingdj Date:2014-5-15下午3:09:00
 * 
 */
public class ImageAdapter extends BaseAdapter {

	private Context context;
	private final String[] navName;
	private final String[] navUrl;

	public ImageAdapter(Context context, String[] navName, String[] navUrl) {
		this.context = context;
		this.navName = navName;
		this.navUrl = navUrl;
	}

	@Override
	public int getCount() {
		return navName.length;
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View gridView;

		if (convertView == null) {

			gridView = new View(context);

			// get layout from mobile.xml
			gridView = inflater.inflate(R.layout.item, null);
		} else {
			gridView = (View) convertView;
		}
		// set image based on selected text
		View view = gridView.findViewById(R.id.grid_item);
		/*view.setBackgroundColor(Color.argb(255, CommonData.colors[position%6][0], CommonData.colors[position%6][1],
				CommonData.colors[position%6][2]));*/
		view.setBackgroundDrawable(ShapeUtil.getShapeByColor(Color.argb(255, CommonData.colors[position%6][0], CommonData.colors[position%6][1],
				CommonData.colors[position%6][2])));
		
		TextView textView = (TextView) gridView
				.findViewById(R.id.grid_item_text);
		textView.setText(navName[position]);
		TextPaint tp = textView.getPaint();
		tp.setFakeBoldText(true);
		
		String imageName = ConvertToPinyin.convertChineseToPinyin(navName[position]).replace(" ", "")
				.replace(",", "").replace(":", "");
		Log.e("ImageAdapter", imageName);
		ImageView imageView = (ImageView) gridView
				.findViewById(R.id.grid_item_image);
		int resId = context.getResources().getIdentifier(imageName, "drawable" , context.getPackageName()); 
		if(resId != 0){
			imageView.setImageDrawable(context.getResources().getDrawable(resId));
		}else{
			imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.launcher_navigation_default));
		}
		
		view.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				CommonData.openPage(context, navUrl[position]);
			}
		});

		return gridView;
	}

}
