/*
 * Class: CMSC204
 * Description: This class implements a generic queue using an ArrayList as the underlying data structure.
 * The queue follows FIFO (First-In, First-Out) behavior, meaning elements are added to the end
 * and removed from the front.
 * The class supports basic queue operations such as enqueue, dequeue, checking if the queue
 * is empty or full, and converting the queue to a string.
 * Name: Griffin Shay
*/

import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T>
{
	private ArrayList<T> queue; // Stores the elements of the queue.
	private int max; // Maximum capacity of the queue.
	
	// Default constructor that creates a queue with a capacity of 50;
	public MyQueue()
	{
		max = 50;
		queue = new ArrayList<T>(max);
	}
	
	// Constructor that allows the user to set a custom queue capacity.
	public MyQueue(int size)
	{
		max = size;
		queue = new ArrayList<T>(max);
	}
	
	
	// Returns true if the queue is empty, otherwise false.
	@Override
	public boolean isEmpty()
	{
		return queue.isEmpty();
	}
	
	// Returns true if the queue is full, otherwise false.
	@Override
	public boolean isFull()
	{
		return queue.size() == max; 
	}
	
	
	// Removes and returns the element at the front of the queue.
	// Throws a QueueUnderflowException if the queue is empty.
	@Override
	public T dequeue() throws QueueUnderflowException
	{
		if(isEmpty())
		{
			throw new QueueUnderflowException();
		}
		else
		{
			T dequeueVar = queue.get(0);
			queue.remove(0);
			return dequeueVar;
		}
	}
	
	// Returns the current number of elements in the queue.
	@Override
	public int size()
	{
		return queue.size();
	}
	
	// Adds an element to the end of the queue.
	// Throws a QueueOverflowException if the queue is full.
	@Override
	public boolean enqueue(T e) throws QueueOverflowException
	{
		if(isFull())
		{
			throw new QueueOverflowException();
		}
		else
		{
			return queue.add(e);
		}
	}
	
	
	// Returns a string representation of the queue with no delimiter.
	// Elements are simply concatenated together.
	@Override
	public String toString()
	{
		String str = "";
		for(int i = 0; i < queue.size(); i++)
		{
			str += queue.get(i);
		}
		return str;
	}
	
	// Returns a string representation of the queue with a 
	// specified delimiter placed between elements.
	@Override
	public String toString(String delimiter)
	{
		String str = "";
		for(int i = 0; i < queue.size(); i++)
		{
			str += queue.get(i);
			if(i != queue.size() - 1)
			{
				str += delimiter;
			}
		}
		return str;
	}
	
	// Adds all elements from the given list into the queue.
	// A copy of the list is used to avoid modifying the original list.
	// Throws a QueueOverflowException if the queue exceeds its capacity.
	@Override
	public void fill(ArrayList<T> list) throws QueueOverflowException
	{
		ArrayList<T> listCopy = new ArrayList<T>(list);
		for(int i = 0; i < listCopy.size(); i++)
		{
			if(isFull())
			{
				throw new QueueOverflowException();
			}
			enqueue(listCopy.get(i));
		}
	}
}
