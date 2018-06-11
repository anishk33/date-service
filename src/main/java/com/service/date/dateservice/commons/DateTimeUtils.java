package com.service.date.dateservice.commons;

import com.service.date.dateservice.exceptions.DataNotFoundException;
import com.service.date.dateservice.models.DateTime;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import static com.service.date.dateservice.commons.DateTimeStrings.*;

public class DateTimeUtils {

    public static ZonedDateTime getZonedDateTime(final String timezone) {
        if (timezone == null || timezone.isEmpty()) {
            return ZonedDateTime.now(ZoneOffset.UTC);
        }
        if (!ZoneId.getAvailableZoneIds().contains(timezone)) {
            throw new DataNotFoundException("Unknown timezone : " + timezone);
        }

        return ZonedDateTime.now(ZoneId.of(timezone));
    }

    public static DateTime toDateTime(final ZonedDateTime zonedDateTime) {
        return zonedDateTime == null ? null :
                new DateTime(date(zonedDateTime), time(zonedDateTime), dateTime(zonedDateTime), timezoneName(zonedDateTime));
    }

    public static DateTime toDate(final ZonedDateTime zonedDateTime) {
        return zonedDateTime == null ? null :
                new DateTime(date(zonedDateTime), null, null, timezoneName(zonedDateTime));
    }

    public static DateTime toTime(final ZonedDateTime zonedDateTime) {
        return zonedDateTime == null ? null :
                new DateTime(null, time(zonedDateTime), null, timezoneName(zonedDateTime));
    }
}
