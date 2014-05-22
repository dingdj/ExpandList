/**
 * @author dingdj
 * Date:2014-5-22下午2:52:02
 *
 */
package com.dj.lib.expandlist.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.util.Xml;

import com.ddj.lib.expandlist.R;
import com.dj.lib.expandlist.data.Category;
import com.dj.lib.expandlist.data.WebsiteRecommandData;

/**
 * @author dingdj Date:2014-5-22下午2:52:02
 * 
 */
public class Utility {

	public static String loadCacheJson(Context paramContext) {
		try {
			String rtn = readFileContent(paramContext.getAssets().open("website_recommend.json"), Xml.Encoding.UTF_8.toString());
			return rtn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 解析json成对象
	 * @author dingdj
	 * Date:2014-5-22下午3:17:12
	 *  @param paramString
	 *  @return
	 */
	public static List<Category> parseCategories(String paramString) {
		ArrayList<Category> rtn = new ArrayList<Category>();
		int[] resIds = { R.drawable.dj_t90ic_rc_hot, R.drawable.dj_t90ic_rc_yuedu, R.drawable.dj_t90ic_rc_gouwu, R.drawable.dj_t90ic_rc_shequ, R.drawable.dj_t90ic_rc_yingyin,
				R.drawable.dj_t90ic_rc_zonghe };

		try {
			JSONArray jsonArray = new JSONArray(paramString);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				Category localCategory = new Category();
				localCategory.mIconRes = resIds[i];
				localCategory.setCategory(jsonObject.getString("category"));
				localCategory.setPosition(jsonObject.getInt("position"));
				ArrayList<WebsiteRecommandData> navigators = new ArrayList<WebsiteRecommandData>();
				localCategory.setNavigators(navigators);
				JSONArray navJsonArray = jsonObject.getJSONArray("data");
				for (int navIndex = 0; navIndex < navJsonArray.length(); navIndex++) {
					JSONObject navJsonObject = navJsonArray.getJSONObject(navIndex);
					navigators.add(new WebsiteRecommandData(navJsonObject.getString("name"), navJsonObject.getString("color"), navJsonObject
							.getString("url")));
				}
				rtn.add(localCategory);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rtn;
	}

	/**
	 * 读取文件内容
	 * 
	 * @param path
	 * @return String
	 */
	public static String readFileContent(InputStream ins, String charsetName) {
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(ins, charsetName));
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ins != null) {
				try {
					ins.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

}
