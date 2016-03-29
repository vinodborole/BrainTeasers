/**
 * 
 */
package com.vinodborole.brainteasers.ctm.bean;

import java.util.Date;

/**
 * The Class TalkInfo holds the basic set of information of a conference talk.
 * 
 * @author vborole
 */
public class TalkInfo {
    
    /** The talk title. */
    private String talkTitle;
    
    /** The talk time in minutes. */
    private int talkTimeInMinutes;
    
    /** The start time of the talk. */
    private Date startTime;
    
    /** The end time of the talk. */
    private Date endTime;

    /**
     * Gets the talk title.
     * 
     * @return the talk title
     */
    public String getTalkTitle() {
        return talkTitle;
    }

    /**
     * Sets the talk title.
     * 
     * @param talkTitle
     *            the new talk title
     */
    public void setTalkTitle(final String talkTitle) {
        this.talkTitle = talkTitle;
    }

    /**
     * Gets the talk time in minutes.
     * 
     * @return the talk time in minutes
     */
    public int getTalkTimeInMinutes() {
        return talkTimeInMinutes;
    }

    /**
     * Sets the talk time in minutes.
     * 
     * @param talkTimeInMinutes
     *            the new talk time in minutes
     */
    public void setTalkTimeInMinutes(final int talkTimeInMinutes) {
        this.talkTimeInMinutes = talkTimeInMinutes;
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

    /**
     * Gets the end time.
     * 
     * @return the end time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * Sets the end time.
     * 
     * @param endTime
     *            the new end time
     */
    public void setEndTime(final Date endTime) {
        this.endTime = endTime;
    }

 }
