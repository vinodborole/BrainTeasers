/**
 * 
 */
package com.vinodborole.brainteasers.ctm.bean;

import java.util.Collection;
import java.util.Date;

/**
 * The Class Session represents the slot in a day inside which talks are schedule,
 * sessions are identified by SessionType that holds value such as MORNING, LUNCH,EVENING,NETWORKING
 * 
 * @author vborole
 */
public class Session {
    
    /** The session capacity in minutes. */
    private int sessionCapacityInMinutes;
    
    /** The session type. */
    private SessionType sessionType;
    
    /** The list of talks in a session. */
    private Collection<TalkInfo> talks;
    
    /** The start time for the session. */
    private Date startTime;

    /**
     * Instantiates a new session.
     * 
     * @param type
     *            the type
     * @param capacityInMinutes
     *            the capacity in minutes
     * @param sTime
     *            the s time
     */
    public Session(final SessionType type, final int capacityInMinutes, final Date sTime) {
        sessionCapacityInMinutes = capacityInMinutes;
        sessionType = type;
        startTime = sTime;
    }

    /**
     * Gets the session capacity in minutes.
     * 
     * @return the session capacity in minutes
     */
    public int getSessionCapacityInMinutes() {
        return sessionCapacityInMinutes;
    }

    /**
     * Sets the session capacity in minutes.
     * 
     * @param sessionCapacityInMinutes
     *            the new session capacity in minutes
     */
    public void setSessionCapacityInMinutes(final int sessionCapacityInMinutes) {
        this.sessionCapacityInMinutes = sessionCapacityInMinutes;
    }

    /**
     * Gets the session type.
     * 
     * @return the session type
     */
    public SessionType getSessionType() {
        return sessionType;
    }

    /**
     * Sets the session type.
     * 
     * @param sessionType
     *            the new session type
     */
    public void setSessionType(final SessionType sessionType) {
        this.sessionType = sessionType;
    }

    /**
     * Gets the talks.
     * 
     * @return the talks
     */
    public Collection<TalkInfo> getTalks() {
        return talks;
    }

    /**
     * Sets the talks.
     * 
     * @param talks
     *            the new talks
     */
    public void setTalks(final Collection<TalkInfo> talks) {
        this.talks = talks;
    }

    /**
     * Gets the start time.
     * 
     * @return the start time
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * Sets the start time.
     * 
     * @param startTime
     *            the new start time
     */
    public void setStartTime(final Date startTime) {
        this.startTime = startTime;
    }

}
