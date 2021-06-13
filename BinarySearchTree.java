
import java.util.Iterator;
import java.util.LinkedList;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>
{
  private static class Node<AnyType>
  {
    private AnyType data;
    private Node<AnyType> left;
    private Node<AnyType> right;

    public Node(AnyType d, Node<AnyType> l, Node<AnyType> r)
    {
      setData(d);
      setLeft(l);
      setRight(r);
    }

    public AnyType getData() { return data; }
    public Node<AnyType> getLeft() { return left; }
    public Node<AnyType> getRight() { return right; }

    public void setData(AnyType d) { data = d; }
    public void setLeft(Node<AnyType> l) { left = l; }
    public void setRight(Node<AnyType> r) { right = r; }
  }

  private Node<AnyType> root;
  int count=10;                               //use to create space while processing the print tree command 
  
  public BinarySearchTree() { makeEmpty(); }

  public void makeEmpty() { root = null; } 

  public boolean isEmpty() { return (root == null); }

  public boolean contains(AnyType v) { return contains(v, root); }

  private boolean contains(AnyType v, Node<AnyType> t)
  {
    if (t == null) return false;

    int compareResult = v.compareTo(t.getData());

    if (compareResult < 0)
      return contains(v, t.getLeft());
    else
      if (compareResult > 0)
        return contains(v, t.getRight());
      else
        return true;
  }

  public AnyType findMin() throws IllegalStateException
  {
    if (isEmpty()) throw new IllegalStateException("Search Tree is empty.");

    Node<AnyType> minNode = findMin(root);
    return minNode.getData();
  }

  private Node<AnyType> findMin(Node<AnyType> t)
  {
    if (t == null)
      return null;
    else
      if (t.getLeft() == null)
        return t;

    return findMin(t.getLeft());
  }

  public AnyType findMax() throws IllegalStateException
  {
    if (isEmpty()) throw new IllegalStateException("Search Tree is empty.");

    Node<AnyType> maxNode = findMax(root);
    return maxNode.getData();
  }

  private Node<AnyType> findMax(Node<AnyType> t)
  {
    if (t == null)
      return null;
    else
      if (t.getRight() == null)
        return t;

    return findMax(t.getRight());
  }

  public void insert(AnyType v)
  {
	  root = insert( v, root );                                        // Write the iterative version of the insert method here.


  }
  private Node<AnyType> insert( AnyType x, Node<AnyType> t )
   {
   if( t == null )
   return new Node<>( x, null, null );                  //insert the values under the rules
  
  int compareResult = x.compareTo( t.getData() );
  
   if( compareResult < 0 )
     t.left = insert( x, t.left );
   else if( compareResult > 0 )
     t.right = insert( x, t.right );
   else;                                              // Duplicate; do nothing
     return t;
   }
  public void remove(AnyType v)
  {
	  root = remove( v, root );                            // Write the iterative version of the remove method here.


  }
  private Node<AnyType> remove(AnyType v, Node<AnyType> t)
  {
    if (t == null) return t;

    int compareResult = v.compareTo(t.getData());

    if (compareResult < 0)
      t.setLeft(remove(v, t.getLeft()));
    else
      if (compareResult > 0)
        t.setRight(remove(v, t.getRight()));
   else if( t.left != null && t.right != null )                          // Two children
   {
	   Node<AnyType> minNodeRightSubtree = findMin(t.getRight());               // find the minimum value in right subtree and replace the old value
       AnyType minNodeRightSubtreeValue = minNodeRightSubtree.getData();
       t.setData(minNodeRightSubtreeValue);
       t.setRight(remove(minNodeRightSubtreeValue, t.getRight()));
   }
   else
       t = ( t.left != null ) ? t.left : t.right;                           //if compareResult=0 either left or right child replace the parent
   return t;
   }
  
  
  
  public void printTree()
  {
	  if( isEmpty( ) )                                               // Write the code to print out the values in the tree
		  System.out.println( "Empty tree" );                       // in a tree like form as described in the assignment
	  else                                                        // description.
		  printTree( root,0 );

  }

  private void printTree( Node<AnyType> t,int space )
   {
  if( t != null )
  {
	 
	// Increase distance between levels
	    space += count;
	 
	    // Process right child first
	    printTree(t.getRight(), space);
	 
	    // Print current node after space
	    // count
	    System.out.print("\n");
	    for (int i = count; i < space; i++)
	        System.out.print(" ");
	    System.out.print(t.getData()+"\n");
	 
	    // Process left child
	    printTree(t.getLeft(), space);
   }
  }
  
  public void list() {
	  System.out.println("Values in increasing order: ");
	 list(root);
  }
  
  private void list(Node<AnyType> t) {           //print the values in increasing order(in order traversal)
	  if( t != null )
	   {
	  list( t.getLeft() );
	  System.out.print( t.getData()+" " );
	  list( t.getRight() );
	   }
  }
  
  public Iterator<AnyType> iterator()
  {
    LinkedList<AnyType> snapshot = new LinkedList<>();

    inOrderTraversal(root, snapshot);
    return snapshot.iterator();
  }

  private void inOrderTraversal(Node<AnyType> t, LinkedList<AnyType> l)
  {
    if (t != null)
    {
      inOrderTraversal(t.getLeft(), l);
      l.add(t.getData());
      inOrderTraversal(t.getRight(), l);
    }
  }
}