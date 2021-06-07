package main;

import java.util.ArrayList;

public class List {
	// actual array list used through out the program is made and the info objects are stored here
	private ArrayList <Info> infoList;
	private int hikeDur = 0;
	
	public List() {
		infoList = new ArrayList<Info>();
	}
	// allows you to add a hiker to the list given you have the three parameters, and then sorts them based on hike duration
	public void addHike(String hikeName, String hikeLocation, String hikeDuration) {
		hikeDur = Integer.parseInt(hikeDuration);
		if(this.infoList.size() == 0) {
			this.infoList.add(new Info(hikeName, hikeLocation, hikeDur));
		}
		else if (this.infoList.size() != 0) {
			boolean unsorted = true;
			for(int i = 0; i < this.infoList.size(); i++) {
				if(hikeName.compareToIgnoreCase(this.infoList.get(i).getName()) <= 0 && unsorted) {
					this.infoList.add(i, new Info(hikeName, hikeLocation, hikeDur));
					unsorted = false;
				}
			}
			
			if(unsorted) {
			this.infoList.add(new Info(hikeName, hikeLocation, hikeDur));
			}
		}
	}
	//allows you to remove hiker based on name (modifier)
	public void removeHiker(String hikeName) {
		for(int i = this.infoList.size()- 1; i >= 0; i--) {
			if(hikeName.equalsIgnoreCase(this.infoList.get(i).getName())) {
				infoList.remove(i);
			}
		}
	}
	//getter method that lists every thing
	public String listAll() {
		String total = "";
		for(int i = 0; i <this.infoList.size(); i++) {
			total += "\n" + infoList.get(i).toString();
		}
		return total;
	}
	//gives the total minutes for a given hiker (getter)
	public String totalDurationName(String hikeName) {
		int total = 0;
		for(int i = 0; i < this.infoList.size(); i++) {
			if(infoList.get(i).getName().equalsIgnoreCase(hikeName)) {
				total += infoList.get(i).getTime();
			}
		}
		return "" + total;
	}
	//gives the total minutes for a given location (getter)
	public String totalDurationLocation(String hikeLocation) {
		int total = 0;
		for(int i = 0; i < this.infoList.size(); i++) {
			if(infoList.get(i).getLocation().equalsIgnoreCase(hikeLocation)) {
				total += infoList.get(i).getTime();
			}
		}
		return "" + total;
	}
}