package com.lb.parrot.message.result;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 视频回复消息
 *
 */
@XStreamAlias("xml")
public class VideoReplyMessage extends CommonReplyMessage{

	public VideoReplyMessage(String mediaId,String title,String description){
		setMsgType("video");
		video = new VideoItem(mediaId,title,description);
	}
	
	public VideoReplyMessage(){
		this(null,null,null);
	}
	
	@XStreamAlias("Video")
	private VideoItem video;

	public VideoItem getVideo() {
		return video;
	}

	public void setVideo(VideoItem video) {
		this.video = video;
	}
	
	public String toString(){
		XStream xstream = new XStream();
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.processAnnotations(getClass());
		return xstream.toXML(this);
	}
}
