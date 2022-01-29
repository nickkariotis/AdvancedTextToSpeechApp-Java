package model;

public interface TTS {

	public void play(String input);
	
	public void setVolume(int volume);
	
	public void setPitch(int pitch);
	
	public void setRate(int rate);
}
