package com.jc.bean.message.request;

/**
 * 微信请求消息基类
 * @author jiangchong
 * @since 2017/11/25 16:25
 * @version 1.0
 */
public class BaseMessage {
    /**
     * 消息id，64位整型
     */
    private long MsgId;

    /**
     * 开发者微信号(公众号)
     */
    private String ToUserName;


    /**
     * 发送方帐号（一个OpenID）
     */
    private String FromUserName;


    /**
     * 消息创建时间 （整型）
     */
    private long CreateTime;


    /**
     * 消息类型（text/image/location/link/video/shortvideo）
     */
    private String MsgType;


    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }
}
