package com.jc.api;

import com.google.gson.Gson;
import com.jc.bean.weather.Weather;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * 天气查询接口
 * @author jiangchong
 * @since 2017/11/25 18:58
 * @version 1.0
 */
@Service
public class WeatherApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherApi.class);
    private static final String WEATHER_URL = "http://www.sojson.com/open/api/weather/json.shtml";

    public Weather getWeather(String city) {
        String result = null;
        try {
            String apiUrl = String.format(WEATHER_URL + "?city=%s", URLEncoder.encode(city, "utf-8"));
            URL url = new URL(apiUrl);
            URLConnection connection = url.openConnection();
            InputStream input = connection.getInputStream();
            result = IOUtils.toString(input, "utf-8");

            LOGGER.info(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Gson().fromJson(result, Weather.class);
    }
    
    public static void main(String[] args) {
        new WeatherApi().getWeather("长沙市");
    }
}
