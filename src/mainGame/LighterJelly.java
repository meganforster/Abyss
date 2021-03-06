package mainGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * A type of enemy in the game
 * 
 * @author Brandon Loehle 5/30/16
 *
 */

public class LighterJelly extends GameObject {

	//Instance variables
	private Handler handler;
	private Image img;

	//Constructor 
	public LighterJelly(double x, double y, int velX, int velY, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		this.velX = velX;
		this.velY = velY;
		
		//Reads in image for jelly
		img = null;
		try {
			img = ImageIO.read(new File("images/LighterJelly.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.health = 1000;//full health is 1000
	}
		

	//Controls jelly movement
	public void tick() {
		this.x += velX;
		this.y += velY;

		//Jelly bounces off screen left and right sides 
		if (this.y <= 0 || this.y >= Game.HEIGHT - 40)
			velY *= -1;
		if (this.x <= 0 || this.x >= Game.WIDTH - 16)
			velX *= -1;


		collision();

	}
	
	//Collision code for jelly
	public void collision() {

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.PlayerBullet) {// tempObject is an enemy

				// collision code
				if (getBounds().intersects(tempObject.getBounds())) {
					setX(100000); //Teleport jelly far off screen when shot by player
					HUD.score = HUD.score + 25;
				}
			}
		}
	}
	
	//Returns jelly image 
	public Image getImage(String path) {
		Image image = null;
		try {
			URL imageURL = Game.class.getResource(path);
			image = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return image;
	}

	//Draws jelly
	public void render(Graphics g) {

        g.drawImage(img, (int) this.x, (int) this.y, 64, 64, null); 

	}

	@Override
	//Jelly hit box
	public Rectangle getBounds() {
		return new Rectangle((int) this.x, (int) this.y, 64, 64);
	}

}
