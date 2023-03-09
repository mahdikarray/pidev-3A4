package com.esprit.veltun.gui.event.weather;

public class WeatherData {
    private Double latitude;
    private Double longitude;
    private Double generationtime_ms;
    private Long utc_offset_seconds;
    private String timezone;
    private String timezone_abbreviation;
    private Long elevation;

    private Weather current_weather;

    public Weather getCurrent_weather() {
        return current_weather;
    }

    public void setCurrent_weather(Weather current_weather) {
        this.current_weather = current_weather;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getGenerationtime_ms() {
        return generationtime_ms;
    }

    public Long getUtc_offset_seconds() {
        return utc_offset_seconds;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getTimezone_abbreviation() {
        return timezone_abbreviation;
    }

    public Long getElevation() {
        return elevation;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setGenerationtime_ms(Double generationtime_ms) {
        this.generationtime_ms = generationtime_ms;
    }

    public void setUtc_offset_seconds(Long utc_offset_seconds) {
        this.utc_offset_seconds = utc_offset_seconds;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setTimezone_abbreviation(String timezone_abbreviation) {
        this.timezone_abbreviation = timezone_abbreviation;
    }

    public void setElevation(Long elevation) {
        this.elevation = elevation;
    }
}
