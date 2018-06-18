package org.unioulu.tol.sqat.bsc.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat.bsc.Frame;

public class TestFrame {

	@Test
	public void testFrameScoreisZero() {
		Frame frame = new Frame(0,0);
		assertEquals(frame.score(),0);
	}
	
	@Test
	public void testFrameScoreFirstThrow0() {
		Frame frame = new Frame(0,2);
		assertEquals(frame.score(),2);
		frame = new Frame(0,1);
		assertEquals(frame.score(),1);
	}
	
	@Test
	public void testFrameScoreSecondThrow0() {
		Frame frame;
		frame = new Frame(2,0);
		assertEquals(frame.score(),2);
		frame = new Frame(1,0);
		assertEquals(frame.score(),1);
	}
	
	@Test
	public void testFrameScoreBothThrowsNot0() {
		Frame frame;
		frame = new Frame(1,2);
		assertEquals(frame.score(),3);
		
		frame = new Frame(2,1);
		assertEquals(frame.score(),3);
		
		frame = new Frame(2,2);
		assertEquals(frame.score(),4);
	}
	
	@Test
	public void testStrike() {
		Frame strike = new Frame(10,0);
		assertTrue(strike.isStrike());
		
		Frame notStrike1 = new Frame(9,0);
		assertFalse(notStrike1.isStrike());
		
		Frame notStrike2 = new Frame(0,10);
		assertFalse(notStrike2.isStrike());
	}
	
	@Test
	public void testSpare() {
		Frame spare1 = new Frame(9,1);
		assertTrue(spare1.isSpare());
		Frame spare2 = new Frame(1,9);
		assertTrue(spare2.isSpare());
		Frame spare3 = new Frame(0,10);
		assertTrue(spare3.isSpare());
		
		assertEquals(spare1.score(),10);
		assertEquals(spare2.score(),10);
		assertEquals(spare3.score(),10);
		
		//don't mix up strikes with spares!
		Frame strike = new Frame(10,0);
		assertFalse(strike.isSpare());
		
		//sum is not 10
		Frame notSpare = new Frame(3,4);
		assertFalse(notSpare.isSpare());
	}
	
	@Test
	public void testStrikeScore() {
		Frame strike = new Frame(10,0);
		assertEquals(strike.score(),10);
	}
	
}
