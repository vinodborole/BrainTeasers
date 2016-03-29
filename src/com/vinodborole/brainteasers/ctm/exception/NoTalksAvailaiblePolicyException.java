/**
 * 
 */
package com.vinodborole.brainteasers.ctm.exception;

/**
 * The Class NoTalksAvailaiblePolicyException is the type of CTMPolicyException that validates talk related policies.
 * 
 * @author vborole
 */
public class NoTalksAvailaiblePolicyException extends CTMPolicyException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3105327295483492047L;

    /**
     * Instantiates a new no talks availaible policy exception.
     * 
     * @param message
     *            the message
     */
    public NoTalksAvailaiblePolicyException(final String message) {
        super(message);
    }
}
