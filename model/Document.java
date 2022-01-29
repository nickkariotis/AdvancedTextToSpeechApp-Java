package model;

import java.util.*;
import input.DocumentReader;
import input.DocumentReaderFactory;
import output.DocumentWriter;
import output.DocumentWriterFactory;

public class Document {
	
	private String docPath;
	private String encoding;
	private ArrayList<String> contents = new ArrayList<String>();
	private DocumentReader documentReader;
	private DocumentReaderFactory docReaderFactory = new DocumentReaderFactory();
	private DocumentWriter documentWriter;
	private DocumentWriterFactory docWriterFactory = new DocumentWriterFactory();
	private TTSFacade audioManager = new TTSFacade();
	private FakeTTSFacade fake = new FakeTTSFacade();
	private int volume;
	private int rate;
	private int pitch;
	
	public  Document()
	{
		;
	}
	
	public ArrayList<String> getContents()
	{
		return contents;
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
	
	public FakeTTSFacade getFake()
	{
		return fake;
	}
	
	public void setContents(ArrayList<String> contents)
	{
		this.contents = contents;
	}
	
	public void setPath(String path)
	{
		docPath = path;
	}
	
	public void setEncoding(String encoding) 
	{
		this.encoding = encoding;
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
	
	
	public void setDocReaderFactory(DocumentReaderFactory docReaderFactory) 
	{
		String extension = docPath.split("\\.")[1];
		documentReader  = docReaderFactory.createReader(docPath,extension,encoding);
	}
	
	public void setDocWriterFactory(DocumentWriterFactory docWriterFactory)
	{
		String extension = docPath.split("\\.")[1];
		documentWriter = docWriterFactory.createWriter(docPath, extension, encoding);
	}
	
	public void setAudioManager(TTSFacade audioManager) 
	{
		this.audioManager = audioManager;
	}
	
	public void open() 
	{
		setDocReaderFactory(docReaderFactory);
		this.contents = documentReader.read();
	}
	
	public void save(ArrayList<String> toSave) 
	{
		setDocWriterFactory(docWriterFactory);
		setContents(toSave);
		documentWriter.write(toSave);
	}
	
	public void playContents()
	{
		String conts = String.join(", ", contents);
		audioManager.playFTTS(conts,volume,rate,pitch);
	}
	
	public void playFake()
	{
		String fakeCont = String.join(", ", contents);
		fake.playFTTS(fakeCont, 100, 200, 200);
	}
	
	public void playLines(int line1, int line2)
	{
		ArrayList<String> temp = new ArrayList<String>();
		for(int i = line1;i <= line2; i++)
		{
			temp.add(contents.get(i));
		}
		String conts = String.join(", ", temp);
		audioManager.playFTTS(conts,volume,rate,pitch);
	}
}
