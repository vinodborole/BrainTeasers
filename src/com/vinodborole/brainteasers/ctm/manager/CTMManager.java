/**
 * 
 */
package com.vinodborole.brainteasers.ctm.manager;

import java.util.Date;
import java.util.List;

import com.vinodborole.brainteasers.ctm.algo.CTMAlgorithm;
import com.vinodborole.brainteasers.ctm.bean.TalkInfo;
import com.vinodborole.brainteasers.ctm.bean.Track;
import com.vinodborole.brainteasers.ctm.exception.CTMException;
import com.vinodborole.brainteasers.ctm.exception.CTMPolicyException;
import com.vinodborole.brainteasers.ctm.policy.CTMCustomPolicy;
import com.vinodborole.brainteasers.ctm.policy.ICTMPolicy;



/**
 * The Class CTMManager is the manager implementation of conference track management that manages the conference into multiple tracks/multiple sessions.
 * It uses a specific algorithm in order to schedule the talks into a session
 *  
 * @author vborole
 */
public class CTMManager extends CTMAlgorithm{

    /**
     * Manage conference.
     * 
     * @param talks
     *            the talks
     * @param scheduleDate
     *            the schedule date
     * @return the list
     * @throws CTMPolicyException
     *             the cTM policy exception
     * @throws CTMException
     *             the cTM exception
     */
    public List<Track> manageConference(final List<TalkInfo> talks, Date scheduleDate) throws CTMPolicyException, CTMException {
        ICTMPolicy ctmPolicy=new CTMCustomPolicy(talks, scheduleDate);
        ctmPolicy.executePolicy();
        
        return scheduleConference(talks, scheduleDate);
    }
}
