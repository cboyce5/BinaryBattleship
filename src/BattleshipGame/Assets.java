package BattleshipGame;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Assets {

	public static Image hit, miss, puddle, ship, sunk, water, hitC, puddleR, planks;
	
	public Assets() {
		initAssets();
	}
	
	public static Image loadImage(String path) {
		
		try {
			return ImageIO.read(new File(path));		
		} catch (IOException e) {
			System.out.println("Error reading input file for:");
			System.out.println(path);
			System.exit(1);
		}
		
		return null;
	}
	
	public static void initAssets() {
		
		hit = loadImage("resources/Hit.png");
		miss = loadImage("resources/Miss.png");
		puddle = loadImage("resources/Puddle.png");
		ship = loadImage("resources//Ship.png");
		sunk = loadImage("resources/Sunk.png");
		water = loadImage("resources/Water.png");
		hitC = loadImage("resources/HitC.png");
		puddleR = loadImage("resources/PuddleR.png");
		planks = loadImage("resources/Planks.png");
	}
	
	public static Image getHit() {
		return hit;
	}
	public static Image getMiss() {
		return miss;
	}
	public static Image getPuddle() {
		return puddleR;
	}
	public static Image getShip() {
		return ship;
	}
	public static Image getSunk() {
		return sunk;
	}
	public static Image getWater() {
		return water;
	}
	public static Image getHitC() {
		return hitC;
	}
	public static Image getPlankes() {
		return planks;
	}
}
