package com.hormiga6.javapractice.calendar;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

public class CalendarTest {
    @Test
    public void testInit() {
        //month start from 0
        Calendar instance1 = Calendar.getInstance();
        instance1.set(2016, 10, 7, 12, 0, 0);
        Calendar instance2 = Calendar.getInstance();
        instance2.set(2016, 9, 24, 12, 0, 0);

        assertThat(instance1.getTime().toString(), is("Mon Nov 07 12:00:00 JST 2016"));
        assertThat(instance2.getTime().toString(), is("Mon Oct 24 12:00:00 JST 2016"));

        //another instance
        assertThat((instance1 == instance2), is(false));
        assertThat(instance1.getTimeInMillis() - instance2.getTimeInMillis(),
                is(both(greaterThan(60 * 60 * 24 * 14 * 1000L - 1000L))
                        .and(lessThan(60 * 60 * 24 * 14 * 1000L + 1000L))));
    }
}
