package mainGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import mainGame.Game.STATE;

public class Theme {

	private Game game;
	private Handler handler;
	private HUD hud;
	private int buttonwidth = Game.WIDTH/4;
	private int buttonheight = Game.HEIGHT/5;
	private String background = "images/8BitBackground.png";
	private String music = "vampireweekend.wav";
	
	public Theme(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.handler = handler;
		this.hud=hud;
	}
	
	public void tick() {
	}
	
	public void render(Graphics g) {
		if(game.gameState == STATE.Theme) {
			Font font = new Font("Amoebic", 1, Game.WIDTH/20);
			
			g.setFont(font);
			g.setColor(Color.white);
			
			Rectangle titleCenter = new Rectangle(((Game.WIDTH-500)/2), ((Game.HEIGHT-200)/16), 500, 200);
			drawCenteredString(g, "Pick a Theme", titleCenter, font);
			g.drawRect(((Game.WIDTH - buttonwidth) / 16), ((Game.HEIGHT - buttonheight) / 2), buttonwidth,
					buttonheight);
			
			
			Rectangle oceanButton = new Rectangle(((Game.WIDTH - buttonwidth) / 16),
					((Game.HEIGHT - buttonheight) / 2), buttonwidth, buttonheight);
			drawCenteredString(g, "Ocean", oceanButton, font);
			Image ocean=null;
			try {
				ocean = ImageIO.read(new File("images/shipwreckbackground.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			g.drawImage(ocean, (Game.WIDTH-buttonwidth)/16, (Game.HEIGHT-buttonheight)* 5 / 6, buttonwidth, buttonheight, Color.white, null);
			
			
			g.drawRect(((Game.WIDTH - buttonwidth) * 15 / 16), ((Game.HEIGHT - buttonheight) /2), buttonwidth,
					buttonheight);
			Rectangle spaceButton = new Rectangle(((Game.WIDTH - buttonwidth) * 15 / 16),
					((Game.HEIGHT - buttonheight)/2), buttonwidth, buttonheight);
			drawCenteredString(g, "Space", spaceButton, font);
			Image space=null;
			try {
				space = ImageIO.read(new File("images/SpaceBackground.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			g.drawImage(space, (Game.WIDTH-buttonwidth)*15/16, (Game.HEIGHT-buttonheight)* 5 / 6, buttonwidth, buttonheight, Color.white, null);
			
			
			g.drawRect(((Game.WIDTH - buttonwidth) / 2), ((Game.HEIGHT - buttonheight)/2), buttonwidth,
					buttonheight);
			Rectangle originalButton = new Rectangle(((Game.WIDTH - buttonwidth) / 2),
					((Game.HEIGHT - buttonheight) /2), buttonwidth, buttonheight);
			drawCenteredString(g,"Classic", originalButton, font);
			Image original=null;
			try {
				original = ImageIO.read(new File("images/8BitBackground.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			g.drawImage(original, (Game.WIDTH-buttonwidth)/2, (Game.HEIGHT-buttonheight)* 5 / 6, buttonwidth, buttonheight, Color.white, null);
			
		}
	}
	
	public int getTextWidth(Font font, String text) {
		AffineTransform at = new AffineTransform();
		FontRenderContext frc = new FontRenderContext(at, true, true);
		int textWidth = (int) (font.getStringBounds(text, frc).getWidth());
		return textWidth;
	}
	
	public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {

		FontMetrics metrics = g.getFontMetrics(font);

		int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
		int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();

		g.setFont(font);
		g.drawString(text, x, y);
	}
	
	public void setBackgroundImage(int x) {
		if(x==0) {
			background = "images/shipwreckbackground.jpg";
		}else if (x==1) {
			background = "images/8BitBackground.png";
		}else if (x==2) {
			background = "images/SpaceBackground.png";		
		}

	}
	
	public void setBackgroundMusic(int x) {
		if(x==0) {
			music = "bubble.wav";
		}else if(x==1) {
			music = "vampireweekend.wav";
		}else if (x==2) {
			music = "SpaceBackgroundMusic.wav";
		}
		game.playMusic();
	
	}
	
	public String getBackground() {
		return background;
	}
	
	public String getMusic() {
		return music;
	}
	
}