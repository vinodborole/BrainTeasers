/**
 * 
 */
package com.vinodborole.brainteasers.ctm.policy;

import com.vinodborole.brainteasers.ctm.exception.CTMPolicyException;


/**
 * The Interface ICTMPolicy helps executing policy on a set of talks which that are to be scheduled in sessions and tracks
 * 
 * @author vborole
 */
public interface ICTMPolicy {

    /**
     * Execute policy.
     * 
     * @throws CTMPolicyException
     *             the cTM policy exception
     */
    void executePolicy() throws CTMPolicyException;
}
