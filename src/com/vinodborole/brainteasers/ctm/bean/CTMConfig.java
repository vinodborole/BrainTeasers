/**
 * 
 */
package com.vinodborole.brainteasers.ctm.bean;

/**
 * The Interface CTMConfig defines the set of configuration used by conference management system.
 * 
 * @author vborole
 */
public interface CTMConfig {

    /** The Constant MORNING_SESSION_TIME_CAPACITY. */
    int MORNING_SESSION_TIME_CAPACITY = 210;
    
    /** The Constant LUNCH_SESSION_TIME_CAPACITY. */
    int LUNCH_SESSION_TIME_CAPACITY = 60;
    
    /** The Constant EVENING_SESSION_TIME_CAPACITY. */
    int EVENING_SESSION_TIME_CAPACITY = 240;
    
    /** The Constant NETWORKING_SESSION_TIME_CAPACITY. */
    int NETWORKING_SESSION_TIME_CAPACITY = 60;

    /** The Constant MORNING_SESSION_START_TIME. */
    int MORNING_SESSION_START_TIME = 9;
    
    /** The Constant TRACK_START_TIME. */
    int TRACK_START_TIME = 9;
    
    /** The Constant LUNCH_SESSION_START_TIME. */
    int LUNCH_SESSION_START_TIME = 12;
    
    /** The Constant EVENING_SESSION_START_TIME. */
    int EVENING_SESSION_START_TIME = 1;
    
    /** The Constant NETWORKING_SESSION_START_TIME. */
    int NETWORKING_SESSION_START_TIME = 5;
    
    int SESSION_UPPER_BOUND=EVENING_SESSION_TIME_CAPACITY;
}
