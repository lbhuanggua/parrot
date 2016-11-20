package com.lb.parrot.material.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lb.parrot.support.common.ToServerResult;
import com.lb.parrot.support.result.AbstractToServerResult;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MaterialCountResult extends AbstractToServerResult implements
		ToServerResult {
	private static final long serialVersionUID = 1L;
	/**
	 * 语音总数量
	 */
	@JSONField(name = "voice_count")
	private String voiceCount;

	/**
	 * 视频总数量
	 */
	@JSONField(name = "video_count")
	private String videoCount;

	/**
	 * 图片总数量
	 */
	@JSONField(name = "image_count")
	private String imageCount;

	/**
	 * 图文总数量
	 */
	@JSONField(name = "news_count")
	private String newsCount;

	public String getVoiceCount() {
		return voiceCount;
	}

	public void setVoiceCount(String voiceCount) {
		this.voiceCount = voiceCount;
	}

	public String getVideoCount() {
		return videoCount;
	}

	public void setVideoCount(String videoCount) {
		this.videoCount = videoCount;
	}

	public String getImageCount() {
		return imageCount;
	}

	public void setImageCount(String imageCount) {
		this.imageCount = imageCount;
	}

	public String getNewsCount() {
		return newsCount;
	}

	public void setNewsCount(String newsCount) {
		this.newsCount = newsCount;
	}

}
