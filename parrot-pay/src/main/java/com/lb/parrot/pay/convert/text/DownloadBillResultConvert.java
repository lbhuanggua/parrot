package com.lb.parrot.pay.convert.text;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.lb.parrot.pay.exception.WeChatPayException;
import com.lb.parrot.pay.result.BillField;
import com.lb.parrot.pay.result.DownloadBillResult;
import com.lb.parrot.support.convert.Convert;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.convert.text.AbstractTextConvert;
import com.lb.parrot.support.util.ParserUtil;

@Component
public class DownloadBillResultConvert extends AbstractTextConvert{

	public DownloadBillResultConvert() {
		super(DownloadBillResult.class);
		this.setPriority(3);
	}

	@PostConstruct
	protected void init() {
		ParserUtil.addTextConvert((Convert) this);
	}
	
	public ConvertMode getConvertMode() {
		return ConvertMode.SEND;
	}

	protected boolean checkMatch(String input) {
		return input.indexOf("总交易单数,总交易额") > -1;
	}

	@SuppressWarnings("unchecked")
	protected <OUTPUT> OUTPUT convertString(String input) {
		String[] lines = input.split("\r\n");
		if (lines == null || lines.length < 4) {
			throw new WeChatPayException("微信报文的格式不正确");
		}
		DownloadBillResult result = new DownloadBillResult();
		//处理列表数据
		String[] names = lines[0].split(",");
		for (int i = 1; i < lines.length - 2; i++) {
			BillField field = new BillField();
			//忽略第一个分隔符
			String[] values = getValues(lines[i]);
			for (int j = 0; j < names.length; j++) {
				//TODO #BUG 交易时间字符前面有个字符，待处理
				String name = names[j].replaceAll(" ", "");
			    String value = values[j];
			    if(value.endsWith(",")){
			       value = value.substring(0, value.length()-1);
			    }
				field.setValue(name, value);
			}
			result.getDataFieldList().add(field);
		}
		//处理汇总数据
		String[] tnames = lines[lines.length - 2].split(",");
		String[] tvalues = getValues(lines[lines.length - 1]);
		BillField totalField = new BillField();
		for (int j = 0; j < tnames.length; j++) {
			String name = tnames[j];
		    String value = tvalues[j];
		    if(value.endsWith(",")){
			   value = value.substring(0, value.length()-1);
			}
		    totalField.setValue(name, value);
		}
		result.setTotalField(totalField);
		return (OUTPUT) result;
	}
	
	private String[] getValues(String line){
		String newLine = line.substring(1, line.length());
		return newLine.split("`");
	}

	public static void main(String[] args) {
		String str = new String(" 交易时间");
		byte[] bytes = str.getBytes();
		char[] chars = DownloadBillResultConvert.getChars(bytes);
		for (char c : chars) {
			System.out.println(c);
		}
	}

	public static char[] getChars(byte[] bytes) {
		Charset cs = Charset.forName("UTF-8");
		ByteBuffer bb = ByteBuffer.allocate(bytes.length);
		bb.put(bytes);
		bb.flip();
		CharBuffer cb = cs.decode(bb);
		return cb.array();
	}
}
