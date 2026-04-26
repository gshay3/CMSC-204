/**
 * Class: CMSC204
 * Description: Graph class representing a network of towns (vertices) and roads (edges).
 * Implements GraphInterface using an adjacency set approach.
 * Supports adding/removing vertices and edges, and finding shortest paths
 * using Dijkstra’s algorithm.
 * @author Griffin Shay
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road> 
{
	// Set of all the towns (vertices) in the graph.
	private Set<Town> towns = new HashSet<>();
	// Set of all the roads (edges) in the graph.
	private Set<Road> roads = new HashSet<>();
	// Stores shortest known distance from source to each town.
	private Map<Town, Integer> distances;
	// Stores previous town in shortest path.
	private Map<Town, Town> previous;
	
	// No argument constructor.
	public Graph()
	{
		
	}
	
	// Returns the road connecting source and destination, or null if none exists.
	@Override
	public Road getEdge(Town source, Town destination)
	{
		for(Road road : roads)
		{
			if(road.contains(source) && road.contains(destination))
			{
				return road;
			}
		}
		return null;
	}
	
	// Adds a road between two towns with a given distance and name.
	@Override
	public Road addEdge(Town source, Town destination, int distance, String name) throws NullPointerException, IllegalArgumentException
	{
		if(source == null || destination == null)
		{
			throw new NullPointerException();
		}
		if(!containsVertex(source) || !containsVertex(destination))
		{
			throw new IllegalArgumentException();
		}
		Road road = new Road(source, destination, distance, name);
		roads.add(road);
		return road;
	}
	
	// Adds a town to the graph.
	@Override
	public boolean addVertex(Town town) throws NullPointerException
	{
		if(town == null)
		{
			throw new NullPointerException();
		}
		if(towns.contains(town))
		{
			return false;
		}
		towns.add(town);
		return true;
	}
	
	// Checks if a road exists between two towns.
	@Override
	public boolean containsEdge(Town source, Town destination)
	{
		for(Road r: roads)
		{
			if(r.contains(source) && r.contains(destination))
			{
				return true;
			}
		}
		return false;
	}
	
	// Check if a town exists in the graph.
	@Override
	public boolean containsVertex(Town town)
	{
		return towns.contains(town);
	}
	
	// Return all roads in the graph.
	@Override
	public Set<Road> edgeSet()
	{
		return roads;
	}
	
	// Return all roads connected to a specific town.
	@Override
	public Set<Road> edgesOf(Town town)
	{
		Set<Road> townRoads = new HashSet<>();
		for(Road road : roads)
		{
			if(road.contains(town))
			{
				townRoads.add(road);
			}
		}
		return townRoads;
	}
	
	// Removes a specific road based on endpoints, distance, and name.
	@Override
	public Road removeEdge(Town source, Town destination, int distance, String name)
	{
		Road removedRoad = new Road(source, destination, distance, name);
		Iterator<Road> iterator = roads.iterator();
		while(iterator.hasNext())
		{
			Road road = iterator.next();
			if(road.contains(source) && road.contains(destination) &&
					road.getDistance() == distance && road.getName().equals(name))
			{
				iterator.remove();
				removedRoad = road;
				break;
			}
		}
		return removedRoad;
	}
	
	// Removes a town and all associated roads.
	@Override
	public boolean removeVertex(Town town)
	{
		if(town == null)
		{
			return false;
		}
		else
		{
			roads.removeIf(road -> road.contains(town));
			towns.remove(town);
			return true;
		}
	}
	
	// Returns all towns in the graph.
	@Override
	public Set<Town> vertexSet()
	{
		return towns;
	}
	
	// Returns the shortest path from source to destination as a list of strings.
	@Override
	public ArrayList<String> shortestPath(Town source, Town destination)
	{
	    ArrayList<String> path = new ArrayList<>();
	    
	    // Run Dijkstra's algorithm.
	    dijkstraShortestPath(source);

	    // If destination has no predecessor no path exists.
	    if (previous.get(destination) == null)
	    {
	        return path;
	    }

	    // Reconstruct path from destination to source.
	    ArrayList<Town> reversePath = new ArrayList<>();
	    Town current = destination;

	    while (current != null)
	    {
	        reversePath.add(0, current);
	        current = previous.get(current);
	    }

	    // Build output strings
	    for (int i = 0; i < reversePath.size() - 1; i++)
	    {
	        Town from = reversePath.get(i);
	        Town to = reversePath.get(i + 1);

	        Road road = getEdge(from, to);

	        path.add(from.getName() + " via " + road.getName() +
	                 " to " + to.getName() + " " + road.getDistance() + " mi");
	    }

	    return path;
	}
	
	// Implements Dijkstra's algorithm to compute shortest path from source.
	@Override
	public void dijkstraShortestPath(Town source) 
	{
	    distances = new HashMap<>();
	    previous = new HashMap<>();

	    // Initialize distances
	    for (Town town : towns)
	    {
	        distances.put(town, Integer.MAX_VALUE);
	        previous.put(town, null);
	    }

	    distances.put(source, 0);

	    // Priority queue orders towns by current shortest distance.
	    PriorityQueue<Town> pq = new PriorityQueue<>(
	        Comparator.comparingInt(distances::get)
	    );
	    pq.add(source);

	    // Main loop of Dijkstra's algorithm.
	    while (!pq.isEmpty())
	    {
	        Town current = pq.poll();

	        for (Road road : edgesOf(current))
	        {
	            Town neighbor = road.getSource().equals(current)
	                    ? road.getDestination()
	                    : road.getSource();

	            int newDist = distances.get(current) + road.getDistance();

	            if (newDist < distances.get(neighbor))
	            {
	                distances.put(neighbor, newDist);
	                previous.put(neighbor, current);
	                pq.add(neighbor);
	            }
	        }
	    }
	}


}
