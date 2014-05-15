/**
 * @author dingdj
 * Date:2014-5-15下午3:09:00
 *
 */
package com.dj.lib.expandlist;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ddj.lib.expandlist.R;

/**
 * @author dingdj Date:2014-5-15下午3:09:00
 * 
 */
public class ImageAdapter extends BaseAdapter {

	private Context context;
	private final String[] mThumbIds;

	public ImageAdapter(Context context, String[] mThumbIds) {
		this.context = context;
		this.mThumbIds = mThumbIds;
	}

	@Override
	public int getCount() {
		return mThumbIds.length;
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
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View gridView;

		if (convertView == null) {

			gridView = new View(context);

			// get layout from mobile.xml
			gridView = inflater.inflate(R.layout.item, null);

			// set image based on selected text
			TextView textView = (TextView) gridView
					.findViewById(R.id.grid_item_text);
			textView.setBackgroundColor(Color.argb(255, ColorSelect.colors[position][0], ColorSelect.colors[position][1],
					ColorSelect.colors[position][2]));
			textView.setText(mThumbIds[position]);

		} else {
			gridView = (View) convertView;
		}

		return gridView;
	}

}
