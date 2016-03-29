/**
 * 
 */
package com.vinodborole.brainteasers.ctm.algo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.vinodborole.brainteasers.ctm.bean.CTMConfig;
import com.vinodborole.brainteasers.ctm.bean.Session;
import com.vinodborole.brainteasers.ctm.bean.SessionType;
import com.vinodborole.brainteasers.ctm.bean.TalkInfo;
import com.vinodborole.brainteasers.ctm.bean.Track;
import com.vinodborole.brainteasers.ctm.exception.CTMException;
import com.vinodborole.brainteasers.ctm.util.CTMUtil;


/**
 *  The Class BinPackingFirstFitDecreasing is the implementation for Bin-Packing First Fit with decreasing algorithm.
 *  It is the core logic for fitting the conference talks in respective sessions and sessions into tracks depending 
 *  upon the time frame given for each talk.
 *  <a href=http://en.wikipedia.org/wiki/Bin_packing_problem>Click me</a>
 * 
 * @author vborole
 */
public class BinPackingFirstFitDecreasing {

    /** The talks. */
    private List<TalkInfo> talks;
    
    /** The schedule date. */
    private Date scheduleDate;
    
    /**
     * Instantiates a new bin packing first fit decreasing.
     * 
     * @param talks
     *            the talks
     * @param scheduleDate
     *            the schedule date
     */
    public BinPackingFirstFitDecreasing(final List<TalkInfo> talks, Date scheduleDate){
        this.talks=talks;
        this.scheduleDate=scheduleDate;
    } 
    
    /**
     * Execute the implementation to create tracks and schedule talks into each sessions
     * 
     * @return the list
     * @throws CTMException
     *             the cTM exception
     */
    public List<Track> execute() throws CTMException{
        final List<Track> tracks = new ArrayList<Track>();
        Collections.sort(talks,new TalkInfoComparator()); 
        final Stack<TalkInfo> stack = new Stack<TalkInfo>();
        stack.addAll(talks);
        int day = 0;
        while (!stack.isEmpty()) {
            final Calendar c = Calendar.getInstance();
            c.setTime(scheduleDate);
            c.add(Calendar.DATE, day);
            scheduleDate = c.getTime();
            final Track track = createTrack(stack, scheduleDate);
            tracks.add(track);
            day++;
        }
        return tracks;
    }
    
    /**
     * Creates the tracks.
     * 
     * @param stack
     *            the stack
     * @param scheduleDate
     *            the schedule date
     * @return the track
     */
    private Track createTrack(final Stack<TalkInfo> stack, Date scheduleDate) {
        scheduleDate = CTMUtil.getTrackStartTime(scheduleDate);
        final Track track = new Track(scheduleDate);
        final Map<SessionType, Session> trackSessions = new HashMap<SessionType, Session>();
        final Session morningSession = !stack.isEmpty() ? scheduleSessions(stack, SessionType.MORNING, scheduleDate) : null;
        trackSessions.put(SessionType.MORNING, morningSession);
        final Session lunchSession = scheduleSessions(SessionType.LUNCH, scheduleDate);
        trackSessions.put(SessionType.LUNCH, lunchSession);
        final Session eveningSession = !stack.isEmpty() ? scheduleSessions(stack, SessionType.EVENING, scheduleDate) : null;
        trackSessions.put(SessionType.EVENING, eveningSession);
        final Session networkingSession = scheduleSessions(SessionType.NETWORKING, scheduleDate);
        trackSessions.put(SessionType.NETWORKING, networkingSession);
        track.setScheduleDate(scheduleDate);
        track.setSessions(trackSessions);
        return track;
    }

    /**
     * Schedule sessions for a track with no talks.
     * 
     * @param sessionType
     *            the session type
     * @param scheduleDate
     *            the schedule date
     * @return the session
     */
    private Session scheduleSessions(final SessionType sessionType, final Date scheduleDate) {
        return scheduleSessions(null, sessionType, scheduleDate);
    }

    /**
     * Schedule sessions for a track with given set of talks.
     * 
     * @param stack
     *            the stack
     * @param sessionType
     *            the session type
     * @param scheduleDate
     *            the schedule date
     * @return the session
     */
    private Session scheduleSessions(final Stack<TalkInfo> stack, final SessionType sessionType, final Date scheduleDate) {
        Session session = null;
        switch (sessionType) {
            case MORNING: {
                final Date startTime = CTMUtil.getSessionStartTime(sessionType, scheduleDate);
                session = new Session(SessionType.MORNING, CTMConfig.MORNING_SESSION_TIME_CAPACITY, startTime);
                scheduleTalksInSession(stack, session, startTime);
            }
            break;
            case LUNCH: {
                final Date startTime = CTMUtil.getSessionStartTime(sessionType, scheduleDate);
                session = new Session(SessionType.LUNCH, CTMConfig.LUNCH_SESSION_TIME_CAPACITY, startTime);
            }
            break;
            case EVENING: {
                final Date startTime = CTMUtil.getSessionStartTime(sessionType, scheduleDate);
                session = new Session(SessionType.EVENING, CTMConfig.EVENING_SESSION_TIME_CAPACITY, startTime);
                scheduleTalksInSession(stack, session, startTime);
            }
            break;
            case NETWORKING: {
                final Date startTime = CTMUtil.getSessionStartTime(sessionType, scheduleDate);
                session = new Session(SessionType.NETWORKING, CTMConfig.NETWORKING_SESSION_TIME_CAPACITY, startTime);
            }
        }
        return session;
    }

    /**
     * Schedule talks in session.
     * 
     * @param stack
     *            the stack
     * @param session
     *            the session
     * @param startTime
     *            the start time
     */
    private void scheduleTalksInSession(final Stack<TalkInfo> stack, final Session session, Date startTime) {
        final Collection<TalkInfo> sessionTalks = new ArrayList<TalkInfo>();
        final Calendar cal = Calendar.getInstance();
        do {
            final TalkInfo talk = stack.pop();
            talk.setStartTime(startTime);
            cal.setTime(startTime);
            cal.add(Calendar.MINUTE, talk.getTalkTimeInMinutes());
            final Date endTime = cal.getTime();
            talk.setEndTime(endTime);
            sessionTalks.add(talk);
            session.setSessionCapacityInMinutes(session.getSessionCapacityInMinutes() - talk.getTalkTimeInMinutes());
            startTime = endTime;
        } while (!stack.isEmpty() && session.getSessionCapacityInMinutes() - stack.peek().getTalkTimeInMinutes() >= 0);
        session.setTalks(sessionTalks);
    }    
}
