/**
 * 
 */
package com.vinodborole.brainteasers.ctm.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.vinodborole.brainteasers.ctm.bean.Session;
import com.vinodborole.brainteasers.ctm.bean.SessionType;
import com.vinodborole.brainteasers.ctm.bean.TalkInfo;
import com.vinodborole.brainteasers.ctm.bean.Track;
import com.vinodborole.brainteasers.ctm.exception.CTMException;
import com.vinodborole.brainteasers.ctm.exception.CTMPolicyException;
import com.vinodborole.brainteasers.ctm.exception.InValidDatePolicyException;
import com.vinodborole.brainteasers.ctm.exception.NoTalksAvailaiblePolicyException;
import com.vinodborole.brainteasers.ctm.exception.TalkExtendingTimePolicyException;
import com.vinodborole.brainteasers.ctm.manager.CTMManager;


/**  
 * The Class CTMApp is the entry point for Conference track management application.
 * 
 * @author vborole
 */
public class CTMApp {

    /**
     * The main method.
     * 
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        final CTMApp ctmApp = new CTMApp();
        final List<TalkInfo> talks = ctmApp.getTalkInformation();
        final CTMManager ctmManager = new CTMManager();
        List<Track> tracks;
        try {
            final Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, 1);
            final Date scheduleDate = cal.getTime();
            tracks = ctmManager.manageConference(talks, scheduleDate);
            ctmApp.printConferenceSchedule(tracks);
        } catch (final NoTalksAvailaiblePolicyException e) {
            e.printStackTrace();
        } catch (final InValidDatePolicyException e) {
            e.printStackTrace();
        } catch (final TalkExtendingTimePolicyException e) {
            e.printStackTrace();
        } catch (final CTMPolicyException e) {
            e.printStackTrace();
        } catch (CTMException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints the conference schedule.
     * 
     * @param tracks
     *            the tracks
     */
    private void printConferenceSchedule(final Collection<Track> tracks) {
        int i = 1;
        for (final Track track : tracks) {
            System.out.println("Track Number: " + i + " - Scheduled Date: " + track.getScheduleDate());
            System.out.println("------Morning----------------------------------------------------------------------------------------");
            final Map<SessionType, Session> sessions = track.getSessions();
            final Session morningSession = sessions.get(SessionType.MORNING);
            if (morningSession != null) {
                final Collection<TalkInfo> mtalks = morningSession.getTalks();
                for (final TalkInfo talk : mtalks) {
                    System.out.println("| " + talk.getStartTime() + "-" + talk.getEndTime() + ":" + talk.getTalkTitle() + " " + talk.getTalkTimeInMinutes());
                }
            } else {
                System.out.println("NO TALKS AVAILAIBLE FOR MORNING SESSION");
            }
            final Session lunchSession = sessions.get(SessionType.LUNCH);
            System.out.println("------Lunch------------------------------------------------------------------------------------------");
            System.out.println("| " + lunchSession.getStartTime() + ": LUNCH");
            System.out.println("------Evening----------------------------------------------------------------------------------------");
            final Session eveningSession = sessions.get(SessionType.EVENING);
            if (eveningSession != null) {
                final Collection<TalkInfo> etalks = eveningSession.getTalks();
                for (final TalkInfo talk : etalks) {
                    System.out.println("| " + talk.getStartTime() + "-" + talk.getEndTime() + ":" + talk.getTalkTitle() + " " + talk.getTalkTimeInMinutes());
                }
            } else {
                System.out.println("NO TALKS AVAILAIBLE FOR EVENING SESSION");
            }
            final Session networkingSession = sessions.get(SessionType.NETWORKING);
            System.out.println("| " + networkingSession.getStartTime() + ": Networking");
            System.out.println("******************************************************************************************************");
            i++;
        }
    }

    /**
     * Gets the talk information.
     * 
     * @return the talk information
     */
    private List<TalkInfo> getTalkInformation() {
        final List<TalkInfo> talks = new ArrayList<TalkInfo>();
        final String[][] talksArr = { { "Writing Fast Tests Against Enterprise Rails", "60" }, { "Overdoing it in Python", "45" }, { "Lua for the Masses", "30" },
                { "Ruby Errors from Mismatched Gem Versions", "45" }, { "Common Ruby Errors", "45" }, { "Rails for Python Developers", "5" },
                { "Communicating Over Distance", "60" }, { "Accounting-Driven Development", "45" }, { "Woah", "30" }, { "Sit Down and Write", "30" },
                { "Pair Programming vs Noise", "45" }, { "Rails Magic", "60" }, { "Ruby on Rails: Why We Should Move On", "60" }, { "Clojure Ate Scala (on my project)", "45" },
                { "Programming in the Boondocks of Seattle", "30" }, { "Ruby vs. Clojure for Back-End Development", "30" }, { "Ruby on Rails Legacy App Maintenance", "60" },
                { "A World Without HackerNews", "30" }, { "User Interface CSS in Rails Apps", "30" } };
        for (final String talkArr[] : talksArr) {
            final TalkInfo talk = new TalkInfo(); 
            talk.setTalkTitle(talkArr[0]);
            talk.setTalkTimeInMinutes(Integer.parseInt(talkArr[1]));
            talks.add(talk);
        }
        return talks;
    }

}
