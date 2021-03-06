package mainGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

import mainGame.Game.STATE;

/**
 * The Pause Menu
 * 
 * @author  Corey Maiorino 11/23/17
 *
 */

public class Pause {
	
	//Instance variables 
	private Game game;
	private Handler handler;
	private HUD hud;
	private String text;
	private int buttonwidth = Game.WIDTH/4;
	private int buttonheight = Game.HEIGHT/5;

	//Constructor 
	public Pause(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}
	
	//Visually stops movement when game is pause?
	public void tick() {
		game.run();
	}

	/** 
	 *   Layout for Pause Menu
	 *   Consists of a Pause title, 
	 *   and three buttons: Play, Help, Exit
	 * 
	 */
	
	//Draws the pause menu option "buttons"
	public void render(Graphics g) {
		if (game.gameState == STATE.Pause) {
			Font font = new Font("Amoebic", 1, Game.WIDTH/20);
			Font font2 = new Font("Amoebic", 1, Game.WIDTH/30);

			g.setFont(font);
			Rectangle titleCenter = new Rectangle (((Game.WIDTH - 500)/2), ((Game.HEIGHT - 200)/16), 500, 200);
			g.setColor(Color.white);
			drawCenteredString(g, "PAUSE", titleCenter, font);

			g.setFont(font2);
			g.setColor(Color.white);
			g.drawRect( ((Game.WIDTH - buttonwidth)/2), ((Game.HEIGHT - buttonheight)/2), buttonwidth, buttonheight);
			Rectangle playButton = new Rectangle (((Game.WIDTH - buttonwidth)/2), ((Game.HEIGHT - buttonheight)/2), buttonwidth, buttonheight);
			g.setColor(Color.white);
			drawCenteredString(g, "Play", playButton, font2);

			g.setFont(font2);
			g.setColor(Color.white);
			g.drawRect(((Game.WIDTH - buttonwidth)/16), ((Game.HEIGHT - buttonheight)*5/6), buttonwidth, buttonheight);
			Rectangle helpButton = new Rectangle (((Game.WIDTH - buttonwidth)/16), ((Game.HEIGHT - buttonheight)*5/6), buttonwidth, buttonheight);
			g.setColor(Color.white);
			drawCenteredString(g, "Help", helpButton, font2 );

			g.setFont(font2);
			g.setColor(Color.white);
			g.drawRect(((Game.WIDTH - buttonwidth)*15/16), ((Game.HEIGHT - buttonheight)*5/6), buttonwidth, buttonheight);
			Rectangle exitButton = new Rectangle (((Game.WIDTH - buttonwidth)*15/16), ((Game.HEIGHT - buttonheight)*5/6), buttonwidth, buttonheight);
			g.setColor(Color.white);
			drawCenteredString(g, "Exit", exitButton, font2 );
		}

	}
	
	//Not sure 
	public int getTextWidth(Font font, String text) {
		AffineTransform at = new AffineTransform();
		FontRenderContext frc = new FontRenderContext(at, true, true);
		int textWidth = (int) (font.getStringBounds(text, frc).getWidth());
		return textWidth;
	}
	
	//Code for drawing a line of text in the middle of a rectangle
	public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {

		FontMetrics metrics = g.getFontMetrics(font);

		int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
		int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();

		g.setFont(font);
		g.drawString(text, x, y);
	}

}
