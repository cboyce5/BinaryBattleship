package BattleshipTests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import BattleshipGame.Assets;

public class LoadImagesTests {

	public static Image testImage;

	@BeforeClass
	public static void setUp() {
		Assets.initAssets();
		testImage = null;
	}

	@Test
	public void loadImages() {

		try {
			testImage = ImageIO.read(new File("resources/Hit.png"));
			assertTrue(compareImages((BufferedImage) testImage, (BufferedImage) Assets.getHit()));

			testImage = ImageIO.read(new File("resources/Miss.png"));
			assertTrue(compareImages((BufferedImage) testImage, (BufferedImage) Assets.getMiss()));

			testImage = ImageIO.read(new File("resources/PuddleR.png"));
			assertTrue(compareImages((BufferedImage) testImage, (BufferedImage) Assets.getPuddle()));

			testImage = ImageIO.read(new File("resources/Ship.png"));
			assertTrue(compareImages((BufferedImage) testImage, (BufferedImage) Assets.getShip()));

			testImage = ImageIO.read(new File("resources/Sunk.png"));
			assertTrue(compareImages((BufferedImage) testImage, (BufferedImage) Assets.getSunk()));

			testImage = ImageIO.read(new File("resources/Water.png"));
			assertTrue(compareImages((BufferedImage) testImage, (BufferedImage) Assets.getWater()));
		} catch (IOException e) {
			System.out.println("Error reading images in LoadImagesTests");
		}

	}

	public boolean compareImages(BufferedImage imageA, BufferedImage imageB) {
		
		// Check for nulls
		if (imageA == null || imageB == null) {return false;}
		
		// Check size
		if (imageA.getWidth() == imageB.getWidth() && imageA.getHeight() == imageB.getHeight()) {
			int width = imageA.getWidth();
			int height = imageA.getHeight();

			// Check every pixel
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					if (imageA.getRGB(x, y) != imageB.getRGB(x, y)) {
						return false;
					}
				}
			}
		} else {return false;}

		return true;
	}

}
