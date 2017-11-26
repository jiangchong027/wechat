package com.jc.service;

import com.jc.api.WeatherApi;
import com.jc.bean.message.response.Article;
import com.jc.bean.message.response.NewsMessage;
import com.jc.bean.message.response.TextMessage;
import com.jc.bean.weather.ForecastData;
import com.jc.bean.weather.Weather;
import com.jc.bean.weather.WeatherData;
import com.jc.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 消息回复处理
 * @author jiangchong
 * @since 2017/11/25 20:39
 * @version 1.0
 */
@Service
public class ResponseService {
    @Autowired
    private WeatherApi weatherApi;

    /**
     * 回复文本类型
     * @param requestParams 请求参数
     * @param content 回复内容
     * @return xml字符串
     */
    public String responseText(Map<String, String> requestParams, String content) {
        TextMessage message = new TextMessage();

        message.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

        message.setContent(content);

        message.setFromUserName(requestParams.get("ToUserName"));

        message.setToUserName(requestParams.get("FromUserName"));

        message.setCreateTime(System.currentTimeMillis());

        return MessageUtil.textMessageToXml(message);
    }

    /**
     * 回复图文类型
     * @param requestParams 请求参数
     * @return xml字符串
     */
    public String responseNews(Map<String, String> requestParams) {
        NewsMessage message = new NewsMessage();

        message.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);

        message.setFromUserName(requestParams.get("ToUserName"));

        message.setToUserName(requestParams.get("FromUserName"));

        message.setCreateTime(System.currentTimeMillis());

        Article article = new Article();
        article.setTitle("Title");
        article.setPicUrl("http://2afxu2.natappfree.cc/image/0.jpg");
        article.setDescription("Description1");
        article.setUrl("https://github.com/jiangchong027");

        List<Article> list = new ArrayList<>();
        list.add(article);

        message.setArticleCount(list.size());

        message.setArticles(list);

        return MessageUtil.newsMessageToXml(message);
    }

    /**
     * 回复天气查询
     * @param requestParams 请求参数
     * @param city 城市名
     * @return xml字符串
     */
    public String responseWeather(Map<String, String> requestParams, String city) {
        Weather weather = weatherApi.getWeather(city);
        WeatherData weatherData = weather.getData();
        ForecastData today = weatherData.getForecast().get(0);

        StringBuffer sb = new StringBuffer();
        sb.append(weatherData.getWendu());
        sb.append("℃");
        sb.append("  ");
        sb.append(weatherData.getQuality());
        sb.append("  ");
        sb.append(today.getHigh());
        sb.append("  ");
        sb.append(today.getLow());
        sb.append("  ");
        sb.append(today.getType());
        sb.append("  ");
        sb.append(today.getFx());
        sb.append("  ");
        sb.append(today.getFl());

        Article article = new Article();
        article.setTitle(city + "今日天气");
        article.setDescription(sb.toString());
        article.setPicUrl("http://2afxu2.natappfree.cc/image/0.jpg");
        article.setUrl("https://github.com/jiangchong027");

        List<Article> list = new ArrayList<>();
        list.add(article);

        NewsMessage message = new NewsMessage();
        message.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
        message.setFromUserName(requestParams.get("ToUserName"));
        message.setToUserName(requestParams.get("FromUserName"));
        message.setCreateTime(System.currentTimeMillis());
        message.setArticleCount(list.size());
        message.setArticles(list);

        return MessageUtil.newsMessageToXml(message);
    }
}
