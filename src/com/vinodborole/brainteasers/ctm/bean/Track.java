/**
 * 
 */
package com.vinodborole.brainteasers.ctm.bean;

import java.util.Date;
import java.util.Map;

/**
 * The Class Track, represent a day that is divided into multiple sessions
 * 
 * @author vborole
 */
public class Track {
    
    /** The list of sessions. */
    private Map<SessionType, Session> sessions;
    
    /** The track schedule date. */
    private Date scheduleDate;

    /**
     * Instantiates a new track.
     * 
     * @param scheduleDate
     *            the schedule date
     */
    public Track(final Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    /**
     * Gets the schedule date.
     * 
     * @return the schedule date
     */
    public Date getScheduleDate() {
        return scheduleDate;
    }

    /**
     * Sets the schedule date.
     * 
     * @param scheduleDate
     *            the new schedule date
     */
    public void setScheduleDate(final Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    /**
     * Gets the sessions.
     * 
     * @return the sessions
     */
    public Map<SessionType, Session> getSessions() {
        return sessions;
    }

    /**
     * Sets the sessions.
     * 
     * @param sessions
     *            the sessions
     */
    public void setSessions(final Map<SessionType, Session> sessions) {
        this.sessions = sessions;
    }

}
