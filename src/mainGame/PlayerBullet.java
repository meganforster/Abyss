package mainGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class PlayerBullet extends GameObject {

	private Handler handler;
	
	public PlayerBullet(double x, double y, double pVelX, double pVelY, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		if (pVelX > 0) {velX = 20;}
		if (pVelX < 0) {velX = -20;}

		if (pVelY > 0) {velY = 20;}
		if (pVelY < 0) {velY = -20;}
	}
	
	

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		this.x += velX;
		this.y += velY;

		// if (this.y <= 0 || this.y >= Game.HEIGHT - 40) velY *= -1;
		// if (this.x <= 0 || this.x >= Game.WIDTH - 16) velX *= -1;

		if (this.y >= Game.HEIGHT || this.x >= Game.WIDTH)
			handler.removeObject(this);
			//handler.addObject(new Trail(x, y, ID.Trail, Color.MAGENTA, 16, 16, 0.025, this.handler));
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.fillRect((int) x, (int) y, 16, 16);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int) this.x, (int) this.y, 16, 16);
	}
	
}
