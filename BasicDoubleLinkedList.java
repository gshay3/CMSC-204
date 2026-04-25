/*
 * Class: CMSC204
 * Description: This class implements a doubly linked list.
 * Each node stores data along with references to both the next
 * and previous nodes, allowing traversal in both directions.
 * It supports adding/removing elements, retrieving values,
 * and iterating through the list.
 * Name: Griffin Shay
*/

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Comparator;

public class BasicDoubleLinkedList<T> implements Iterable<T> 
{
	protected int size;
	protected Node head;
	protected Node tail;
	
	// Constructor that initializes an empty list.
	public BasicDoubleLinkedList()
	{
		size = 0;
		head = null;
		tail = null;
	}
	
	// Returns the current size of the list.
	public int getSize()
	{
		return size;
	}
	
	// Adds an element to the end of the list.
	public void addToEnd(T data)
	{
		Node node = new Node(data);
        if (tail != null) 
        {
            node.previous = tail;
            tail.next = node;
        } 
        else 
        {
            head = node;
        }
        tail = node;
        size++;
	}
	
	// Adds an element to the front of the list.
	public void addToFront(T data)
	{
		Node node = new Node(data);
		if(head != null)
		{
			node.next = head;
			head.previous = node;
		}
		else
		{
			tail = node;
		}
		head = node;
		size++;
	}
	
	// Returns the first element, or null if its empty.
	public T getFirst()
	{
		if(head == null)
		{
			return null;
		}
		else
		{
			return head.data;
		}
	}
	
	// Returns the last element, or null if its empty.
	public T getLast()
	{
		return tail.data;
	}
	
	// Returns an iterator for traversing the list.
	@Override
	public ListIterator<T> iterator()
	{
		return new DoubleLinkedListIterator();
	}
	
	// Removes the first occurrence of the specified data using a comparator.
	public Node remove(T targetData, Comparator<T> comparator)
	{
		Node node = head;
		
		while(node != null)
		{
			if(comparator.compare(node.data, targetData) == 0)
			{
				if(node.previous == null)
				{
					head = node.next;
					if(head != null)
					{
						head.previous = null;
					}
				}
				else if(node.next == null)
				{
					tail = node.previous;
					if(tail != null)
					{
						tail.next = null;
					}
				}
				else
				{
					node.previous.next = node.next;
					node.next.previous = node.previous;
				}
				size--;
				return node;
			}
			node = node.next;
		}
		return null;
	}
	
	// Removes and returns the first element in the list.
	public T retrieveFirstElement()
	{
		if(head == null)
		{
			return null;
		}
		else
		{
			Node node = head;
			head = head.next;
			head.previous = null;
			size--;
			return node.data;
		}
	}
	
	// Removes and returns the last element in the list.
	public T retrieveLastElement()
	{
		if(tail == null)
		{
			return null;
		}
		else
		{
			Node node = tail;
			tail = tail.previous;
			tail.previous = null;
			size--;
			return node.data;
		}
	}
	
	// Converts the list into an ArrayList and returns it.
	public ArrayList<T> toArrayList()
	{
		ArrayList<T> list = new ArrayList<>();
		Node node = head;
		for(int i = 0; i < size; i++)
		{
			list.add(node.data);
			node = node.next;
		}
		return list;
	}
	
	// Inner class representing a node in the doubly linked list.
	// Each node stores data and a reference to next and previous nodes.
	protected class Node
	{
		protected T data;
		protected Node next;
		protected Node previous;
		
		public Node(T data)
		{
			this.data = data;
			this.next = null;
			this.previous = null;
		}
	}
	
	// Inner Iterator class for traversing the list in both directions.
	// Supports next() and previous() operations.
	protected class DoubleLinkedListIterator implements ListIterator<T>
	{
		protected Node node = head;
		protected Node temp ;
		

		@Override
		public boolean hasNext() 
		{
			if(node == null)
			{
				return false;
			}
			else
			{
				return true;
			}
		}

		@Override
		public T next() 
		{
			if(hasNext())
			{
				temp = node;
				node = node.next;
				return temp.data;
			}
			throw new NoSuchElementException();
		}

		@Override
		public boolean hasPrevious() 
		{
			if(temp == null)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		
		@Override
		public T previous() 
		{
			if(hasPrevious())
			{
				node = temp;
				temp = temp.previous;
				return node.data;
			}
			throw new NoSuchElementException();
		}

		@Override
		public int nextIndex() 
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() 
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() 
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T e) 
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T e) 
		{
			throw new UnsupportedOperationException();
		}
	}

}
