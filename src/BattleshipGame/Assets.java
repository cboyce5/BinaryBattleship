package BattleshipGame;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Assets {

	public static Image hit, miss, puddle, ship, sunk, water;
	
	private static Image loadImage(String path) {
		try {
			return ImageIO.read(Assets.class.getResource(path));		
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
	public static void initAssets() {
		
		hit = loadImage("Hit.png");
		miss = loadImage("Miss.png");
		puddle = loadImage("Puddle.png");
		ship = loadImage("Ship.png");
		sunk = loadImage("Sunk.png");
		water = loadImage("Water.png");
	}
}
