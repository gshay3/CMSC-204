/**
 * Class: CMSC204
 * Description: TownGraphManager acts as a wrapper around the Graph class.
 * It provides higher-level operations using String-based town names
 * instead of directly working with Town objects.
 * This class is responsible for managing towns and roads,
 * as well as loading data and retrieving shortest paths.
 * @author Griffin Shay
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;

public class TownGraphManager implements TownGraphManagerInterface
{
	private Graph graph = new Graph();
	
	// No argument constructor.
	public TownGraphManager()
	{
		
	}
	
	// Adds a road between two towns with a given distance and name.
	@Override
	public boolean addRoad(String source, String destination, int distance, String name)
	{
		if(graph.addEdge(new Town(source), new Town(destination), distance, name) == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	// Returns the name of the road connecting two towns.
	@Override
	public String getRoad(String source, String destination)
	{
		return graph.getEdge(new Town(source), new Town(destination)).getName();
	}
	
	// Adds a town to the graph.
	@Override
	public boolean addTown(String name)
	{
		return graph.addVertex(new Town(name));
	}
	
	// Returns the town with the given name, or null if not found.
	@Override
	public Town getTown(String name)
	{
		for(Town town : graph.vertexSet())
		{
			if(town.getName().equals(name))
			{
				return town;
			}
		}
		return null;
	}
	
	// Checks if the town exists in the graph.
	@Override
	public boolean containsTown(String name)
	{
		return graph.containsVertex(new Town(name));
	}
	
	// Checks if a road exists between two towns.
	@Override
	public boolean containsRoadConnection(String source, String destination)
	{
		return graph.containsEdge(new Town(source), new Town(destination));
	}
	
	// Returns a sorted list of all road names in the graph.
	@Override
	public ArrayList<String> allRoads()
	{
		ArrayList<String> roads = new ArrayList<>();
		for(Road road : graph.edgeSet())
		{
			roads.add(road.getName());
		}
		Collections.sort(roads);
		return roads;
	}
	
	// Removes a road between two towns if it matched the given name.
	@Override
	public boolean deleteRoadConnection(String source, String destination, String road)
	{
		Road r = graph.getEdge(new Town(source), new Town(destination));
		if(r != null && r.getName().equals(road))
		{
			return graph.removeEdge(new Town(source), new Town(destination), r.getDistance(), road) != null;
		}
		return false;
	}
	
	// Removes a town and all connected roads from the graph.
	@Override
	public boolean deleteTown(String name)
	{
		return graph.removeVertex(new Town(name));
	}
	
	// Returns a sorted list of all town names in the graph.
	@Override
	public ArrayList<String> allTowns()
	{
		ArrayList<String> towns = new ArrayList<>();
		for(Town town : graph.vertexSet())
		{
			towns.add(town.getName());
		}
		Collections.sort(towns);
		return towns;
	}
	
	// Returns the shortest path between two towns as a list of formatted strings.
	@Override
	public ArrayList<String> getPath(String source, String destination)
	{
		return graph.shortestPath(new Town(source), new Town(destination));
	}
	
	// Populates the graph using data from a file.
	// Each line is formatted as: road name, distance, town 1, town 2.
	public void populateTownGraph(File file) throws FileNotFoundException, IOException
	{
		try (Scanner scanner = new Scanner(file)) 
		{
			Town town1 = null, town2 = null;
			String line = "";
			String[] splitLine;
			while(scanner.hasNext())
			{
				line = scanner.nextLine();
				splitLine = line.split(",");
				town2 = new Town(splitLine[3]);
				town1 = new Town(splitLine[2]);
				graph.addVertex(town1);
				graph.addVertex(town2);
				graph.addEdge(town1, town2, Integer.parseInt(splitLine[1]), splitLine[0]);
			}
		}
		catch (NullPointerException | IllegalArgumentException e) 
		{
			e.printStackTrace();
		}
	}

}
