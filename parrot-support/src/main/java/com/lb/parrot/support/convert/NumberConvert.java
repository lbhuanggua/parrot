package com.lb.parrot.support.convert;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 将汉字数字转换成阿拉伯数字
 *
 */
public class NumberConvert implements Converter<String, String> {

	private static Pattern checkRegex = Pattern
			.compile("(零|一|二|两|三|四|五|六|七|八|九|十|百|千|万|亿)*");
	private static Map<String, Long> valueMaps = new HashMap<String, Long>();
	static {
		valueMaps.put("零", 0L);
		valueMaps.put("一", 1L);
		valueMaps.put("二", 2L);
		valueMaps.put("两", 2L);
		valueMaps.put("三", 3L);
		valueMaps.put("四", 4L);
		valueMaps.put("五", 5L);
		valueMaps.put("六", 6L);
		valueMaps.put("七", 7L);
		valueMaps.put("八", 8L);
		valueMaps.put("九", 9L);
		valueMaps.put("十", 10L);
		valueMaps.put("百", 100L);
		valueMaps.put("千", 1000L);
		valueMaps.put("万", 10000L);
		valueMaps.put("亿", 100000000L);
	}

	public String convert(String inputData) throws ConvertException {
		if (checkInput(inputData)) {
			BigInteger number = new BigInteger("0");

			// 解决十一这种场景
			if (inputData.startsWith("十")) {
				inputData = "一" + inputData;
			}

			long unit = 1L;
			long unit2 = 1L;
			for (int i = inputData.length(); i >= 1; i--) {
				String zh = inputData.substring(i - 1, i);
				long value = valueMaps.get(zh);
				if (value > 9L) {
					// 数值单位
					unit = value;
					if (value == 10000L) {
						unit = 1L;
						unit2 = value;
					} else if (value == 100000000L) {
						unit = 1L;
						unit2 = value;
					} else {
						unit = value;
					}
				} else {
					// 数值
					number = number.add(new BigInteger(String.valueOf(value
							* unit * unit2)));
				}
			}
			return number.toString();
		}
		return inputData;
	}

	/**
	 * 如果包含非汉字数字以外的文本，返回false
	 * 
	 * @param inputData
	 * @return
	 */
	private boolean checkInput(String inputData) {
		return checkRegex.matcher(inputData).matches();
	}
}
