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
 *
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

    public String handlerText(Map<String, String> requsetParams) {
        String content = requsetParams.get("Content");

        if (Pattern.matches(".*天气.*", content)) {
            String city = content.replaceAll("天气", "");
            return responseService.responseWeather(requsetParams, city);
        }

        String result = tulinApi.getResult(content);

        return responseService.responseText(requsetParams, result);
    }

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

    public String handlerImage(Map<String, String> requsetParams) {
        return responseService.responseNews(requsetParams);
    }

    public String handlerLink(Map<String, String> requsetParams) {
        return null;
    }

    public String handlerLocation(Map<String, String> requsetParams) {
        return null;
    }

    public String handlerEvent(Map<String, String> requsetParams) {
        if (MessageUtil.EVENT_TYPE_SUBSCRIBE.equals((String) requsetParams.get("Event"))) {
            return subscribe(requsetParams);
        } else if (MessageUtil.EVENT_TYPE_UNSUBSCRIBE.equals((String) requsetParams.get("Event"))) {
            unSubscribe(requsetParams);
        }
        return null;
    }

    private String subscribe(Map<String, String> requsetParams) {
        return responseService.responseText(requsetParams, "感谢您的订阅!");
    }

    private void unSubscribe(Map<String, String> requsetParams) {

    }
}
