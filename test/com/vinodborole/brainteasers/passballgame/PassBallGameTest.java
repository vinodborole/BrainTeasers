package com.vinodborole.brainteasers.passballgame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PassBallGameTest {

	PassBallGame p = null;

	@Before
	public void setUp() throws Exception {
		p = new PassBallGame();
	}

	@Test
	public void testPassCount() {
		int passcount=p.passCount(5, 3, 2);
		assertTrue(passcount==10);
	}
	@Test
	public void testPassCount_ValidInput_L_lessThan_N_greaterThan_Zero() {
		int passcount=p.passCount(5, 3, 1);
		assertTrue(passcount==10);
	}
	@Test
	public void testPassCount_ValidInput_N_EqualTo_Three() {
		int passcount=p.passCount(3, 3, 2);
		assertTrue(passcount==6);
	}
	@Test
	public void testPassCount_ValidInput_N_EqualTo_Thousand() {
		int passcount=p.passCount(1000, 3, 2);
		assertTrue(passcount==1000);
	}
	@Test
	public void testPassCount_ValidInput_M_EqualTo_Thousand() {
		int passcount=p.passCount(5, 1000, 2);
		assertTrue(passcount==4995);
	}
	@Test
	public void testPassCount_ValidInput_M_EqualTo_Three() {
		int passcount=p.passCount(5, 3, 1);
		assertTrue(passcount==10);
	}
	@Test
	public void testPassCount_invalidInput_L_greaterThan_N() {
		int passcount=p.passCount(5, 3, 6);
		assertTrue(passcount==-1);
	}
	@Test
	public void testPassCount_invalidInput_L_equalTo_N_equalTo_M() {
		int passcount=p.passCount(5, 5, 5);
		assertTrue(passcount==-1);
	}
	@Test
	public void testPassCount_invalidInput_L_lessThan_Zero() {
		int passcount=p.passCount(5, 3, -1);
		assertTrue(passcount==-1);
	}
	@Test
	public void testPassCount_invalidInput_L_EqualTo_Zero() {
		int passcount=p.passCount(5, 3, 0);
		assertTrue(passcount==-1);
	}
	@Test
	public void testPassCount_invalidInput_M_LessThan_Three() {
		int passcount=p.passCount(5, 2, 2);
		assertTrue(passcount==-1);
	}
	@Test
	public void testPassCount_invalidInput_M_greaterThan_Thousand() {
		int passcount=p.passCount(5, 2, 1001);
		assertTrue(passcount==-1);
	}
	@Test
	public void testPassCount_invalidInput_N_lessThan_Three() {
		int passcount=p.passCount(2, 2, 1);
		assertTrue(passcount==-1);
	}
	@Test
	public void testPassCount_invalidInput_N_greatherThan_Thousand() {
		int passcount=p.passCount(1001, 2, 1);
		assertTrue(passcount==-1);
	}
	
	
	
}
