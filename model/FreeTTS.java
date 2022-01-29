package model;


import com.sun.speech.freetts.*;

public class FreeTTS implements TTS{
	
	private Voice voice;
	private VoiceManager voiceManager;
	
	public FreeTTS()
	{
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		voiceManager = VoiceManager.getInstance();
		voice = voiceManager.getVoice("kevin16");
		if (voice != null) 
		{
			voice.allocate();
        }
		
	}
	
	public void play(String input)
	{
		try {
		voice.speak(input);
		}
		catch(Exception ex){
			System.out.println("CANT TALK");
		}
		return;
	}
	
	public void setVolume(int volume)
	{
		float tmp_volume = (float)volume / 100;
		voice.setVolume(tmp_volume);
		return;
	}
	
	public void setPitch(int pitch)
	{
		voice.setPitch(pitch);
		return;
	}
	
	public void setRate(int rate)
	{
		voice.setRate(rate);
		return;
	}
}
