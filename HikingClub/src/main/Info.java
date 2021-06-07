package main;

import java.util.ArrayList;

public class Info {
	
	String name;
	String location;
	int duration;
	//this is the object class that we use to make our array list, that contain, the hiker name, duration and location all in one object to then be put into a list
	public Info(String hikeName, String hikeLocation, int hikeDuration) {
		
		name = hikeName;
		location = hikeLocation;
		duration = hikeDuration;
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getLocation() {
		return location;
	}
	
	public String getDuration() {
		return duration + "";
	}
	
	public int getTime() {
		return duration;
	}
	
	public String toString() {
		return getName() + " " + getLocation() + " " + getDuration() + " ";
	}
}