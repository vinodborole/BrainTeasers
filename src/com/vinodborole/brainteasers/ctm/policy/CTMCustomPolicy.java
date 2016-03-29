/**
 * 
 */
package com.vinodborole.brainteasers.ctm.policy;

import java.util.Date;
import java.util.List;

import com.vinodborole.brainteasers.ctm.bean.CTMConfig;
import com.vinodborole.brainteasers.ctm.bean.TalkInfo;
import com.vinodborole.brainteasers.ctm.exception.CTMPolicyException;
import com.vinodborole.brainteasers.ctm.exception.InValidDatePolicyException;
import com.vinodborole.brainteasers.ctm.exception.NoTalksAvailaiblePolicyException;
import com.vinodborole.brainteasers.ctm.exception.TalkExtendingTimePolicyException;

/**
 * The Class CTMCustomPolicy, is policy implementation defined by conference track management system
 * 
 * @author vborole
 */
public class CTMCustomPolicy implements ICTMPolicy {
    
    /** The talks. */
    private List<TalkInfo> talks;
    
    /** The schedule date. */
    private Date scheduleDate;

    
    /**
     * Instantiates a new cTM custom policy.
     * 
     * @param talks
     *            the talks
     * @param scheduleDate
     *            the schedule date
     */
    public CTMCustomPolicy(final List<TalkInfo> talks, Date scheduleDate){
        this.talks=talks;
        this.scheduleDate=scheduleDate;
    }
    /* (non-Javadoc)
     * @see com.vinod.ctm.policy.ICTMPolicy#executePolicy()
     */
    @Override
    public void executePolicy() throws CTMPolicyException {
        validateAgainstConferencePolicy(talks, scheduleDate);

    }
    
    /**
     * Validate against conference policy.
     * 
     * @param talks
     *            the talks
     * @param scheduleDate
     *            the schedule date
     * @throws CTMPolicyException
     *             the cTM policy exception
     */
    private void validateAgainstConferencePolicy(final List<TalkInfo> talks, final Date scheduleDate) throws CTMPolicyException {
        validateTalkPolicy(talks);
        validateScheduleDatePolicy(scheduleDate);
    }

    /**
     * Validate schedule date policy.
     * 
     * @param scheduleDate
     *            the schedule date
     * @throws InValidDatePolicyException
     *             the in valid date policy exception
     */
    private void validateScheduleDatePolicy(final Date scheduleDate) throws InValidDatePolicyException {
        if (scheduleDate == null) {
            throw new InValidDatePolicyException("Schedule Date not found");
        } else if (scheduleDate.compareTo(new Date()) < 0) {
            throw new InValidDatePolicyException("Schedule Date is before current date");
        } else if (scheduleDate.compareTo(new Date()) == 0) {
            throw new InValidDatePolicyException("Schedule Date should be a future date");
        }
    }

    /**
     * Validate talk policy.
     * 
     * @param talks
     *            the talks
     * @throws CTMPolicyException
     *             the cTM policy exception
     */
    private void validateTalkPolicy(final List<TalkInfo> talks) throws CTMPolicyException {
        if (talks != null) {
            if (talks.size() == 0) {
                throw new NoTalksAvailaiblePolicyException("No Talks Availaible");
            } else {
                for (final TalkInfo talk : talks) { 
                    if (talk.getTalkTimeInMinutes() > CTMConfig.SESSION_UPPER_BOUND) {
                        throw new TalkExtendingTimePolicyException("Talk: " + talk.getTalkTitle() + "with Time " + talk.getTalkTimeInMinutes() + " is extending time policy.");
                    }
                }
            }
        }else{
            throw new CTMPolicyException("Talks absent");
        }
    }
}
