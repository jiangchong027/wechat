package com.jc.bean.message.request;

/**
 * 文本消息
 * @author jiangchong
 * @since 2017/11/25 16:26
 * @version 1.0
 */
public class TextMessage extends BaseMessage {

    /**
     * 消息内容
     */
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
