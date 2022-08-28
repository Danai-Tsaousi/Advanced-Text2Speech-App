package Model;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;


public class TTSFacade /*implements TXSAPI*/{
	
	VoiceManager vm;
	Voice voice;
	private int volume=3,pitch=190,rate=150;
	
    public TTSFacade() {}
    
	public void play(String str) {
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		voice=VoiceManager.getInstance().getVoice("kevin16");
		if(voice !=null) {
			voice.allocate();
			
		}
		try {
			voice.setRate(rate);
			voice.setPitch(pitch);
			voice.setVolume(volume);
			voice.speak(str);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public int getVolume() {
		return volume;
	}
	public void setPitch(int pitch) {
		this.pitch = pitch;
	}
	public int getPitch() {
		return pitch;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}	
	public int getRate() {
		return rate;
	}
}
