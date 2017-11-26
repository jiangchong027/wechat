package com.jc.bean.weather;

import java.util.List;

/**
 * shidu : 35%
 * pm25 : 53.0
 * pm10 : 107.0
 * quality : 良
 * wendu : 0
 * ganmao : 极少数敏感人群应减少户外活动
 * yesterday : {"date":"24日星期五","sunrise":"07:08","high":"高温 7.0℃","low":"低温 -5.0℃","sunset":"16:53","aqi":31,"fx":"西南风","fl":"3-4级","type":"多云","notice":"悠悠的云里有淡淡的诗"}
 * forecast : [{"date":"25日星期六","sunrise":"07:09","high":"高温 7.0℃","low":"低温 -3.0℃","sunset":"16:53","aqi":116,"fx":"南风","fl":"<3级","type":"阴","notice":"灰蒙蒙的天空就像模糊了的眼睛"},{"date":"26日星期日","sunrise":"07:10","high":"高温 4.0℃","low":"低温 -4.0℃","sunset":"16:52","aqi":41,"fx":"无持续风向","fl":"<3级","type":"晴","notice":"天气干燥，请适当增加室内湿度"},{"date":"27日星期一","sunrise":"07:11","high":"高温 5.0℃","low":"低温 -4.0℃","sunset":"16:52","aqi":166,"fx":"西南风","fl":"<3级","type":"晴","notice":"天气干燥，请适当增加室内湿度"},{"date":"28日星期二","sunrise":"07:12","high":"高温 8.0℃","low":"低温 -5.0℃","sunset":"16:51","aqi":108,"fx":"北风","fl":"3-4级","type":"多云","notice":"绵绵的云朵，形状千变万化"},{"date":"29日星期三","sunrise":"07:13","high":"高温 3.0℃","low":"低温 -4.0℃","sunset":"16:51","aqi":40,"fx":"东南风","fl":"<3级","type":"阴","notice":"阴天是彩虹的前期之景"}]
 * @author jiangchong
 * @since 2017/11/25 19:32
 * @version 1.0
 */
public class WeatherData {

    private String shidu;
    private double pm25;
    private double pm10;
    private String quality;
    private String wendu;
    private String ganmao;
    private YesterdayData yesterday;
    private List<ForecastData> forecast;

    public String getShidu() {
        return shidu;
    }

    public void setShidu(String shidu) {
        this.shidu = shidu;
    }

    public double getPm25() {
        return pm25;
    }

    public void setPm25(double pm25) {
        this.pm25 = pm25;
    }

    public double getPm10() {
        return pm10;
    }

    public void setPm10(double pm10) {
        this.pm10 = pm10;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public YesterdayData getYesterday() {
        return yesterday;
    }

    public void setYesterday(YesterdayData yesterday) {
        this.yesterday = yesterday;
    }

    public List<ForecastData> getForecast() {
        return forecast;
    }

    public void setForecast(List<ForecastData> forecast) {
        this.forecast = forecast;
    }
}
