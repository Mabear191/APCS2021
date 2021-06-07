package main;

import java.util.ArrayList;

public class Tracker {
	
	private boolean running = true;
	private List _l = new List();
	
	// user introduction to the program, along with initial selection for which of the multiple phases of the program they will be using 
	public Tracker() {
		while(running) {
			String start = JOP.in(
					"Welcome, This program is designed to keep track of hikers, their hiking locations and the time at the location." +
					"\n " +
					"\nIn order to manage the list and its contents plz type in 'manage' or 'm'." + 
					"\nIn order to view the list and its statistics in its entirety you can either type 'view' or 'v'." +
					"\nExit Type 'exit' or 'x' to close the program once on this screen."
					);
			if(start.equalsIgnoreCase("")) {
				
			}
			//sends you to the list management phase of the program, first method
			else if(start.equalsIgnoreCase("manage") || start.equalsIgnoreCase("m")) {
				ManageList();
			}
			//sends you into the statistic viewing phase of the program , second method
			else if(start.equalsIgnoreCase("view") || start.equalsIgnoreCase("v")) {
				ViewStats();
			}
			//allows you to exit the program from this menu
			else if(start.equalsIgnoreCase("exit") || start.equalsIgnoreCase("x")) {
				running = false;
			}
		}
	}
	
	//this is the phase were you can edit the list, if you want to remove, you type in the name, and if you want to add you would fill out three parameters of info
	private void ManageList() {
		boolean managing = true;
		while(managing) {
			String manageChoice = JOP.in("would you like to add or remove a hike path?");
			if(manageChoice.equalsIgnoreCase("add")) {
				String name = JOP.in("type in the hiker's name please");
				String location = JOP.in("type in the hike location please.");
				String duration = JOP.in("type in the hike's duration in seconds please.");
				if(!(name.equalsIgnoreCase("")) && !(location.equalsIgnoreCase("")) && !(duration.equalsIgnoreCase(""))) {
					_l.addHike(name, location, duration);
				}
				else {
					JOP.msg("you didnt fill out the form properly");
				}
			}
			else if(manageChoice.equalsIgnoreCase("remove")) {
				String name = JOP.in("type in the name of the hiker you would like to remove please.");
				_l.removeHiker(name);
			}
			else if(manageChoice.equalsIgnoreCase("back") || manageChoice.equalsIgnoreCase("b")) {
				managing = false;
			}
			/*//SHORTCUTS: IGNORE
			else if(manageChoice.equalsIgnoreCase("a1")) {
				_l.addHike("matai", "420","69");
			}
			else if(manageChoice.equalsIgnoreCase("a2")) {
				_l.addHike("matai", "240","60");
			}
			else if(manageChoice.equalsIgnoreCase("a3")) {
				_l.addHike("tai", "69","420");
			}
			else if(manageChoice.equalsIgnoreCase("a4")) {
				_l.addHike("tai", "60","240");
			}
			else if(manageChoice.equalsIgnoreCase("r1")) {
				_l.removeHiker("matai");
			}
			else if(manageChoice.equalsIgnoreCase("r2")) {
				_l.removeHiker("tai");
			}*/
		}
	}
	
	//this is just statistic viewing of certain attributes, you can either search by name or location, or just get a list with all attributes
	private void ViewStats() {
		boolean viewing = true;
		while(viewing) {
			String viewChoice = JOP.in(
					"type 'list' or 'l' to view a list of all the hikes" +
					"\ntype 'duration' or 'd' to view statistics for duration based on either name or location"
					);
			if (viewChoice == null) {
				
			}
			else if(viewChoice.equalsIgnoreCase("list") || viewChoice.equalsIgnoreCase("l")) {
				JOP.msg(_l.listAll());
			}
			else if(viewChoice.equalsIgnoreCase("duration") || viewChoice.equalsIgnoreCase("d")) {
				String durationChoice = JOP.in(
						"type 'name' or 'n' in order view a total duration for a specific hiker" +
						"\ntype 'location or 'l' in order to view a total duration for a specific location"
						);
				if(durationChoice.equalsIgnoreCase("name") || durationChoice.equalsIgnoreCase("n")) {
					String name = JOP.in("please type in the hiker's name.");
					if(!(name.equalsIgnoreCase(""))) {
						JOP.msg(_l.totalDurationName(name));
					}
					else {
						JOP.msg("you need to type a name");
					}
				}
				else if (durationChoice.equalsIgnoreCase("location") || durationChoice.equalsIgnoreCase("l")) {
					String location = JOP.in("please type in the location name.");
					if(!(location.equalsIgnoreCase(""))) {
						JOP.msg(_l.totalDurationLocation(location));
					}
					else {
						JOP.msg("you need to type a location");
					}
				}
			}
			else if(viewChoice.equalsIgnoreCase("back") || viewChoice.equalsIgnoreCase("b")) {
				viewing = false;
			}
		}
	}
}
