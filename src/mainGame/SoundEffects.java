package mainGame;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class SoundEffects {
	
	private Clip clipb = null;
	private Clip clip = null;
	
	public SoundEffects() {
		
	}
	
	public void playOnce(String song) {
		try {
			AudioInputStream stream;
			AudioFormat format;
			DataLine.Info info;

			stream = AudioSystem.getAudioInputStream(new File(song));
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
		} catch (Exception e) {
		}	
	}
	
	public void playCont(String song) {
		
		try {
			AudioInputStream stream;
			AudioFormat format;
			DataLine.Info info;

			stream = AudioSystem.getAudioInputStream(new File(song));
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clipb = (Clip) AudioSystem.getLine(info);
			clipb.open(stream);
			clipb.start();
			clipb.loop(clipb.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
		}
	}
	
	public void stop() {
		clipb.close();
		
	}
	
	public void stop2() {
		clip.close();
	}
	


}
