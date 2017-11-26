package com.jc.bean.message.response;

/**
 * 文本消息
 * @author jiangchong
 * @since 2017/11/25 22:51
 * @version 1.0
 */
public class TextMessage extends BaseMessage {
    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
