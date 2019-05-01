import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;




public class GraphicalHammingDistance extends JFrame
{
	private JPanel top = new JPanel();
	private JPanel buttonmiddle = new JPanel();
	private JPanel textmiddle = new JPanel();
	private JPanel boxmiddle = new JPanel();
	private JPanel bottom = new JPanel(new GridLayout(2, 1));
	
	private JLabel hammingDistanceInfo;
	private JLabel distance0;
	private JLabel distance1;
	private JLabel distance2;
	private JLabel distance3;
	private JLabel distance4;
	private JLabel compareWith;
	
	private JTextField addStationText;
	
	private JTextArea showStationText;
	
	
	private JButton showStation;
	private JButton calculateHD;
	private JButton addStation;
	
	private JSlider slider;
	
	private JComboBox box;
	
	private JTextField sliderbox;
	private JTextField distancebox0;
	private JTextField distancebox1;
	private JTextField distancebox2;
	private JTextField distancebox3;
	private JTextField distancebox4;
	private JTextField addStationBox;
	
	private DefaultComboBoxModel<String> getComboBoxModel(List<String> meso)
	{
		ArrayList<String> displayNames = new ArrayList<String>();
		for (String station : meso)
		{
			displayNames.add(station);
		}
		String[] comboBoxModel = displayNames.toArray(new String[displayNames.size()]);
	    return new DefaultComboBoxModel<>(comboBoxModel);
	}
	
	public GraphicalHammingDistance()
	{
		super("Graphical Hamming Distance");
		
		this.setSize(911, 1069);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		top.setVisible(true);
		buttonmiddle.setVisible(true);
		textmiddle.setVisible(true);
		boxmiddle.setVisible(true);
		bottom.setVisible(true);
		
		JPanel outerlayout = new JPanel(new GridLayout(1, 2));
		outerlayout.setVisible(true);
		
		this.add(outerlayout);
		
		JPanel innerlayout = new JPanel(new GridLayout(5, 1));
		innerlayout.setVisible(true);
		outerlayout.add(innerlayout);
		
		
		JButton seperator2 = new JButton("wow");
		seperator2.setVisible(true);
		
		outerlayout.add(seperator2);
		
		JPanel hamdis = new JPanel(new GridLayout(2, 2));
		hamdis.setVisible(true);
		
		top.add(hamdis);
		
		hammingDistanceInfo = new JLabel("Enter Hamming Distance: ");
		hammingDistanceInfo.setVisible(true);
		
		sliderbox = new JTextField();
		sliderbox.setEditable(false);
		
		slider = new JSlider(JSlider.HORIZONTAL, 1, 4, 2);
		
		
		hamdis.add(hammingDistanceInfo);
		hamdis.add(sliderbox);
		hamdis.add(slider);
	
		
		showStation = new JButton("Show Station");
		buttonmiddle.add(showStation);
	
		showStationText = new JTextArea(550, 15);
		showStationText.setEditable(false);
		textmiddle.add(showStationText);
	
		compareWith = new JLabel("Compare With: ");
		JButton boxs = new JButton("wow");
		boxmiddle.add(compareWith);
		boxmiddle.add(boxs);
		
		
		innerlayout.add(top);
		innerlayout.add(buttonmiddle);
		innerlayout.add(textmiddle);
		innerlayout.add(boxmiddle);
		innerlayout.add(bottom);
		
		JPanel calculations = new JPanel(new GridLayout(2, 2));
		calculateHD = new JButton("caculateHD");		
		calculations.add(calculateHD);
		bottom.add(calculations);
		
        
		JPanel distances = new JPanel(new GridLayout(6, 1));
		distances.setVisible(true);
		
		
		bottom.add(distances);
		
		
		distance0 = new JLabel("distance0: ");
		distance1 = new JLabel("distance1: ");
		distance2 = new JLabel("distance2: ");
		distance3 = new JLabel("distance3: ");
		distance4 = new JLabel("distance4: ");
		
		distance0.setVisible(true);
		distance1.setVisible(true);
		distance2.setVisible(true);
		distance3.setVisible(true);
		distance4.setVisible(true);
		
		
		addStation = new JButton("Add Station");
		
	
		
		distancebox0 = new JTextField();
		distancebox0.setEditable(false);
		distancebox1 = new JTextField();
		distancebox1.setEditable(false);
		distancebox2 = new JTextField();
		distancebox2.setEditable(false);
		distancebox3 = new JTextField();
		distancebox3.setEditable(false);
		distancebox4 = new JTextField();
		distancebox4.setEditable(false);
		addStationBox = new JTextField();
	
		
		
		distances.add(distance0);
		distances.add(distancebox0);
		distances.add(distance1);
		distances.add(distancebox1);
		distances.add(distance2);
		distances.add(distancebox2);
		distances.add(distance3);
		distances.add(distancebox3);
		distances.add(distance4);
		distances.add(distancebox4);
		distances.add(addStation);
		distances.add(addStationBox);
		
		
		
		

		this.setVisible(true);
		
	}
	

	
	public static void main(String[] args)
	{
		new GraphicalHammingDistance();
	}
	
	
}

