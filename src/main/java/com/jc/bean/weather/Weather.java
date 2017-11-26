package com.jc.bean.weather;

import java.util.Date;

/**
 * 天气
 * date : 20171125
 * message : Success !
 * status : 200
 * city : 北京
 * count : 1
 * data : {"shidu":"35%","pm25":53,"pm10":107,"quality":"良","wendu":"0","ganmao":"极少数敏感人群应减少户外活动","yesterday":{"date":"24日星期五","sunrise":"07:08","high":"高温 7.0℃","low":"低温 -5.0℃","sunset":"16:53","aqi":31,"fx":"西南风","fl":"3-4级","type":"多云","notice":"悠悠的云里有淡淡的诗"},"forecast":[{"date":"25日星期六","sunrise":"07:09","high":"高温 7.0℃","low":"低温 -3.0℃","sunset":"16:53","aqi":116,"fx":"南风","fl":"<3级","type":"阴","notice":"灰蒙蒙的天空就像模糊了的眼睛"},{"date":"26日星期日","sunrise":"07:10","high":"高温 4.0℃","low":"低温 -4.0℃","sunset":"16:52","aqi":41,"fx":"无持续风向","fl":"<3级","type":"晴","notice":"天气干燥，请适当增加室内湿度"},{"date":"27日星期一","sunrise":"07:11","high":"高温 5.0℃","low":"低温 -4.0℃","sunset":"16:52","aqi":166,"fx":"西南风","fl":"<3级","type":"晴","notice":"天气干燥，请适当增加室内湿度"},{"date":"28日星期二","sunrise":"07:12","high":"高温 8.0℃","low":"低温 -5.0℃","sunset":"16:51","aqi":108,"fx":"北风","fl":"3-4级","type":"多云","notice":"绵绵的云朵，形状千变万化"},{"date":"29日星期三","sunrise":"07:13","high":"高温 3.0℃","low":"低温 -4.0℃","sunset":"16:51","aqi":40,"fx":"东南风","fl":"<3级","type":"阴","notice":"阴天是彩虹的前期之景"}]}
 * @author jiangchong
 * @since 2017/11/25 19:29
 * @version 1.0
 */
public class Weather {
    private Date date;
    private String message;
    private int status;
    private String city;
    private int count;
    private WeatherData data;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public WeatherData getData() {
        return data;
    }

    public void setData(WeatherData data) {
        this.data = data;
    }
}
