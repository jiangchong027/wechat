package com.jc.service;

import com.jc.api.TulinApi;
import com.jc.util.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.regex.Pattern;

/**
 * 用户请求处理
 * @author jiangchong
 * @since 2017/11/25 20:12
 * @version 1.0
 */
@Service
public class HandlerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HandlerService.class);

    @Autowired
    private TulinApi tulinApi;
    @Autowired
    private ResponseService responseService;

    /**
     * 处理文本类型请求
     * @param requsetParams 请求参数
     * @return xml字符串
     */
    public String handlerText(Map<String, String> requsetParams) {
        String content = requsetParams.get("Content");

        if (Pattern.matches(".*天气.*", content)) {
            String city = content.replaceAll("天气", "");
            return responseService.responseWeather(requsetParams, city);
        }

        String result = tulinApi.getResult(content);

        return responseService.responseText(requsetParams, result);
    }

    /**
     * 处理语音类型请求
     * @param requsetParams 请求参数
     * @return xml字符串
     */
    public String handlerVoice(Map<String, String> requsetParams) {
        try {
            String recognition = requsetParams.get("Recognition");

            if (Pattern.matches(".*天气.*", recognition)) {
                String city = recognition.replaceAll("天气。", "");
                return responseService.responseWeather(requsetParams, city);
            }

            String content = tulinApi.getResult(recognition);

            return responseService.responseText(requsetParams, content);
        } catch (NullPointerException e) {
            LOGGER.warn(e.getMessage());
            e.printStackTrace();
            return responseService.responseText(requsetParams, "没听清楚您说什么.");
        }
    }

    /**
     * 处理图片类型请求
     * @param requsetParams 请求参数
     * @return xml字符串
     */
    public String handlerImage(Map<String, String> requsetParams) {
        return responseService.responseNews(requsetParams);
    }

    /**
     * 处理链接类型请求
     * @param requsetParams 请求参数
     * @return xml字符串
     */
    public String handlerLink(Map<String, String> requsetParams) {
        return null;
    }

    /**
     * 处理地理位置类型请求
     * @param requsetParams 请求参数
     * @return xml字符串
     */
    public String handlerLocation(Map<String, String> requsetParams) {
        return null;
    }

    /**
     * 处理事件类型请求
     * @param requsetParams 请求参数
     * @return xml字符串
     */
    public String handlerEvent(Map<String, String> requsetParams) {
        if (MessageUtil.EVENT_TYPE_SUBSCRIBE.equals((String) requsetParams.get("Event"))) {
            return subscribe(requsetParams);
        } else if (MessageUtil.EVENT_TYPE_UNSUBSCRIBE.equals((String) requsetParams.get("Event"))) {
            unSubscribe(requsetParams);
        }
        return null;
    }

    /**
     * 订阅事件
     * @param requsetParams 请求参数
     * @return xml字符串
     */
    private String subscribe(Map<String, String> requsetParams) {
        return responseService.responseText(requsetParams, "感谢您的订阅!\r\n查询天气: 长沙市天气.\r\n其余都是和机器人聊天.\r\n支持文字和语音.");
    }

    /**
     * 退订事件
     * @param requsetParams 请求参数
     * @return xml字符串
     */
    private void unSubscribe(Map<String, String> requsetParams) {

    }
}
