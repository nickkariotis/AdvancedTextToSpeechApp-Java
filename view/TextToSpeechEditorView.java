package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.*;
import commands.CommandsFactory;
import javax.swing.event.*;

public class TextToSpeechEditorView {
	
	private JTextArea textArea;
	private int volumeLevel;
	private int pitchLevel;
	private int rateLevel;
	private JTextField tf1;
	private JTextField tf2;
	
	public TextToSpeechEditorView() {
		
		CommandsFactory factory = new CommandsFactory();
		
		JFrame myframe = new JFrame("Advanced Text to Speech App");
		myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JToolBar toolbar = new JToolBar();
		toolbar.setRollover(true);
		JMenuBar mb1 = new JMenuBar();
		JMenu menu1 = new JMenu("File");
		JMenuItem I1 = new JMenuItem("Open Non Encrypted File");
		I1.addActionListener(factory.createCommand("Open Document","Default"));
		JMenuItem I2 = new JMenuItem("Open Rot13 File");
		I2.addActionListener(factory.createCommand("Open Document", "Rot13"));
		JMenuItem I3 = new JMenuItem("Open Atbash File");
		I3.addActionListener(factory.createCommand("Open Document","Atbash"));
		menu1.add(I1);
		menu1.add(I2);
		menu1.add(I3);
		mb1.add(menu1);
		JButton editButton = new JButton("Edit File");
		editButton.addActionListener(factory.createCommand("Edit Document",""));
		editButton.setOpaque(true); 
        editButton.setContentAreaFilled(false);
        editButton.setBorderPainted(false);
		JMenuBar mb2 = new JMenuBar();
		JMenu menu2 = new JMenu("Save File");
		JMenuItem I4 = new JMenuItem("Save Non Encrypted File");
		I4.addActionListener(factory.createCommand("Save Document", "Default"));
		JMenuItem I5 = new JMenuItem("Save Rot13 File");
		I5.addActionListener(factory.createCommand("Save Document", "Rot13"));
		JMenuItem I6 = new JMenuItem("Save Atbash file");
		I6.addActionListener(factory.createCommand("Save Document", "Atbash"));
		menu2.add(I4);
		menu2.add(I5);
		menu2.add(I6);
		mb2.add(menu2);
		JMenuBar mb3 = new JMenuBar();
		JMenu menu3 = new JMenu("Speech");
		JMenu submenu1 = new JMenu("Convert to Speech");
		JMenuItem I7 = new JMenuItem("Play Contents");
		I7.addActionListener(factory.createCommand("Document to Speech", "Convert to Speech"));
		JMenu lineInput = new JMenu("Play Lines");
		JLabel lblIn1 = new JLabel("Line 1  ");
		tf1 = new JTextField();
		JLabel lblIn2 = new JLabel("Line 2  ");
		tf2 = new JTextField();
		JButton submit = new JButton();
		submit.setText("OK");
		submit.addActionListener(factory.createCommand("Document to Speech", "Play Lines"));
		lineInput.add(lblIn1);
		lineInput.add(tf1);
		lineInput.add(lblIn2);
		lineInput.add(tf2);
		lineInput.add(submit);
		submenu1.add(I7);
		submenu1.add(lineInput);
		JMenu submenu2 = new JMenu("Tune Audio");
		
		
		JLabel lblVol = new JLabel("Volume");
        submenu2.add(lblVol);
        JSlider slider_vol = new JSlider(JSlider.HORIZONTAL, 0, 100, 100);
        updateVolume(100);
        slider_vol.addChangeListener(new ChangeListener() {
        	@Override		
        	public void stateChanged(ChangeEvent e)
        	{
        		updateVolume(slider_vol.getValue());
        		ActionListener al = factory.createCommand("Document to Speech","Tune Audio");
				ActionEvent event = new ActionEvent(slider_vol, ActionEvent.RESERVED_ID_MAX + 1 , "volume");
				al.actionPerformed(event);
        	}
        });
        submenu2.add(slider_vol);
        
        JLabel lblSpeechRt = new JLabel("Speech Rate");
        submenu2.add(lblSpeechRt);
        JSlider slider_rate = new JSlider(JSlider.HORIZONTAL, 50, 300, 190);
        updateRate(190);
        slider_rate.addChangeListener(new ChangeListener() {
        	@Override		
        	public void stateChanged(ChangeEvent e)
        	{
        		updateRate(slider_rate.getValue());
        		ActionListener al = factory.createCommand("Document to Speech","Tune Audio");
				ActionEvent event = new ActionEvent(slider_rate, ActionEvent.RESERVED_ID_MAX + 2 , "rate");
				al.actionPerformed(event);
        	}
        });
        
        submenu2.add(slider_rate);

        JLabel lblPitch = new JLabel("Pitch");
        submenu2.add(lblPitch);
        JSlider slider_pitch = new JSlider(JSlider.HORIZONTAL,20,300,150);
        updatePitch(150);
        slider_pitch.addChangeListener(new ChangeListener() {
        	@Override		
        	public void stateChanged(ChangeEvent e)
        	{
        		updatePitch(slider_pitch.getValue());
        		ActionListener al = factory.createCommand("Document to Speech","Tune Audio");
				ActionEvent event = new ActionEvent(slider_pitch, ActionEvent.RESERVED_ID_MAX + 3 , "pitch");
				al.actionPerformed(event);
        	}
        });
        submenu2.add(slider_pitch);
        menu3.add(submenu1);
		menu3.add(submenu2);
		mb3.add(menu3);
		
		JMenuBar mb4 = new JMenuBar();
		JMenu menu4 = new JMenu("Replay");
		JMenuItem I9 = new JMenuItem("Start Recording");
		I9.addActionListener(factory.createCommand("Replay", "Start"));
		JMenuItem I10 = new JMenuItem("Stop Recording");
		I10.addActionListener(factory.createCommand("Replay", "Stop"));
		JMenuItem I11 = new JMenuItem("Play Sequence");
		I11.addActionListener(factory.createCommand("Replay", "Play"));
		JMenuItem I12 = new JMenuItem("Clear Sequence");
		I12.addActionListener(factory.createCommand("Replay", "Clear"));
		menu4.add(I9);
		menu4.add(I10);
		menu4.add(I11);
		menu4.add(I12);
		mb4.add(menu4);
		
		toolbar.add(mb1);
		toolbar.add(editButton);
		toolbar.add(mb2);
		toolbar.add(mb3);
		toolbar.add(mb4);
		toolbar.addSeparator();
		Container contentPane = myframe.getContentPane();
		contentPane.add(toolbar,BorderLayout.NORTH);
		textArea = new JTextArea();
		textArea.setEditable(false);
		myframe.add(textArea);
		myframe.setSize(850,650);
		myframe.setVisible(true);
	}
	
	public JTextArea getTextArea()
	{
		return textArea;
	}
	
	public String getText()
	{
		String text = textArea.getText();
		return text;
	}
	

	
	public int getVolume() {
		return this.volumeLevel;
	}
	
	public int getRate() {
		return this.rateLevel;
	}
	
	public int getPitch() {
		return this.pitchLevel;
	}
	
	public int getLineX()
	{
		return Integer.parseInt(tf1.getText());
	}
	
	public int getLineY()
	{
		return Integer.parseInt(tf2.getText());
	}
	
	
	public void setTextArea(ArrayList<String> text)
	{
		String str = String.join("\n", text);
		textArea.setText(str);
	}
	
	public void updateVolume(int volume) {
		this.volumeLevel = volume;
	}
	
	public void updateRate(int rate) {
		this.rateLevel = rate;
	}
	
	public void updatePitch(int pitch) {
		this.pitchLevel = pitch;
	}
}
