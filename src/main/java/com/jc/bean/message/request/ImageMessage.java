package com.jc.bean.message.request;

/**
 * 图片消息类
 * @author jiangchong
 * @since 2017/11/25 16:25
 * @version 1.0
 */
public class ImageMessage extends BaseMessage {
	 
	/**
	 * 图片链接路径
	 */
	private String PicUrl;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
}
