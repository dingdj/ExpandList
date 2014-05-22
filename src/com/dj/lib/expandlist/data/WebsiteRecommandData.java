/**
 * @author dingdj
 * Date:2014-5-22下午3:06:32
 *
 */
package com.dj.lib.expandlist.data;

/**
 * @author dingdj Date:2014-5-22下午3:06:32
 * 
 */
public class WebsiteRecommandData {

	private static final long serialVersionUID = 5139265752906209870L;
	protected String mColor;
	protected byte[] mData;
	protected String mTitle;
	protected String mUrl;

	public WebsiteRecommandData(String paramString1, String paramString2) {
		this.mTitle = paramString1;
		this.mUrl = paramString2;
	}

	public WebsiteRecommandData(String paramString1, String paramString2, String paramString3) {
		this.mTitle = paramString1;
		this.mColor = paramString2;
		this.mUrl = paramString3;
	}

	public String getColor() {
		return this.mColor;
	}

	public byte[] getData() {
		return this.mData;
	}

	public String getTitle() {
		return this.mTitle;
	}

	public String getUrl() {
		return this.mUrl;
	}

	public void setColor(String paramString) {
		this.mColor = paramString;
	}

	public void setData(byte[] paramArrayOfByte) {
		this.mData = paramArrayOfByte;
	}

	public void setTitle(String paramString) {
		this.mTitle = paramString;
	}

	public void setUrl(String paramString) {
		this.mUrl = paramString;
	}

	public String toString() {
		Object[] arrayOfObject = new Object[2];
		arrayOfObject[0] = this.mTitle;
		arrayOfObject[1] = this.mUrl;
		return String.format("title=%s, url=%s", arrayOfObject);
	}

}
