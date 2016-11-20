package com.lb.parrot.apiproxy;

import com.lb.parrot.pay.result.red.RedPackResult;
import com.lb.parrot.support.util.JsonUtil;
import com.lb.parrot.support.util.XmlUtil;

public class ParserUtilTest {
public static void main(String[] args) {
		
		/*GetTransfersInfoMessage message = new GetTransfersInfoMessage();
		message.setAppId("wxe062425f740c30d8");
		System.out.println(message.toString());*/
	
		String path = "C:\\Users\\Administrator\\Desktop\\xml\\test.xml";
		String xml = JsonUtil.readJson(path);
		System.out.println(xml);
		RedPackResult result = XmlUtil.toBean(xml, RedPackResult.class);
		System.out.println(result.toString());
		
		
		//ParserUtil.textParser.addWeChatConvert(new DownloadBillResultConvert());
		
	/*	ParserUtil.xmlParser.addWeChatConvert(new PayFailResultConvert());
		ParserUtil.xmlParser.addWeChatConvert(new BusinessAliasResultConvert());
		ParserUtil.xmlParser.addWeChatConvert(new OrderQueryResultConvert());
		ParserUtil.xmlParser.addWeChatConvert(new PayNotifyBusinessConvert());
		ParserUtil.xmlParser.addWeChatConvert(new RedPackInfoResultConvert());
		ParserUtil.xmlParser.addWeChatConvert(new RedPackResultConvert());
		ParserUtil.xmlParser.addWeChatConvert(new RefundQueryResultConvert());
		ParserUtil.xmlParser.addWeChatConvert(new RefundResultConvert());
		ParserUtil.xmlParser.addWeChatConvert(new UnifiedOrderResultConvert());
		ParserUtil.xmlParser.addWeChatConvert(new TransfersResultConvert());
		ParserUtil.xmlParser.addWeChatConvert(new GetTransfersInfoResultConvert());*/
		
		//ParserUtil.xmlParser.addWeChatConvert(new UnifiedOrderResultConvert());
		//UnifiedOrderResult result = ParserUtil.parse(xml, ConvertMode.SEND);
		//System.out.println(result.toString());

		
	}
}
