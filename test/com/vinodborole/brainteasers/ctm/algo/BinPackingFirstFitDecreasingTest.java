/**
 * 
 */
package com.vinodborole.brainteasers.ctm.algo;

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
 * The Class BinPackingFirstFitDecreasingTest.
 * 
 * @author vborole
 */
public class BinPackingFirstFitDecreasingTest {
    /** The talks. */
    List<TalkInfo> talks=null;
    
    /** The bin packing first fit decreasing. */
    BinPackingFirstFitDecreasing binPackingFirstFitDecreasing=null;
    
    /** The schedule date. */
    Date scheduleDate=null;
    /**
     * Setup.
     */ 
    @Before
    public void setUp(){
        talks= new ArrayList<TalkInfo>();
        
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        scheduleDate = cal.getTime();
   }
    
    /**
     * Tear down.
     */
    @After
    public void tearDown(){
        binPackingFirstFitDecreasing=null;
        talks.removeAll(talks);
    }
    
    
    /**
     * Test_execute algo.
     */
    @Test
    public void test_executeAlgo(){
        try {
            setTalkInformation();
            BinPackingFirstFitDecreasing  binPackingFirstFitDecreasing = new BinPackingFirstFitDecreasing(talks, scheduleDate);
            List<Track> tracks = binPackingFirstFitDecreasing.execute();
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
        } catch (CTMException e) {
            Assert.fail("Bin Packing First Fit Decreasing Algo Failed");
            e.printStackTrace();
        }
    }
    
    /**
     * Sets the talk information.
     * 
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
