package com.jc.api;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * 图灵智能搜索接口
 * @author jiangchong
 * @since 2017/11/25 18:09
 * @version 1.0
 */
@Service
public class TulinApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(TulinApi.class);

    private static final String APIKEY = "e7a1447ed2182d57758ca845e5a0f36e";

    private static final String URL = "http://www.tuling123.com/openapi/api";

    public String getResult(String question) {
        LOGGER.info(question);

        String result = null;
        try {
            String INFO = URLEncoder.encode(question, "utf-8");
            String getURL = URL + "?key=" + APIKEY + "&info=" + INFO;
            URL url = new URL(getURL);

            LOGGER.info("URL: {}", url);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            result = IOUtils.toString(connection.getInputStream(), "utf-8");
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info("Result: {}", result);

        Gson gson = new Gson();

        Map map = gson.fromJson(result, Map.class);

        return (String) map.get("text");
    }
}
