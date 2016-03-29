/**
 * 
 */
package com.vinodborole.brainteasers.ctm.exception;

/**
 * The Class InValidDatePolicyException is the type of CTMPolicyException that validates date related policies 
 * 
 * @author vborole
 */
public class InValidDatePolicyException extends CTMPolicyException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1428859123256982720L;

    /**
     * Instantiates a new in valid date policy exception.
     * 
     * @param message
     *            the message
     */
    public InValidDatePolicyException(final String message) {
        super(message);
    }
}
