/**
 * 
 */
package com.vinodborole.brainteasers.ctm.policy;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.vinodborole.brainteasers.ctm.bean.TalkInfo;
import com.vinodborole.brainteasers.ctm.exception.CTMPolicyException;
import com.vinodborole.brainteasers.ctm.exception.InValidDatePolicyException;
import com.vinodborole.brainteasers.ctm.exception.NoTalksAvailaiblePolicyException;
import com.vinodborole.brainteasers.ctm.exception.TalkExtendingTimePolicyException;


/**
 * The Class CTMCustomPolicyTest.
 * 
 * @author vborole
 */
public class CTMCustomPolicyTest {
    
    /** The talks. */
    List<TalkInfo> talks=null;
    
    /** The ctm policy. */
    ICTMPolicy ctmPolicy=null;
    
    /**
     * Sets the up.
     */
    @Before
    public void setUp(){
        talks= new ArrayList<TalkInfo>();
        setTalkInformation();
        
    }
    
    /**
     * Tear down.
     */
    @After
    public void tearDown(){
        talks.removeAll(talks);       
        ctmPolicy=null;
    }
    
    /**
     * Test_execute policy_for_no_schedule date.
     * 
     * @throws CTMPolicyException
     *             the cTM policy exception
     */
    @Test(expected=InValidDatePolicyException.class)
    public void test_executePolicy_for_no_scheduleDate() throws CTMPolicyException{
        ctmPolicy = new CTMCustomPolicy(talks, null);
        ctmPolicy.executePolicy();
    }
    
    /**
     * Test_execute policy_for_schedule date_before_currentdate.
     * 
     * @throws CTMPolicyException
     *             the cTM policy exception
     */
    @Test(expected=InValidDatePolicyException.class)
    public void test_executePolicy_for_scheduleDate_before_currentdate() throws CTMPolicyException{
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date scheduleDate=cal.getTime();
        ctmPolicy = new CTMCustomPolicy(talks, scheduleDate);
        ctmPolicy.executePolicy();
    }

    /**
     * Test_execute policy_for_schedule date_equal_to_currentdate.
     * 
     * @throws CTMPolicyException
     *             the cTM policy exception
     */
    @Test(expected=InValidDatePolicyException.class)
    public void test_executePolicy_for_scheduleDate_equal_to_currentdate() throws CTMPolicyException{
        ctmPolicy = new CTMCustomPolicy(talks, new Date());
        ctmPolicy.executePolicy(); 
    }
    
    /**
     * Test_execute policy_for_absent talks.
     * 
     * @throws CTMPolicyException
     *             the cTM policy exception
     */
    @Test(expected=CTMPolicyException.class)
    public void test_executePolicy_for_absentTalks() throws CTMPolicyException{
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Date scheduleDate=cal.getTime();
        ctmPolicy = new CTMCustomPolicy(null, scheduleDate);
        ctmPolicy.executePolicy(); 
    }
    
    /**
     * Test_execute policy_for_no_ talks.
     * 
     * @throws CTMPolicyException
     *             the cTM policy exception
     */
    @Test(expected=NoTalksAvailaiblePolicyException.class)
    public void test_executePolicy_for_no_Talks() throws CTMPolicyException{
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Date scheduleDate=cal.getTime();
        talks.removeAll(talks);
        ctmPolicy = new CTMCustomPolicy(talks, scheduleDate);
        ctmPolicy.executePolicy(); 
    }
    
    /**
     * Test_execute policy_for_ talks_timeoutofrange.
     * 
     * @throws CTMPolicyException
     *             the cTM policy exception
     */
    @Test(expected=TalkExtendingTimePolicyException.class)
    public void test_executePolicy_for_Talks_timeoutofrange() throws CTMPolicyException{
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Date scheduleDate=cal.getTime();
        TalkInfo talk = new TalkInfo();
        talk.setTalkTitle("Advance JUNIT");
        talk.setTalkTimeInMinutes(300);
        talks.add(talk);
        ctmPolicy = new CTMCustomPolicy(talks, scheduleDate);
        ctmPolicy.executePolicy(); 
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
