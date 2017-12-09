package com.jc.cache;

import com.jc.api.WeatherApi;
import com.jc.bean.weather.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 天气缓存管理
 *
 * @author liaozan
 * @version 1.0.0
 * @since 2017/12/9
 */
@Component
public class WeatherCacheManager {

	@Autowired
	private WeatherApi weatherApi;

	private Map<String, WeatherCache> weatherCacheMap = new ConcurrentHashMap<>();

	/**
	 * 根据key获取对应缓存
	 *
	 * @param city   城市
	 * @param expire 过期时间
	 * @return cache
	 */
	public WeatherCache getData(String city, long expire) {
		WeatherCache weatherCache = weatherCacheMap.get(city);
		if (Objects.isNull(weatherCache)) {
			Weather weather = weatherApi.getWeather(city);
			weatherCache = new WeatherCache(weather, expire);
			weatherCacheMap.put(city, weatherCache);
			return weatherCache;
		}
		Date expireTime = new Date(weatherCache.getExpire());
		Date now = new Date();
		if (expireTime.before(now)) {
			Weather weather = weatherApi.getWeather(city);
			weatherCache = new WeatherCache(weather, expire);
			weatherCacheMap.put(city, weatherCache);
		}
		return weatherCache;
	}

	/**
	 * @param city 城市
	 * @return cache
	 */
	public WeatherCache getData(String city) {
		return getData(city, getDefaultExpireTime());
	}

	private long getDefaultExpireTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.MILLISECOND, 1);
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime().getTime();
	}

}
