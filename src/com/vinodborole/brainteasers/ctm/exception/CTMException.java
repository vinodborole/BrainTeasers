/**
 * 
 */
package com.vinodborole.brainteasers.ctm.exception;

/**
 * The Class CTMException, is the top level exceeption for conference track management
 * 
 * @author vborole
 */
public class CTMException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2337313926713859835L;
    
    /**
     * Instantiates a new cTM exception.
     * 
     * @param message
     *            the message
     */
    public CTMException(String message){
        super(message);
    }
}
