/**
 * Class: CMSC204
 * Description: Builds and manages a Morse code binary tree where
 * dots (.) go left and dashes (-) go right. Allows inserting,
 * retrieving, and traversing Morse code translations.
 * @author Griffin Shay
 */

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>
{
	private TreeNode<String> root = new TreeNode<>("");
	
	// Constructor that builds the MorseCodeTree.
	public MorseCodeTree()
	{
		buildTree();
	}
	
	// Returns the root node of the MorseCodeTree.
	public TreeNode<String> getRoot()
	{
		return root;
	}
	
	// Sets the root node of the MorseCodeTree.
	public void setRoot(TreeNode<String> newNode)
	{
		root = newNode;
	}
	
	// Inserts a letter into the tree using its Morse code.
	public void insert(String code, String letter)
	{
		addNode(root, code, letter);
	}
	
	// Recursively adds a node based on '.' (left) and '-' (right).
	public void addNode(TreeNode<String> root, String code, String letter)
	{
		if(code.length() == 1)
		{
			if(code.charAt(0) == '.')
			{
				root.leftChild = new TreeNode<String>(letter);
			}
			else if(code.charAt(0) == '-')
			{
				root.rightChild = new TreeNode<String>(letter);
			}
		}
		else
		{
			if(!(code.isEmpty()) && code.charAt(0) == '.')
			{
				addNode(root.leftChild, code.substring(1), letter);
			}
			else if(!(code.isEmpty()) && code.charAt(0) == '-')
			{
				addNode(root.rightChild, code.substring(1), letter);
			}
		}
	}
	
	// Returns the letter corresponding to a Morse code string.
	public String fetch(String code)
	{
		return fetchNode(root, code);
	}
	
	// Recursively navigates the tree to find the correct letter.
	public String fetchNode(TreeNode<String> root, String code)
	{
		if(code.length() == 1)
		{
			if(code.charAt(0) == '.')
			{
				return root.leftChild.data;
			}
			else if(code.charAt(0) == '-')
			{
				return root.rightChild.data;
			}
		}
		else
		{
			if(!(code.isEmpty()) && code.charAt(0) == '.')
			{
				return fetchNode(root.leftChild, code.substring(1));
			}
			else if(!(code.isEmpty()) && code.charAt(0) == '-')
			{
				return fetchNode(root.rightChild, code.substring(1));
			}
		}
		return null;
	}
	
	// Not supported for this tree.
	public MorseCodeTree delete(String data) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
	
	// Not supported for this tree.
	public MorseCodeTree update() throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
	
	//Builds the full MorseCodeTree by inserting all the letters.
	public void buildTree()
	{	
		insert("", "");
		
		insert(".", "e");
		insert("-", "t");
		
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
		
	}
	
	// Returns an ArrayList of all elements using inorder travel.
	public ArrayList<String> toArrayList()
	{
		ArrayList<String> list = new ArrayList<>();
		LNRoutputTraversal(root, list);
		return list;
	}
	
	// Performs inorder traversal of the tree and populates the ArrayList
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list)
	{
		if(root != null)
		{
			if(root.leftChild != null)
			{
				LNRoutputTraversal(root.leftChild, list);
			}
			list.add(root.data);
			if(root.rightChild != null)
			{
				LNRoutputTraversal(root.rightChild, list);
			}
		}
	}

}
