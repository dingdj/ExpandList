/**
 * @author dingdj
 * Date:2014-5-15下午3:09:00
 *
 */
package com.dj.lib.expandlist;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ddj.lib.expandlist.R;
import com.dj.lib.expandlist.data.Category;
import com.dj.lib.expandlist.data.WebsiteRecommandData;

/**
 * @author dingdj Date:2014-5-15下午3:09:00
 * 
 */
public class ImageAdapter extends BaseAdapter {

	private Context context;
	private List<WebsiteRecommandData> navigators = new ArrayList<WebsiteRecommandData>();
	private LayoutInflater inflater;

	public ImageAdapter(Context context, Category category) {
		this.context = context;
		this.navigators.clear();
		this.navigators.addAll(category.getNavigators());
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return navigators.size();
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
		final WebsiteRecommandData localWebsiteRecommandData = (WebsiteRecommandData) this.navigators.get(position);
		View itemView;
		if (convertView == null) {
			itemView = new View(context);
			itemView = inflater.inflate(R.layout.dj_t90item, null);
		} else {
			itemView = (View) convertView;
		}

		TextView textView = (TextView) itemView.findViewById(R.id.dj_t90label);
		textView.setText(localWebsiteRecommandData.getTitle());

		String color = localWebsiteRecommandData.getColor();
		if (color != null && !"".equals(color.trim())) {
			textView.setTextColor(Color.parseColor(color));
		}

		textView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				CommonData.openPage(context, localWebsiteRecommandData.getUrl());
			}
		});

		return itemView;
	}

}
