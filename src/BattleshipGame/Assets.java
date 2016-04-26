package BattleshipGame;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Assets {

	public static Image hit, miss, puddle, ship, sunk, water;
	
	private static Image loadImage(String path) {
		try {
			return ImageIO.read(new File(path));		
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
