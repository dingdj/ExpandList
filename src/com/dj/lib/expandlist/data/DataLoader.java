/**
 * @author dingdj
 * Date:2014-5-22下午5:04:41
 *
 */
package com.dj.lib.expandlist.data;

import java.util.List;

import android.content.Context;

import com.dj.lib.expandlist.util.Utility;

/**
 * @author dingdj Date:2014-5-22下午5:04:41
 * 
 */
public class DataLoader {

	private static DataLoader instance;

	private List<Category> categories;

	public static DataLoader getInstance(Context context) {
		if (instance == null) {
			instance = new DataLoader(context);
		}
		return instance;
	}

	private DataLoader(Context context) {
		categories = Utility.parseCategories(Utility.loadCacheJson(context));
	}

	/**
	 * @return the categories
	 */
	public List<Category> getCategories() {
		return categories;
	}

}
