import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
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
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;




public class GraphicalHammingDistance extends JFrame
{
	
	
	private JLabel hammingDistanceInfo;
	private JLabel distance0;
	private JLabel distance1;
	private JLabel distance2;
	private JLabel distance3;
	private JLabel distance4;
	private JLabel compareWith;
	
	private JTextField addStationText;
	
	
	private JButton showStation;
	private JButton calculateHD;
	private JButton addStation;
	
	private JSlider slider;
	
	private JComboBox box;
	
	private Rectangle sliderbox;
	private Rectangle distancebox0;
	private Rectangle distancebox1;
	private Rectangle distancebox2;
	private Rectangle distancebox3;
	private Rectangle distancebox4;
	
	
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
	
	

	
	public static void main(String[] args)
	{
		
	}
	
	
}

