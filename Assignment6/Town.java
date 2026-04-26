/**
 * Class: CMSC204
 * Description: Town class represents a vertex in the graph.
 * Each town has a name and a list of adjacent towns (neighbors).
 * Towns are considered equal if they have the same name.
 * @author Griffin Shay
 */

import java.util.ArrayList;
import java.util.Objects;

public class Town implements Comparable<Town> 
{
	private String name = "";
	private ArrayList<Town> adjacentTowns;
	
	// Constructor that initializes the town name and adjacency list.
	public Town(String name)
	{
		this.name = name;
		adjacentTowns = new ArrayList<>();
	}
	
	// Copy constructor that duplicates another Town object.
	public Town(Town town)
	{
		this.name = town.name;
		setAdjacentTowns(town.getAdjacentTowns());	
	}
	
	// Compares towns alphabetically by name.
	public int compareTo(Town town)
	{
		return this.name.compareTo(town.name);
	}
	
	// Determines equality based on town names.
	@Override
	public boolean equals(Object x)
	{
		if(this == x)
		{
			return true;
		}
		if(x == null || getClass() != x.getClass())
		{
			return false;
		}
		Town town = (Town) x;
		return Objects.equals(name, town.name);
	}
	
	// Sets the adjacency list by copying towns from another list.
	public void setAdjacentTowns(ArrayList<Town> towns)
	{
		for(int i = 0; i < towns.size(); i++)
		{
			adjacentTowns.add(towns.get(i));
		}
	}
	
	// Returns the list of adjacent towns.
	public ArrayList<Town> getAdjacentTowns()
	{
		return adjacentTowns;
	}
	
	// Adds a single adjacent town.
	public void addAdjacentTowns(Town town)
	{
		adjacentTowns.add(town);
	}
	
	// Returns the name of the town.
	public String getName()
	{
		return name;
	}
	
	// Generates a hash code based on the town name.
	public int hashCode()
	{
		return name.hashCode();
	}
}
