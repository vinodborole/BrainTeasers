/**
 * 
 */
package com.vinodborole.brainteasers.ctm.algo;


import java.util.Date;
import java.util.List;

import com.vinodborole.brainteasers.ctm.bean.TalkInfo;
import com.vinodborole.brainteasers.ctm.bean.Track;
import com.vinodborole.brainteasers.ctm.exception.CTMException;


/**
 * The Class CTMAlgorithm provides the default implementation for scheduling talks for a conference.
 * 
 * @author vborole
 */
public abstract class CTMAlgorithm {

    /**
     * Schedule conference.
     * 
     * @param talks
     *            the talks
     * @param scheduleDate
     *            the schedule date
     * @return the list
     * @throws CTMException
     *             the cTM exception
     */
    public List<Track> scheduleConference(final List<TalkInfo> talks, Date scheduleDate) throws CTMException{
         BinPackingFirstFitDecreasing binPackingFirstFitDecreasing = new BinPackingFirstFitDecreasing(talks, scheduleDate);
         return binPackingFirstFitDecreasing.execute();
    }
    
    
} 
