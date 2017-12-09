package com.jc.cache;

import com.jc.bean.weather.Weather;

/**
 * 天气缓存
 *
 * @author liaozan
 * @version 1.0.0
 * @since 2017/12/9
 */
public class WeatherCache {

	private Weather data;

	private long expire;

	public Weather getData() {
		return data;
	}

	public long getExpire() {
		return expire;
	}

	WeatherCache(Weather weather, long expire) {
		this.data = weather;
		this.expire = expire;
	}

	@Override
	public String toString() {
		return "WeatherCache{" + "data=" + data + ", expire=" + expire + '}';
	}
}
