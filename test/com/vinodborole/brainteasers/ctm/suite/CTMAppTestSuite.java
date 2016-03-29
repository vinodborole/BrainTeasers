/**
 * 
 */
package com.vinodborole.brainteasers.ctm.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.vinodborole.brainteasers.ctm.algo.BinPackingFirstFitDecreasingTest;
import com.vinodborole.brainteasers.ctm.manager.CTMManagerTestWithBinPackingFirstFitDecreasingAlgo;
import com.vinodborole.brainteasers.ctm.policy.CTMCustomPolicyTest;


/**
 * @author vborole
 *
 */
@RunWith(Suite.class)
@SuiteClasses({CTMManagerTestWithBinPackingFirstFitDecreasingAlgo.class,BinPackingFirstFitDecreasingTest.class,CTMCustomPolicyTest.class})
public class CTMAppTestSuite {

}
