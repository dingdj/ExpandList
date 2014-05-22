/**
 * @author dingdj
 * Date:2014-5-22下午3:05:56
 *
 */
package com.dj.lib.expandlist.data;

import java.util.List;

/**
 * @author dingdj Date:2014-5-22下午3:05:56
 * 
 */
public class Category {

	private String mCategory;
	public int mIconRes;
	private List<WebsiteRecommandData> mNavigators;
	private int mPosition;

	public String getCategory() {
		return this.mCategory;
	}

	public List<WebsiteRecommandData> getNavigators() {
		return this.mNavigators;
	}

	public int getPosition() {
		return this.mPosition;
	}

	public void setCategory(String paramString) {
		this.mCategory = paramString;
	}

	public void setNavigators(List<WebsiteRecommandData> paramList) {
		this.mNavigators = paramList;
	}

	public void setPosition(int paramInt) {
		this.mPosition = paramInt;
	}

	public String toString() {
		StringBuilder localStringBuilder = new StringBuilder();
		for (int i = 0;; i++) {
			if (i >= this.mNavigators.size())
				return localStringBuilder.toString();
			localStringBuilder.append(((WebsiteRecommandData) this.mNavigators.get(i)).getTitle());
			localStringBuilder.append(",");
		}
	}

}
