package org.unioulu.tol.sqat.bsc;

public class Frame {
	private int firstThrow;
	private int secondThrow;
	
	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
	}
	
	public int firstThrow() {
		return firstThrow;
	}
	
	public int secondThrow() {
		return secondThrow;
	}
	
	//the score of a single frame
	public int score(){
		//to be implemented
		int score = 0;
		if(isStrike() || isSpare()) {
			score = 10;
		} else {
			score = firstThrow + secondThrow;
		}
		
		return score;
	}

	//returns whether the frame is a strike or not
	public boolean isStrike(){
		//to be implemented
		return firstThrow == 10 && secondThrow == 0;
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare(){
		return (firstThrow + secondThrow == 10)
				&& firstThrow != 10;
	}

	//return whether this is the last frame of the match
	public boolean isLastFrame(){
		//to be implemented
		return false;
	}

	//bonus throws
	public int bonus(){
		//to be implemented
		return 0;
	}
}
