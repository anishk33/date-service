package com.service.date.dateservice.models;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DateTime {

    private String date;
    private String time;
    private String datetime;
    private String timezone;

    public DateTime(final String date, final String time) {
        this(date, time, null, null);
    }

    public DateTime(final String date, final String time, final String datetime) {
        this(date, time, datetime, null);
    }

    public DateTime(final String date, final String time, final String datetime, final String timezone) {
        this.date = date;
        this.time = time;
        this.datetime = datetime;
        this.timezone = timezone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return String.format("%s::%s::%s::%s", date, time, datetime, timezone);
    }
}
