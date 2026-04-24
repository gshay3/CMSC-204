/*
 * Class: CMSC204
 * Description: This class implements a generic stack using an ArrayList as the underlying structure.
 * The stack follows LIFO (Last-In, First-Out) behavior, meaning the last element added
 * is the first one removed.
 * It provides standard stack operations such as push, pop, top, and checks for
 * whether the stack is empty or full.
 * Name: Griffin Shay
*/

import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T> 
{
	private ArrayList<T> stack; // Stores stack elements.
	private int max; // Maximum capacity of stack.
	
	// Default constructor that creates a stack with a capacity of 50.
	public MyStack()
	{
		max = 50;
		stack = new ArrayList<T>(max);
	}
	
	// Constructor that allows for a custom stack size.
	public MyStack(int size)
	{
		max = size;
		stack = new ArrayList<T>(max);
	}
	
	// Returns true if the stack is empty.
	@Override
	public boolean isEmpty()
	{
		return stack.isEmpty();
	}
	
	// Returns true if the stack is full.
	@Override
	public boolean isFull()
	{
		return stack.size() == max;
	}
	
	// Removes and returns the top element of the stack.
	// Throws a StackUnderflowException if the stack is empty.
	@Override
	public T pop() throws StackUnderflowException
	{
		if(isEmpty())
		{
			throw new StackUnderflowException();
		}
		else
		{
			T poppedVar = stack.get(size() - 1);
			stack.remove(size() - 1);
			return poppedVar;
		}
	}
	
	// Returns the top element of the stack without removing it.
	// Throws a StackUnderflowException if the stack is empty.
	@Override
	public T top() throws StackUnderflowException
	{
		if(isEmpty())
		{
			throw new StackUnderflowException();
		}
		else
		{
			return stack.get(size() - 1);
		}
	}
	
	
	// Returns the current number of elements in the stack.
	@Override
	public int size()
	{
		return stack.size();
	}
	
	// Adds an element to the top of the stack.
	// Throws a StackOverflowException if the stack is full.
	@Override
	public boolean push(T e) throws StackOverflowException
	{
		if(isFull())
		{
			throw new StackOverflowException();
		}
		else
		{
			return stack.add(e);
		}
	}
	
	// Returns a string representation of the stack with no delimiter.
	// Elements are concatenated in order from bottom to top.
	@Override
	public String toString()
	{
		String str = "";
		for(int i = 0; i < stack.size(); i++)
		{
			str += stack.get(i);
		}
		return str;
	}
	
	// Returns a string representation of the stack with a
	// specified delimiter between each element.
	@Override
	public String toString(String delimiter)
	{
		String str = "";
		for(int i = 0; i < stack.size(); i++)
		{
			str += stack.get(i);
			if(i != stack.size() - 1)
			{
				str += delimiter;
			}
		}
		return str;
	}
	
	// Adds all elements from the given list into the stack.
	// A copy of the list is used so the original list is not modified.
	// Throws a StackOverflowException if the stack exceeds capacity.
	@Override
	public void fill(ArrayList<T> list) throws StackOverflowException
	{
		ArrayList<T> listCopy = new ArrayList<T>(list);
		for(int i = 0; i < listCopy.size(); i++)
		{
			if(isFull())
			{
				throw new StackOverflowException();
			}
			push(listCopy.get(i));
		}
	}
}
