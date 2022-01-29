package model;

public class FakeTTSFacade extends TTSFacade{

	private String playedContents = "";
	private int volume;
	private int rate;
	private int pitch;
	
	public String getPlayedContents()
	{
		return this.playedContents;
	}
	
	public void setVolume(int volume)
	{
		this.volume = volume;
	}
	
	public void setRate(int rate)
	{
		this.rate = rate;
	}
	
	public void setPitch(int pitch)
	{
		this.pitch = pitch;
	}
	
	public int getVolume()
	{
		return this.volume;
	}
	
	public int getRate()
	{
		return this.rate;
	}
	
	public int getPitch()
	{
		return this.pitch;
	}
	
	public void playFTTS(String text,int volume,int rate,int pitch)
	{
		this.playedContents = text;
		super.playFTTS(playedContents, volume, rate, pitch);
	}
	
}
