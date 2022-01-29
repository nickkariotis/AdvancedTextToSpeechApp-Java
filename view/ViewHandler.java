package view;

public class ViewHandler {
	
	private  TextToSpeechEditorView view;
	private static ViewHandler vh = null;
	private ViewHandler() {
		view = new TextToSpeechEditorView();
	}
	
	public static ViewHandler getHandler()
	{
		if(vh == null)
		{
			vh = new ViewHandler();
		}
		return vh;
	}
	
	public TextToSpeechEditorView getView()
	{
		return view;
	}
}
