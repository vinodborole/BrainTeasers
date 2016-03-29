/**
 * 
 */
package com.vinodborole.brainteasers.ctm.manager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.vinodborole.brainteasers.ctm.bean.SessionType;
import com.vinodborole.brainteasers.ctm.bean.TalkInfo;
import com.vinodborole.brainteasers.ctm.bean.Track;
import com.vinodborole.brainteasers.ctm.exception.CTMException;


/**
 * The Class CTMManagerTestWithBinPackingFirstFitDecreasingAlgo.
 * 
 * @author vborole
 */
public class CTMManagerTestWithBinPackingFirstFitDecreasingAlgo { 

    /** The talks. */
    List<TalkInfo> talks=null;
    
    /** The ctm manager. */
    CTMManager ctmManager=null;
    
    /**
     * Setup.
     */
    @Before
    public void setUp(){
        talks= new ArrayList<TalkInfo>();
        setTalkInformation();
        ctmManager=new CTMManager();
    }
    
    /**
     * Tear down.
     */
    @After
    public void tearDown(){
        ctmManager=null;
        talks.removeAll(talks);
    }
    
    /**
     * Test_manage conference.
     */
    @Test
    public void test_manageConference(){
        try{
            final Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, 1);
            final Date scheduleDate = cal.getTime();
            List<Track> tracks = ctmManager.manageConference(talks, scheduleDate);
            Assert.assertEquals(tracks.size(),2);
            Assert.assertNotNull(tracks.get(0).getSessions().get(SessionType.MORNING));
            Assert.assertNotNull(tracks.get(0).getSessions().get(SessionType.LUNCH));
            Assert.assertNotNull(tracks.get(0).getSessions().get(SessionType.EVENING));
            Assert.assertNotNull(tracks.get(0).getSessions().get(SessionType.NETWORKING));
            Assert.assertEquals(tracks.get(0).getSessions().get(SessionType.MORNING).getTalks().size(), 5);
            Assert.assertEquals(tracks.get(0).getSessions().get(SessionType.EVENING).getTalks().size(), 5);
            Assert.assertNotNull(tracks.get(1).getSessions().get(SessionType.MORNING));
            Assert.assertNotNull(tracks.get(1).getSessions().get(SessionType.LUNCH));
            Assert.assertNotNull(tracks.get(1).getSessions().get(SessionType.EVENING));
            Assert.assertNotNull(tracks.get(1).getSessions().get(SessionType.NETWORKING));
            Assert.assertEquals(tracks.get(1).getSessions().get(SessionType.MORNING).getTalks().size(), 5);
            Assert.assertEquals(tracks.get(1).getSessions().get(SessionType.EVENING).getTalks().size(), 4);
        }catch(CTMException e){
            Assert.fail("Manage Conference Test Failed");
            e.printStackTrace();
        }
    }
    
    /**
     * Sets the talk information.
     * This is wrong, test it in chunks.
     * @return the list
     */
    private List<TalkInfo> setTalkInformation() {
        
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
