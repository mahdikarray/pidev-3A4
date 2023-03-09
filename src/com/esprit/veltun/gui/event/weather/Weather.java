package com.esprit.veltun.gui.event.weather;

import java.sql.Date;
import java.time.LocalDateTime;

public class Weather {
    private Float temperature;
    private Float windspeed;
    private Integer winddirection;
    private Integer weathercode;
    private Date time;

    public Float getTemperature() {
        return temperature;
    }

    public Float getWindspeed() {
        return windspeed;
    }

    public Integer getWinddirection() {
        return winddirection;
    }

    public Integer getWeathercode() {
        return weathercode;
    }

    public Date getTime() {
        return time;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public void setWindspeed(Float windspeed) {
        this.windspeed = windspeed;
    }

    public void setWinddirection(Integer winddirection) {
        this.winddirection = winddirection;
    }

    public void setWeathercode(Integer weathercode) {
        this.weathercode = weathercode;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
