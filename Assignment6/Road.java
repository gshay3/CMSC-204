/**
 * Class: CMSC204
 * Description: Road class represents an edge in the graph connecting two Town objects.
 * Each road has a source town, destination town, distance (weight),
 * and a name. Roads are used in pathfinding and graph operations.
 * @author Griffin Shay
 */

import java.util.Objects;

public class Road
{
	private Town source;
	private Town destination;
	private int distance;
	private String name;
	
	// Constructor initializing all fields.
	Road(Town source, Town destination, int distance, String name)
	{
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.name = name;
	}
	
	// Constructor with default distance of 1.
	Road(Town source, Town destination, String name)
	{
		this.source = source;
		this.destination = destination;
		this.distance = 1;
		this.name = name;
	}
	
	// Compares roads first by name, then by distance if names match.
	public int compareTo(Road road)
	{
		int comparison = this.name.compareTo(road.name);
		if(comparison == 0)
		{
			return Integer.compare(this.distance, road.distance);
		}
		return this.name.compareTo(road.name);
	}
	
	// Checks if this road is connected to the given town.
	public boolean contains(Town town)
	{
		if(source.getName().equals(town.getName()) || destination.getName().equals(town.getName()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// Determines equality based on source, destination, distance, and name.
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
		Road road =(Road) x;
		return distance == road.distance && 
				Objects.equals(source, road.source) &&
				Objects.equals(destination, road.destination) &&
				Objects.equals(name, road.name);
	}
	
	// Returns a formatted string representation of the raod.
	@Override
	public String toString()
	{
		String str = "";
		str = source.getName() + " via " + name + " to " + destination.getName() + " " + distance + " mi";
		return str;
	}
	
	// Returns the source town.
	public Town getSource()
	{
		return source;
	}
	
	// Returns the destination town.
	public Town getDestination()
	{
		return destination;
	}
	
	// Returns the distance.
	public int getDistance()
	{
		return distance;
	}
	
	// Returns the road name.
	public String getName()
	{
		return name;
	}

}
