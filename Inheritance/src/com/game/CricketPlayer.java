package com.game;

public class CricketPlayer extends Player {
	private int runs, wkts;
	public CricketPlayer() {
		// TODO Auto-generated constructor stub
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getWkts() {
		return wkts;
	}
	public void setWkts(int wkts) {
		this.wkts = wkts;
	}
	@Override
	public String toString() {
		return super.toString() + ", " + runs + ", " + wkts;
	}	

}
