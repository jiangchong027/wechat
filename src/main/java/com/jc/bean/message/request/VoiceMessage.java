package com.jc.bean.message.request;

/**
 * 音频消息
 * @author jiangchong
 * @since 2017/11/25 16:26
 * @version 1.0
 */
public class VoiceMessage extends BaseMessage {

    /**
     * 媒体ID
     */
    private String MediaId;

    /**
     * 语音格式
     */
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}
