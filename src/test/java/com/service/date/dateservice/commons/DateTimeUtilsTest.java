package com.service.date.dateservice.commons;

import static com.service.date.dateservice.commons.DateTimeStrings.*;
import static com.service.date.dateservice.commons.DateTimeUtils.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.service.date.dateservice.exceptions.DataNotFoundException;
import com.service.date.dateservice.models.DateTime;
import org.junit.Test;

import java.time.ZonedDateTime;

public class DateTimeUtilsTest {

    @Test
    public void testGetZonedDateTimeForNullTimezone() {
        ZonedDateTime zonedDateTime = getZonedDateTime(null);
        assertEquals("Z", zonedDateTime.getZone().getId());
    }

    @Test
    public void testGetZonedDateTimeForEmptyTimezone() {
        ZonedDateTime zonedDateTime = getZonedDateTime("");
        assertEquals("Z", zonedDateTime.getZone().getId());
    }

    @Test (expected = DataNotFoundException.class)
    public void testGetZonedDateTimeForInvalidTimezone() {
        getZonedDateTime("Invalid");
    }

    @Test
    public void testGetZonedDateTimeForTimezone() {
        String timezone = "Asia/Kolkata";
        ZonedDateTime zonedDateTime = getZonedDateTime(timezone);
        assertEquals(timezone, zonedDateTime.getZone().getId());
    }

    @Test
    public void testToDateTime() {
        ZonedDateTime zonedDateTime = getZonedDateTime(null);
        DateTime expected = new DateTime(date(zonedDateTime), time(zonedDateTime), dateTime(zonedDateTime),
                timezoneName(zonedDateTime));

        DateTime actual = toDateTime(zonedDateTime);
        assertEquals(expected.getDate(), actual.getDate());
        assertEquals(expected.getTime(), actual.getTime());
        assertEquals(expected.getDatetime(), actual.getDatetime());
        assertEquals(expected.getTimezone(), actual.getTimezone());
    }

    @Test
    public void testToDate() {
        ZonedDateTime zonedDateTime = getZonedDateTime(null);
        DateTime expected = new DateTime(date(zonedDateTime), time(zonedDateTime), dateTime(zonedDateTime),
                timezoneName(zonedDateTime));

        DateTime actual = toDate(zonedDateTime);
        assertEquals(expected.getDate(), actual.getDate());
        assertNull(actual.getTime());
        assertNull(actual.getDatetime());
        assertEquals(expected.getTimezone(), actual.getTimezone());
    }

    @Test
    public void testToTime() {
        ZonedDateTime zonedDateTime = getZonedDateTime(null);
        DateTime expected = new DateTime(date(zonedDateTime), time(zonedDateTime), dateTime(zonedDateTime),
                timezoneName(zonedDateTime));

        DateTime actual = toTime(zonedDateTime);
        assertNull(actual.getDate());
        assertEquals(expected.getTime(), actual.getTime());
        assertNull(actual.getDatetime());
        assertEquals(expected.getTimezone(), actual.getTimezone());
    }

    @Test
    public void testToDateTimeForNull() {
        assertNull(toDateTime(null));
    }

    @Test
    public void testToDateForNull() {
        assertNull(toDate(null));
    }

    @Test
    public void testToTimeForNull() {
        assertNull(toTime(null));
    }
}
