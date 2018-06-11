package com.service.date.dateservice.commons;

import static com.service.date.dateservice.commons.DateTimeStrings.*;
import static org.junit.Assert.*;

import org.junit.Test;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class DateTimeStringsTest {

    @Test
    public void testDate() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneOffset.UTC);
        String date = date(zonedDateTime);
        assertNotNull(date);
        assertEquals(10, date.length());
    }

    @Test
    public void testDateForNull() {
        assertNull(date(null));
    }

    @Test
    public void testTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneOffset.UTC);
        String time = time(zonedDateTime);
        assertNotNull(time);
        assertTrue(10 < time.length());
        assertTrue(13 > time.length());
    }

    @Test
    public void testTimeForNull() {
        assertNull(time(null));
    }

    @Test
    public void testDateTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneOffset.UTC);
        String dateTime = dateTime(zonedDateTime);
        assertNotNull(dateTime);
        assertTrue(22 < dateTime.length());
        assertTrue(24 > dateTime.length());
    }

    @Test
    public void testDateTimeForNull() {
        assertNull(dateTime(null));
    }

    @Test
    public void testTimezoneName() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneOffset.UTC);
        String timezoneName = timezoneName(zonedDateTime);
        assertNotNull(timezoneName);
        assertEquals("Coordinated Universal Time", timezoneName);
    }

    @Test
    public void testTimezoneNameForNull() {
        assertNull(timezoneName(null));
    }

    @Test
    public void testZonedDateTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneOffset.UTC);
        String resultZonedDateTime = zonedDateTime(zonedDateTime);
        assertNotNull(resultZonedDateTime);
        assertTrue(22 < resultZonedDateTime.length());
        assertTrue(25 > resultZonedDateTime.length());
    }

    @Test
    public void testZonedDateTimeForNull() {
        assertNull(zonedDateTime(null));
    }
}
