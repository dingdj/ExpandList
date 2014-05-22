/**
 * @author dingdj
 * Date:2014-5-15下午2:17:49
 *
 */
package com.dj.lib.expandlist;

import java.util.List;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.ExpandableListContextMenuInfo;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ddj.lib.expandlist.R;
import com.dj.lib.expandlist.data.Category;
import com.dj.lib.expandlist.data.DataLoader;
import com.dj.lib.expandlist.util.Utility;

/**
 * @author dingdj Date:2014-5-15下午2:17:49
 * 
 */
public class ExpandListActivity extends ExpandableListActivity {

	ExpandableListAdapter mAdapter;
	LayoutInflater layoutInflater;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Set up our adapter
		mAdapter = new MyExpandableListAdapter(DataLoader.getInstance(getApplicationContext()).getCategories());
		setListAdapter(mAdapter);
		layoutInflater = this.getLayoutInflater();
		ExpandableListView expView = getExpandableListView();
		MarginLayoutParams lp = (MarginLayoutParams) expView.getLayoutParams();
		int padding = CommonData.dip2px(getApplicationContext(), 14);
		lp.setMargins(padding, 0, padding, 0);

		
		//第一行不收缩
		expView.setOnGroupClickListener(new OnGroupClickListener() {
			@Override
			public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
				if (groupPosition == 0)
					return true; // This way the expander cannot be collapsed
				return false;
			}
		});
		//去除默认黄色背景
		expView.setSelector(new ColorDrawable(Color.TRANSPARENT));
		//去除滚动条
		expView.setVerticalScrollBarEnabled(false);
		expView.setGroupIndicator(null);
		expView.setChildIndicator(null);
		expView.setDividerHeight(0);
	}

	@Override
	protected void onResume() {
		super.onResume();
		getExpandableListView().expandGroup(0);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		menu.setHeaderTitle("Sample menu");
		menu.add(0, 0, 0, R.string.expandable_list_sample_action);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		ExpandableListContextMenuInfo info = (ExpandableListContextMenuInfo) item.getMenuInfo();

		String title = ((TextView) info.targetView).getText().toString();

		int type = ExpandableListView.getPackedPositionType(info.packedPosition);
		if (type == ExpandableListView.PACKED_POSITION_TYPE_CHILD) {
			int groupPos = ExpandableListView.getPackedPositionGroup(info.packedPosition);
			int childPos = ExpandableListView.getPackedPositionChild(info.packedPosition);
			Toast.makeText(this, title + ": Child " + childPos + " clicked in group " + groupPos, Toast.LENGTH_SHORT).show();
			return true;
		} else if (type == ExpandableListView.PACKED_POSITION_TYPE_GROUP) {
			int groupPos = ExpandableListView.getPackedPositionGroup(info.packedPosition);
			Toast.makeText(this, title + ": Group " + groupPos + " clicked", Toast.LENGTH_SHORT).show();
			return true;
		}

		return false;
	}

	/**
	 * A simple adapter which maintains an ArrayList of photo resource Ids. Each
	 * photo is displayed as an image. This adapter supports clearing the list
	 * of photos and adding a new photo.
	 * 
	 */
	public class MyExpandableListAdapter extends BaseExpandableListAdapter {

		private List<Category> categories;

		public MyExpandableListAdapter(List<Category> _categories) {
			this.categories = _categories;
		}

		public Category getChild(int groupPosition, int childPosition) {
			return categories.get(groupPosition);
		}

		public long getChildId(int groupPosition, int childPosition) {
			return groupPosition + childPosition;
		}

		public int getChildrenCount(int groupPosition) {
			return 1;
		}

		public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
			GridView gridView = (GridView) layoutInflater.inflate(R.layout.gridview, null);
			Category category = getGroup(groupPosition);
			gridView.setAdapter(new ImageAdapter(ExpandListActivity.this, category));
			return gridView;
		}

		public Category getGroup(int groupPosition) {
			return categories.get(groupPosition);
		}

		public int getGroupCount() {
			return categories.size();
		}

		public long getGroupId(int groupPosition) {
			return groupPosition;
		}

		public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

			Category category = getGroup(groupPosition);

			if (convertView != null) {
				ViewHolder holder = (ViewHolder) convertView.getTag();
				holder.title.setText(category.getCategory());
				holder.icon.setImageResource(category.mIconRes);
				if (groupPosition == 0) {
					holder.indicator.setVisibility(View.INVISIBLE);
					holder.layout.setBackgroundResource(R.drawable.rc_list_group_item_press);
					holder.title.setTextColor(Color.parseColor("#FFFFFF"));
					convertView.setClickable(true);
				} else {
					holder.indicator.setVisibility(View.VISIBLE);
					holder.layout.setBackgroundResource(R.drawable.rc_list_group_item_background);
					if (isExpanded) {
						holder.indicator.setImageResource(R.drawable.indicator_unfolded_status);
					} else {
						holder.indicator.setImageResource(R.drawable.indicator_folded_status);
					}
					convertView.setClickable(false);
					holder.title.setTextColor(ExpandListActivity.this.getResources().getColor(R.color.recommand_group_iten_text_color));
				}
				return convertView;
			}
			View view = layoutInflater.inflate(R.layout.rc_group_item, null);
			ViewHolder viewHolder = new ViewHolder();
			view.setTag(viewHolder);
			ImageView imageView = (ImageView) view.findViewById(R.id.icon);
			TextView textView = (TextView) view.findViewById(R.id.title);
			ImageView indicatorView = (ImageView) view.findViewById(R.id.indicator);
			View layout = (View) view.findViewById(R.id.layout);
			if (groupPosition == 0) {
				indicatorView.setVisibility(View.INVISIBLE);
				layout.setBackgroundResource(R.drawable.rc_list_group_item_press);
				textView.setTextColor(Color.parseColor("#FFFFFF"));
				view.setClickable(true);
			} else {
				indicatorView.setVisibility(View.VISIBLE);
				layout.setBackgroundResource(R.drawable.rc_list_group_item_background);
				if (isExpanded) {
					indicatorView.setImageResource(R.drawable.indicator_unfolded_status);
				} else {
					indicatorView.setImageResource(R.drawable.indicator_folded_status);
				}
				view.setClickable(false);
				textView.setTextColor(ExpandListActivity.this.getResources().getColor(R.color.recommand_group_iten_text_color));
			}

			textView.setText(category.getCategory());
			imageView.setImageResource(category.mIconRes);

			viewHolder.layout = layout;
			viewHolder.icon = imageView;
			viewHolder.title = textView;
			viewHolder.indicator = indicatorView;
			return view;
		}

		public boolean isChildSelectable(int groupPosition, int childPosition) {
			return true;
		}

		public boolean hasStableIds() {
			return true;
		}

		class ViewHolder {
			View layout;
			ImageView icon;
			TextView title;
			ImageView indicator;
		}
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		int code = SlideUtil.getInstance(this.getBaseContext()).slide(event);
		if (code == SlideUtil.SLIDERIGHT) {
			Log.e("MainActivity", "SLIDERIGHT");
			Intent intent = new Intent();
			intent.setClass(ExpandListActivity.this, MainActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			overridePendingTransition(R.anim.slideleftin, R.anim.sliderightout);
		}
		return super.dispatchTouchEvent(event);
	}

}
