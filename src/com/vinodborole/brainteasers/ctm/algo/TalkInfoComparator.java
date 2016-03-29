/**
 * 
 */
package com.vinodborole.brainteasers.ctm.algo;

import java.util.Comparator;

import com.vinodborole.brainteasers.ctm.bean.TalkInfo;



/**
 * The Class TalkInfoComparator is used by the Bin-Packing First Fit decreasing algorithm to sort the talks as per the talk time.
 * 
 * @author vborole
 */
public class TalkInfoComparator implements Comparator<TalkInfo> {

    /* (non-Javadoc)
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(TalkInfo o1, TalkInfo o2) {
        if (o1.getTalkTimeInMinutes() > o2.getTalkTimeInMinutes()) {
            return 1;
        }
        return 0;
    }

}
