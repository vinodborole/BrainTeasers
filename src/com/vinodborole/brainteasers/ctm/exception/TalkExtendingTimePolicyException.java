/**
 * 
 */
package com.vinodborole.brainteasers.ctm.exception;

/**
 * The Class TalkExtendingTimePolicyException is the type of CTMPolicyException that validates talk related policies.
 * 
 * @author vborole
 */
public class TalkExtendingTimePolicyException extends CTMPolicyException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7501174659758943277L;

    /**
     * Instantiates a new talk extending time policy exception.
     * 
     * @param message
     *            the message
     */
    public TalkExtendingTimePolicyException(final String message) {
        super(message);
    }

}
