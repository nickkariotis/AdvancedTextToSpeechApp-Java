package commands;

import java.awt.event.ActionListener;

public class CommandsFactory {

	public CommandsFactory() {
		;
	}
	
	public  ActionListener createCommand(String command, String parameter) {
		if(command.equals("Open Document")) {
			return new OpenDocument(parameter);
		}
		else if(command.equals("Edit Document"))
		{
			return new EditDocument();
		}
		else if(command.equals("Save Document")) {
			return new SaveDocument(parameter);
		}
		else if(command.equals("Document to Speech")) {
			return new DocumentToSpeech("FreeTTS",parameter);
		}
		else if(command.equals("Replay"))
		{
			switch(parameter)
			{
				case("Start"):
					return new StartRecording();
				case("Stop"):
					return new StopRecording();
				case("Play"):
					return new PlaySequence();
				case("Clear"):
					return new ClearSequence();
				default:
					return null;
			}
		}
		else {
			return null;
		}
	}
}
