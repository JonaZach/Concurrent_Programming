package bgu.spl.a2.sim.privateStates;

import java.util.ArrayList;
import java.util.List;

import bgu.spl.a2.PrivateState;

/**
 * this class describe course's private state
 */
public class CoursePrivateState extends PrivateState{

	private Integer availableSpots;
	private Integer registered;
	private List<String> regStudents;
	private List<String> prequisites;
	
	/**
 	 * Implementors note: you may not add other constructors to this class nor
	 * you allowed to add any other parameter to this constructor - changing
	 * this may cause automatic tests to fail..
	 */
	public CoursePrivateState() {
		availableSpots = new Integer(0);
		registered = new Integer(0);
		regStudents = new ArrayList<String>();
		prequisites = new ArrayList<String>();
	}

	public Integer getAvailableSpots() {
		return availableSpots;
	}

	public Integer getRegistered() {
		return registered;
	}

	public List<String> getRegStudents() {
		return regStudents;
	}

	public List<String> getPrequisites() {
		return prequisites;
	}
	
	public void setAvailable (int available)
	{
		this.availableSpots=available;
	}
	
	public void setPrequisites(List<String> reqs)
	{
		this.prequisites=reqs;
	}
	
	public boolean addStudent (String newStudent)
	{
		if (availableSpots>0 && !regStudents.contains(newStudent))
		{
			availableSpots--;
			registered++;
			regStudents.add(newStudent);
			return true;
		}
		return false;
	}
	
	public void removeStudent (String student)
	{
		if (regStudents.contains(student))
		{
			registered--;
			regStudents.remove(student);
			if (availableSpots!=-1)
				availableSpots++;
		}
	}
}
