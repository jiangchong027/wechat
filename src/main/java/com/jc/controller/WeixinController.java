package com.jc.controller;

import com.google.gson.Gson;
import com.jc.service.HandlerService;
import com.jc.util.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 *
 * @author jiangchong
 * @since 2017/11/25 16:24
 * @version 1.0
 */
@Controller
@ResponseBody
public class WeixinController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeixinController.class);

    @Autowired
    private HandlerService handler;

    @RequestMapping(value = "request", method = RequestMethod.GET)
    public String validate(String signature, String timestamp, String nonce, String echostr) {
        return echostr;
    }

    @RequestMapping(value = "request", method = RequestMethod.POST, produces = "text/xml;charset=utf-8")
    public String processRequest(HttpServletRequest request) throws Exception {
        Map<String, String> requsetParams = MessageUtil.parseXml(request);

        LOGGER.info(new Gson().toJson(requsetParams, Map.class));

        String result = null;

        String msgType = requsetParams.get("MsgType");
        switch (msgType) {
            case MessageUtil.REQ_MESSAGE_TYPE_TEXT:
                result = handler.handlerText(requsetParams);
                break;
            case MessageUtil.REQ_MESSAGE_TYPE_VOICE:
                result = handler.handlerVoice(requsetParams);
                break;
            case MessageUtil.REQ_MESSAGE_TYPE_IMAGE:
                result = handler.handlerImage(requsetParams);
                break;
            case MessageUtil.REQ_MESSAGE_TYPE_LINK:

                break;
            case MessageUtil.REQ_MESSAGE_TYPE_LOCATION:

                break;
            case MessageUtil.REQ_MESSAGE_TYPE_EVENT:
                result = handler.handlerEvent(requsetParams);
                break;
            default:
                break;
        }

        LOGGER.info(result);

        return result;
    }

}
