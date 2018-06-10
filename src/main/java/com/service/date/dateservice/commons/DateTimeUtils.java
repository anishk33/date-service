package com.service.date.dateservice.commons;

import com.service.date.dateservice.exceptions.DataNotFoundException;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

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
}
