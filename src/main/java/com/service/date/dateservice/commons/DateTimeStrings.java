package com.service.date.dateservice.commons;

import java.time.ZonedDateTime;
import java.util.TimeZone;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_TIME;
import static java.time.format.DateTimeFormatter.ISO_ZONED_DATE_TIME;

public final class DateTimeStrings {

    public static String date(final ZonedDateTime zonedDateTime) {
        return zonedDateTime == null ? null : zonedDateTime.format(ISO_LOCAL_DATE);
    }

    public static String time(final ZonedDateTime zonedDateTime) {
        return zonedDateTime == null ? null : zonedDateTime.format(ISO_LOCAL_TIME);
    }

    public static String dateTime(final ZonedDateTime zonedDateTime) {
        return zonedDateTime == null ? null : zonedDateTime.format(ISO_LOCAL_DATE_TIME);
    }

    public static String timezoneName(final ZonedDateTime zonedDateTime) {
        return zonedDateTime == null ? null : TimeZone.getTimeZone(zonedDateTime.getZone()).getDisplayName();
    }

    public static String zonedDateTime(final ZonedDateTime zonedDateTime) {
        return zonedDateTime == null ? null : zonedDateTime.format(ISO_ZONED_DATE_TIME);
    }

}
