import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Mesonet
{
	private String strg1;
	private String strg2;
	private int distance;
	private int[] node1;
	private int[] node2;
	private ArrayList<String> stations;
	
	
	
	public Mesonet(String strg1, String strg2) throws IOException  //constructor class
	{
		
		this.stations = readFile(); //creates the array list of Stations from the Mesonet file
		
		
		this.strg1 = strg1; 
		this.strg2 = strg2; 
		this.distance = computeDistance(strg1, strg2); //returns distance from two inputed strings
		this.node1 = computeAllDistances(strg1, this.stations); //the distance between this string and the other ones
		this.node2 = computeAllDistances(strg2, this.stations); //^^
		toString(); //to string method goes in constructor so you just print the class and the toString works.
	}
	public static int computeDistance(String strg1, String strg2)
	{
		int distance = 0; 
		for(int i = 0; i < 4; ++i) 
		{
			if(strg1.charAt(i) != strg2.charAt(i))
			{
				++distance; 
			}
		}
		return distance;
	}
	public String toString()
	{
		String x = "The Hamming Distance of " + strg1 + " and " + strg2 + ": " + distance + ".\n"
						+ "Out of 119, for " + strg1 + ", number of nodes are: " +
						node1[0] + ", " + node1[1] + ", " + node1[2] + ", " + node1[3] + " and\n" +
						"for " + strg2 + ", number of nodes are: " + node2[0] + ", " + node2[1] + ", " + node2[2] + ", " 
						+ node2[3] + " respectively.";
		return x;
	}
	public static ArrayList<String> readFile() throws IOException
	{
		ArrayList<String> array = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
    	br.readLine(); 
    	br.readLine();
    	br.readLine();
    	String strg;
    	while(br.ready()) 
    	{
    		strg = br.readLine();
    		String[] temp = strg.split("  ");
    		array.add(temp[0].substring(1, temp[0].length()));
    	}
        br.close();
        return array;
    }
	public static int[] computeAllDistances(String strg, ArrayList<String> data) 
	{
		int[] ds = new int[5];
		int d0 = 0;
		int d1 = 0;
		int d2 = 0;
		int d3 = 0;
		int d4 = 0;
		int distance = 0;
		for(int i = 0; i < data.size(); ++i)
		{
			distance = computeDistance(strg, data.get(i));
			if(distance == 1)
			{
				++d1;
			}
			else if(distance == 0)
			{
				++d0;
			}
			else if(distance == 2)
			{
				++d2;
			}
			else if(distance == 3)
			{
				++d3;
			}
			else if(distance == 4)
			{
				++d4;
			}
			
		}
		ds[0] = d1;
		ds[1] = d2;
		ds[2] = d3;
		ds[3] = d4;
		ds[4] = d0;
		return ds;
	}

}
	
