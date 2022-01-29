package model;

public class TTSFacade {

	private TTS freeTTS;
	
	public TTSFacade()
	{
		freeTTS = new FreeTTS();
	}
	
	public void playFTTS(String input,int volume,int rate,int pitch)
	{
		freeTTS.setRate(rate);
		freeTTS.setPitch(pitch);
		freeTTS.setVolume(volume);
		freeTTS.play(input);	
	}
}
