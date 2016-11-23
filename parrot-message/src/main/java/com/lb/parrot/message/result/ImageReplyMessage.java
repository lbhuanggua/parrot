package com.lb.parrot.message.result;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 图片回复消息
 * @author lbhuanggua
 *
 */
@XStreamAlias("xml")
public class ImageReplyMessage extends CommonReplyMessage{
	
	public ImageReplyMessage(String mediaId){
		setMsgType("image");
		image = new ImageItem(mediaId);
	}
	
	public ImageReplyMessage(){
		this(null);
	}

	@XStreamAlias("Image")
	private ImageItem image;

	public ImageItem getImage() {
		return image;
	}

	public void setImage(ImageItem image) {
		this.image = image;
	}
	
	public String toString(){
		XStream xstream = new XStream();
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.processAnnotations(getClass());
		return xstream.toXML(this);
	}
}
