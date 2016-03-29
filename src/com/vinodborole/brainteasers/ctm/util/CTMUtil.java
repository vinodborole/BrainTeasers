/**
 * 
 */
package com.vinodborole.brainteasers.ctm.util;

import java.util.Calendar;
import java.util.Date;

import com.vinodborole.brainteasers.ctm.bean.CTMConfig;
import com.vinodborole.brainteasers.ctm.bean.SessionType;


/**
 * The Class CTMUtil is a utility class for conference track management.
 * 
 * @author vborole
 */
public class CTMUtil {

    /**
     * Gets the session start time.
     * 
     * @param sessionType
     *            the session type
     * @param scheduleDate
     *            the schedule date
     * @return the session start time
     */
    public static Date getSessionStartTime(final SessionType sessionType, final Date scheduleDate) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(scheduleDate);
        switch (sessionType) {
            case MORNING: {
                cal.set(Calendar.HOUR_OF_DAY, CTMConfig.MORNING_SESSION_START_TIME);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0);
            }
            break;
            case LUNCH: {
                cal.set(Calendar.HOUR_OF_DAY, CTMConfig.LUNCH_SESSION_START_TIME);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0);
            }
            break;
            case EVENING: {
                cal.set(Calendar.HOUR_OF_DAY, CTMConfig.EVENING_SESSION_START_TIME);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0);
            }
            break;
            case NETWORKING: {
                cal.set(Calendar.HOUR_OF_DAY, CTMConfig.NETWORKING_SESSION_START_TIME);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0);
            }
        }
        return cal.getTime();
    }

    /**
     * Gets the track start time.
     * 
     * @param scheduleDate
     *            the schedule date
     * @return the track start time
     */
    public static Date getTrackStartTime(final Date scheduleDate) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(scheduleDate);
        cal.set(Calendar.HOUR_OF_DAY, CTMConfig.TRACK_START_TIME);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}
