package cz.fi.muni.pv260;


import cz.fi.muni.pv260.tron.TronGame;

public class Main {

	private static Engine engine = new TronGame();


	public static void main(String[] args) {
		engine.start();
	}



}
