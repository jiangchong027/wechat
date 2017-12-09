package com.jc.service;

import com.jc.bean.message.response.Article;
import com.jc.bean.message.response.NewsMessage;
import com.jc.bean.message.response.TextMessage;
import com.jc.bean.weather.ForecastData;
import com.jc.bean.weather.Weather;
import com.jc.bean.weather.WeatherData;
import com.jc.cache.WeatherCache;
import com.jc.cache.WeatherCacheManager;
import com.jc.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 消息回复处理
 *
 * @author jiangchong
 * @version 1.0
 * @since 2017/11/25 20:39
 */
@Service
public class ResponseService {

	@Autowired
	private WeatherCacheManager weatherCacheManager;

	/**
	 * 回复文本类型
	 *
	 * @param requestParams 请求参数
	 * @param content       回复内容
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
	 *
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
		article.setPicUrl("http://120.79.7.142/wechat/image/0.jpg");
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
	 *
	 * @param requestParams 请求参数
	 * @param city          城市名
	 * @return xml字符串
	 */
	public String responseWeather(Map<String, String> requestParams, String city) {
		WeatherCache weatherCache = weatherCacheManager.getData(city);
		Weather weather = weatherCache.getData();
		WeatherData weatherData = weather.getData();
		ForecastData today = weatherData.getForecast().get(0);

		String sb = weatherData.getWendu() + "℃" + "  " + weatherData.getQuality() + "  " + today.getHigh() + "  " + today.getLow() + "  "
				+ today.getType() + "  " + today.getFx() + "  " + today.getFl();

		Article article = new Article();
		article.setTitle(city + "今日天气");
		article.setDescription(sb);
		article.setPicUrl("http://120.79.7.142/wechat/image/0.jpg");
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
