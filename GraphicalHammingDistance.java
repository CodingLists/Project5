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
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.filechooser.FileSystemView;

import java.io.IOException;




public class GraphicalHammingDistance extends JFrame
{
	
	//Created Lists for the list of MesoStations. An arraylist and a JComboBox
	
	ArrayList<String> stations;
	JComboBox<String> box;
	
	
	//All the panels that I need Initially 
	
	private JPanel top = new JPanel();
	private JPanel buttonmiddle = new JPanel();
	private JPanel textmiddle = new JPanel();
	private JPanel boxmiddle = new JPanel();
	private JPanel bottom = new JPanel(new GridLayout(2, 1)); //Some Require a gridlayout
	private JScrollPane jps;
	
	
	//All the JLabels.  
	
	private JLabel hammingDistanceInfo;
	private JLabel distance0;
	private JLabel distance1;
	private JLabel distance2;
	private JLabel distance3;
	private JLabel distance4;
	private JLabel compareWith;
	
	
	
	
	//All the buttons. A function is attached to each.
	
	private JButton showStation;
	private JButton calculateHD;
	private JButton addStation;
	
	
	
	
	//Text Fields for input and output data

	private JTextField addStationText;
	private JTextField sliderbox;
	private JTextField distancebox0;
	private JTextField distancebox1;
	private JTextField distancebox2;
	private JTextField distancebox3;
	private JTextField distancebox4;
	private JTextField addStationBox;
	
	//Slider to change the hamming distance value
	
	private JSlider slider;
	
	//Text Area where all Stations with the equivalent distance to the slider value are printed. 
	
	private JTextArea showStationText;
	
	
	//This method takes in an ArrayList which I grabbed from my Mesonet class and return a JComboBox.
	private JComboBox<String> getComboBoxModel(ArrayList<String> meso)
	{
		//Combo boxes only take arrays as parameters so I had to chnage the array list to an Array
		String[] comboBoxModel = meso.toArray(new String[meso.size()]); 
	    return new JComboBox<>(comboBoxModel);
	}
	
	//The Frame
	
	public GraphicalHammingDistance() throws IOException
	{
		super("Graphical Hamming Distance"); //The Name of the Frame
		
		
		
		stations = Mesonet.readFile(); //I called a method that reads the imported MesonetFile with a BufferReader.
		box = getComboBoxModel(stations); //Called comboBox Method and used recently instantiated stations ArrayList
		
		this.setSize(900, 1080); //sets frame size
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//Making all of my panels visible 
		
		top.setVisible(true); 
		buttonmiddle.setVisible(true);
		textmiddle.setVisible(true);
		boxmiddle.setVisible(true);
		bottom.setVisible(true);
		
		//An additional JPanel I needed to create two columns on the screen. All project mandatory stuff went on the right
		//My personal created code is shown on the right.
		
		JPanel outerlayout = new JPanel(new GridLayout(1, 2));
		outerlayout.setVisible(true);
		
		this.add(outerlayout); //added the column layouts to frame
		
		//This is the panel where all of the project mandatory stuff will be laid out.
		
		JPanel innerlayout = new JPanel(new GridLayout(5, 1));
		innerlayout.setVisible(true);
		outerlayout.add(innerlayout);
		
		
		//The Error message is my personal addition to the project. It goes in the right column 
		
		JLabel errorMessage = new JLabel("Welcome to the GraphicalHammingDistance Application");
		
		outerlayout.add(errorMessage);
		
		//HamDis is short for HammingDistance. All of the distance setting components go in the top panel in the left column 
		
		JPanel hamdis = new JPanel(new GridLayout(2, 2));
		hamdis.setVisible(true);
		top.add(hamdis); 
		
		//Now I add all of the components to the panel along with initializing the slider 
		
		hammingDistanceInfo = new JLabel("Enter Hamming Distance: ");
		hammingDistanceInfo.setVisible(true);
		sliderbox = new JTextField();
		sliderbox.setEditable(false);
		slider = new JSlider(JSlider.HORIZONTAL, 1, 4, 2); //this allows the slider to have four different distance options (1234)
		slider.setMajorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true); //this paints the distance values on the slider
		sliderbox.setText(""+slider.getValue()); //whatever value the slider is on it will show up in the text field 
		
		//The slider can change values when the user does an action on it. So I added a listener so that when the slider 
		//changes then so does text field. 
		
		slider.addChangeListener((ChangeEvent e)-> 
		{
			sliderbox.setText(""+slider.getValue());
			
		});
	
		//Added all hamming distance components 
		
		hamdis.add(hammingDistanceInfo);
		hamdis.add(sliderbox);
		hamdis.add(slider);
	
		
		//Components for middle panel. This panel has a textbox, combobox and button which shows all of the mesonet stations
		//that have the hamming distance as the station selected in the panel below. 
		
		showStation = new JButton("Show Station");
		buttonmiddle.add(showStation);
		showStationText = new JTextArea(10, 10);
		showStationText.setEditable(false);
		
		
		//This action prints the list of stations that have the slider distance when the ShowStation button is pressed. 
		//To do this I created another ArrayList in the action listener so a new one is displayed every press. 
		
		showStation.addActionListener((e-> 
		{
			ArrayList<String> temp = new ArrayList<String>(); //New Array List
			
			String setter = "";
			
			//A for loop that computes all distances of all the stations in the stations ArrayList in comparison to the
			//selected station below. If the distance matches what is in the slider value then it adds it to the new 
			//Array I have created.
			for(String index : stations) 
			{
				if(Mesonet.computeDistance(stations.get(box.getSelectedIndex()), index) == slider.getValue())
				{
					temp.add(index);
				}
			}
			
			//I made a for loop to print the arraylist in a new line format into the text area. 
			
			for(String jindex : temp)
			{
				setter+= jindex+"\n";
			}
				showStationText.setText(setter);

		}));
	
		//Here I created a JScorllPane so that if the list goes beyond the dimensiosn of the text area you can scroll down
		
		jps = new JScrollPane(showStationText);
		jps.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		//Added Scroll Pane to middle panel which also adds the TextArea
		
		textmiddle.add(jps);

	
		//Compare With is the Label before the ComboBox. The Combobox is how you select which station you want to be compared.
		//The one I refered to alot above. All gets added to middle panel
		
		compareWith = new JLabel("Compare With: ");
		boxmiddle.add(compareWith);
		boxmiddle.add(box);
		
		
		//All panels that go into the left column 
		
		innerlayout.add(top);
		innerlayout.add(buttonmiddle);
		innerlayout.add(textmiddle);
		innerlayout.add(boxmiddle);
		innerlayout.add(bottom);
		
		//This next panel is a two by two GridLayout where the calculations of distances are laid out.
		//The panel gets added to the bottom panel. 
		
		JPanel calculations = new JPanel(new GridLayout(2, 2)); 
		calculateHD = new JButton("caculateHD");		
		calculations.add(calculateHD);
		bottom.add(calculations);
		
		//Action listener where when pressed, the listener goes through the array and checks for the distance between
		//all of the stations with the compared one. The number of station with each respected distance is tallied. 
		
		calculateHD.addActionListener((e)->
		{
			int[] distances = Mesonet.computeAllDistances(stations.get(box.getSelectedIndex()), stations);
			int d0 = distances[4];
			int d1 = distances[0];
			int d2 = distances[1];
			int d3 = distances[2];
			int d4 = distances[3];
			
			distancebox0.setText("" + d0);
			distancebox1.setText("" + d1);
			distancebox2.setText("" + d2);
			distancebox3.setText("" + d3);
			distancebox4.setText("" + d4);
			
		});
		
		
		//The panel where the distances go. All added to bottom panel
        
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

		
		//Add station listener takes whatever is in the addStation Text box and adds it to the area and the combo box.
		
	
		addStation = new JButton("Add Station");
		addStation.addActionListener((e)->
		{
			
			if(addStationBox.getText().length() == 4)
			{
				if(checkForDuplicate(addStationBox.getText()) == false)
				{
					box.addItem(addStationBox.getText());
					stations.add(addStationBox.getText());
					errorMessage.setText("Added Successfully");
				}
				else
				{
					errorMessage.setText("Duplicate stations.");
				}
			}
			else
			{
				errorMessage.setText("Please make the station 4 characters.");
			}		
		});
		
	
		
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
	
	public boolean checkForDuplicate(String meso)
	{
		for(String check : stations)
		{
			if(meso.equalsIgnoreCase(check))
			{
				return true;
			}
		}
		return false;
	}
	

	
	public static void main(String[] args) throws IOException
	{
		new GraphicalHammingDistance();
	}
	
	
}

