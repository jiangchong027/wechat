package com.jc.bean.weather;

/**
 * date : 24日星期五
 * sunrise : 07:08
 * high : 高温 7.0℃
 * low : 低温 -5.0℃
 * sunset : 16:53
 * aqi : 31.0
 * fx : 西南风
 * fl : 3-4级
 * type : 多云
 * notice : 悠悠的云里有淡淡的诗
 * @author jiangchong
 * @since 2017/11/25 19:33
 * @version 1.0
 */
public class YesterdayData {

    private String date;
    private String sunrise;
    private String high;
    private String low;
    private String sunset;
    /**
     * 空气质量指数
     */
    private double aqi;
    private String fx;
    private String fl;
    private String type;
    private String notice;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public double getAqi() {
        return aqi;
    }

    public void setAqi(double aqi) {
        this.aqi = aqi;
    }

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}
