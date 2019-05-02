DOCUMENTATION

Project 5 is essientially a combination of all three of the mesonet projects and 
putting it to graphics. It was a mixed bag of all the challenges all the projects 
and the labs with Graphics presented. Rather than being given instructions, we
were given a model to go off of. This was much better for me since I am a visual 
learner 


THE PROCESS

I had everything in one class other than my functions which I called from
my Mesonet 1 project. The graphics class contained pretty much everything
begginning with the Created Lists for the list of MesoStations. An arraylist 
and a JComboBox, all the panels I would need initially, all the JLabels, 
the buttons, textfields, Jslider, and JText area. I had two methods and one 
giant constructor (which is essentially the frame-- as it extends Java JFrame)

The first method is a getComboBox model. This method takes in an ArrayList which
I grabbed from my MesoNet class using the readFile method. But since comboboxes 
need to be constricted fom Arrays and not ArrayLists, I needed to do a .toArray


Next was the big picture of the whole thing. The Frame. I started by initialzing 
the list and combobox. The arraylist was called from the Mesonet.readFile() method
and with the array list I created the comboboxmodel and passed the arraylist as 
a parameter. 

But none of this would show so I had to set all of the panels visible. I formatted my
project by having an outer panel which is a 2x1 and an inner panel which is a 3x1. This 
basically allows there to be two main columns in the project. The mandatory project stuff
and my own creative idea. 

The top panel has another panel called hamdis. HamDis is short for HammingDistance. 
All of the distance setting components go in the top panel in the left column.
Now I add all of the components to the panel along with initializing the slider.
The slider had 4 ticks which represnts the all the possible hamming distances. I added
an action listener to slider so that whenever you change values of ticks the text box
containing the value will change along with the slider.

The middle panel is the combobox and text area, and shows all of the mesonet stations
that have the hamming distance as the station selected in the panel below. The action 
listener for the button prints the list of stations that have the 
slider distance when the ShowStation button is pressed To do this I created another 
ArrayList in the action listener so a new one is displayed every press. The listener 
contaisn a for loop that computes all teh distances in comparison to the repsected station.
I added a Scroll pane to text area so if the array list gets to big then you can scroll
to see all of the stations. 

The bottom pannel contains the distances and the add station button. Basically when you
press the Calcluate HD Button it'll display all the stations that have a certain distace
in the textbox. And the add station takes whatever the user types into the textbox and
adds it to the arraylist and the combobox. 


That just about sums up everything I did for this project. The real Trick here was just 
trying to get all the components in the right panel. The function and Action listening 
came off to me natrually. 




		



		
