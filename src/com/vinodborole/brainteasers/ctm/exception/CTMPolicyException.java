/**
 * 
 */
package com.vinodborole.brainteasers.ctm.exception;

/**
 * The Class CTMPolicyException, is the top level exception for conference track management policies
 * 
 * @author vborole
 */
public class CTMPolicyException extends CTMException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3137583203786392746L;

    /**
     * Instantiates a new cTM policy exception.
     * 
     * @param message
     *            the message
     */
    public CTMPolicyException(final String message) {
        super(message);
    }
}
