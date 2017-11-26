package com.jc.bean.message.response;

/**
 * 音乐消息
 * @author jiangchong
 * @since 2017/11/25 22:52
 * @version 1.0
 */

public class MusicMessage extends BaseMessage {
    // 音乐
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}