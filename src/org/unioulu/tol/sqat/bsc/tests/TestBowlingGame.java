package org.unioulu.tol.sqat.bsc.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.unioulu.tol.sqat.bsc.BowlingGame;
import org.unioulu.tol.sqat.bsc.Frame;


public class TestBowlingGame {

	private static Frame[] frames = {
		new Frame(1,5), new Frame(3,6),new Frame(7,2), new Frame(3,6), new Frame(4,4),
		new Frame(5,3),new Frame(3,3), new Frame(4,5), new Frame(8,1), new Frame(2,6)
	};
	
	private static Frame[] simpleStrikeFrames1 = {
			
	};
	
	@Test
	public void testGameScoreNormalFrames() {
		BowlingGame game = null;
		game = new BowlingGame();
			
		for(Frame frame: frames) {
			game.addFrame(frame);
		}
		
		assertEquals(81,game.score());
	}
	
	private BowlingGame createGame(List<Frame> gameFrames) {
		BowlingGame game = new BowlingGame();
		
		for(Frame frame: gameFrames) {
			game.addFrame(frame);
		}
		
		return game;
	}
	
	@Test
	public void testGameScoreSingleStrikeFirst() {
		ArrayList<Frame> gameFrames = new ArrayList<Frame>(Arrays.asList(frames));
		gameFrames.set(0, new Frame(10,0));
		BowlingGame game = this.createGame(gameFrames);
		assertEquals(94,game.score());
	}
	
	@Test
	public void testGameScoreSingleStrikeLast() {
		ArrayList<Frame> gameFrames = new ArrayList<Frame>(Arrays.asList(frames));
		gameFrames.set(9, new Frame(10,0));
		BowlingGame game = this.createGame(gameFrames);
		int expectedScore = 83;
		assertEquals(expectedScore,game.score());
	}
	
	@Test
	public void testGameScoreSingleStrikeSecondLast() {
		ArrayList<Frame> gameFrames = new ArrayList<Frame>(Arrays.asList(frames));
		gameFrames.set(8, new Frame(10,0));
		BowlingGame game = this.createGame(gameFrames);
		int expectedScore = 90;
		assertEquals(expectedScore,game.score());
	}
	
	@Test
	public void testGameScoreSingleSpareFirst() {
		ArrayList<Frame> gameFrames = new ArrayList<Frame>(Arrays.asList(frames));
		gameFrames.set(0, new Frame(1,9));
		BowlingGame game = this.createGame(gameFrames);
		int expectedScore = 88;
		assertEquals(expectedScore,game.score());
	}
	
	@Test
	public void testGameScoreSingleSpareLast() {
		ArrayList<Frame> gameFrames = new ArrayList<Frame>(Arrays.asList(frames));
		gameFrames.set(9, new Frame(9,1));
		BowlingGame game = this.createGame(gameFrames);
		int expectedScore = 83;
		//TODO: add new bonus throw
		
		assertEquals(expectedScore,game.score());
	}
	
	@Test
	public void testGameScoreSingleSpareSecondLast() {
		ArrayList<Frame> gameFrames = new ArrayList<Frame>(Arrays.asList(frames));
		gameFrames.set(8, new Frame(9,1));
		BowlingGame game = this.createGame(gameFrames);
		int expectedScore = 84;
		assertEquals(expectedScore,game.score());
	}
	
	@Test
	public void testMultipleStrikes1()  {
		ArrayList<Frame> gameFrames = new ArrayList<Frame>(Arrays.asList(frames));
		gameFrames.set(0,new Frame(10,0));
		gameFrames.set(1, new Frame(10,0));
		int expectedScore = 112;
		BowlingGame game = this.createGame(gameFrames);
		assertEquals(expectedScore,game.score());
	}
	
	@Test
	public void testStrikeFollowedBySpare1() {
		ArrayList<Frame> gameFrames = new ArrayList<Frame>(Arrays.asList(frames));
		gameFrames.set(0, new Frame(10,0));
		gameFrames.set(1, new Frame(4,6));
		BowlingGame game = this.createGame(gameFrames);
		int expectedScore = 103;
		assertEquals(expectedScore,game.score());
	}

	@Test
	public void testMultipleSpares1() {
		ArrayList<Frame> gameFrames = new ArrayList<Frame>(Arrays.asList(frames));
		gameFrames.set(0, new Frame(8,2));
		gameFrames.set(1, new Frame(5,5));
		BowlingGame game = this.createGame(gameFrames);
		int expectedScore = 98;
		assertEquals(expectedScore,game.score());
	}
	
}
