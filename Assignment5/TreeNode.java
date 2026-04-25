
/**
 * Class: CMSC204
 * Description: This class represents a node in a binary tree.
 * Each node stores data and references to a left and right child node.
 * @author Griffin Shay
 */

public class TreeNode<T> 
{ 
	protected T data;
	protected TreeNode<T> leftChild;
	protected TreeNode<T> rightChild;
	
	// Constructor that initializes the node with data.
	public TreeNode(T dataNode)
	{
		data = dataNode;
		leftChild = null;
		rightChild = null;
	}
	
	// Copy constructer that creates a new node from another node.
	public TreeNode(TreeNode<T> node)
	{
		this.data = node.data;
		this.leftChild = node.leftChild;
		this.rightChild = node.rightChild;
	}
	
	// Returns the data stored in the node.
	public T getData()
	{
		return this.data;
	}

}
