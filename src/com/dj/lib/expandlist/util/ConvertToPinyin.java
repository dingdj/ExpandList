/**
 * @author dingdj
 * Date:2014-5-16上午8:51:17
 *
 */
package com.dj.lib.expandlist.util;

import com.dj.lib.expandlist.util.pinyin.MultiPinYin1;
import com.dj.lib.expandlist.util.pinyin.MultiPinYin2;
import com.dj.lib.expandlist.util.pinyin.MultiPinYin3;
import com.dj.lib.expandlist.util.pinyin.MultiPinYin4;
import com.dj.lib.expandlist.util.pinyin.MultiPinYin5;



/**
 * @author dingdj
 * Date:2014-5-16上午8:51:17
 *
 */
public class ConvertToPinyin {
	
	
	public static String[] pinyinArray = null;
	public static String wordBreaker = " ";
	public static char commaBreaker = ',';
	// ox4e00 ,十进制为19968
	private static int chUnicodePart1Begin = 19968;
	// 0x5e67,24167
	private static int chUnicodePart2Begin = 24167;
	// 0x6ECF,28367
	private static int chUnicodePart3Begin = 28367;
	// 0x7F37,32567
	private static int chUnicodePart4Begin = 32567;
	// 0x8F9F,36767
	private static int chUnicodePart5Begin = 36767;
	// 0x9FA5,40869
	private static int chUnicodePart5End = 40869;

	
	
	/**
	 * 汉字转成拼音，如果是数字则返回数字，其他字符直接忽略
	 * 
	 * @param chinese
	 * @return 对应的拼音或数字
	 */
	public static String convertChineseToPinyin(final String chinese) {
		if (chinese == null || "".equals(chinese))
			return "";
		
		String[] multiPinYin1 = MultiPinYin1.getMultiPinYin1();
		String[] multiPinYin2 = MultiPinYin2.getMultiPinYin2();
		String[] multiPinYin3 = MultiPinYin3.getMultiPinYin3();
		String[] multiPinYin4 = MultiPinYin4.getMultiPinYin4();
		String[] multiPinYin5 = MultiPinYin5.getMultiPinYin5();
		
		
		StringBuilder result = new StringBuilder();
		int len = chinese.length();
		for (int i = 0; i < len; i++) {
			char eachChar = chinese.charAt(i);
			int unicodeValue = chinese.charAt(i);
			if (unicodeValue >= chUnicodePart1Begin && unicodeValue < chUnicodePart2Begin) {
				int offset = unicodeValue - chUnicodePart1Begin;
				result.append(multiPinYin1[offset]).append(wordBreaker);
				continue;
			} else if (unicodeValue >= chUnicodePart2Begin && unicodeValue < chUnicodePart3Begin) {
				int offset = Integer.valueOf(unicodeValue - chUnicodePart2Begin);
				result.append(multiPinYin2[offset]).append(wordBreaker);
				continue;
			} else if (unicodeValue >= chUnicodePart3Begin && unicodeValue < chUnicodePart4Begin) {
				int offset = unicodeValue - chUnicodePart3Begin;
				result.append(multiPinYin3[offset]).append(wordBreaker);
				continue;
			} else if (unicodeValue >= chUnicodePart4Begin && unicodeValue < chUnicodePart5Begin) {
				int offset = unicodeValue - chUnicodePart4Begin;
				result.append(multiPinYin4[offset]).append(wordBreaker);
				continue;
			} else if (unicodeValue >= chUnicodePart5Begin && unicodeValue <= chUnicodePart5End) {
				int offset = unicodeValue - chUnicodePart5Begin;
				result.append(multiPinYin5[offset]).append(wordBreaker);
				continue;
			} else if (isAlphaPhebicNumeric(eachChar)) {
				result.append(eachChar);
				while (i < len - 1) {
					i++;
					char nextChar = chinese.charAt(i);
					if (isAlphaPhebicNumeric(nextChar))
						result.append(nextChar);
					else {
						result.append(wordBreaker);
						i--;
						break;
					}
				}
			}
		}
		return result.toString();
	}
	
	
	public static boolean isAlphaPhebicNumeric(char cs) {
		if (cs >= '0' && cs <= '9')
			return true;
		if (cs >= 'a' && cs <= 'z')
			return true;
		if (cs >= 'A' && cs <= 'Z')
			return true;
		return false;
	}

}
