import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Assignment2 {
	public static void main(String args[]) throws IOException {
		BinarySearchTree bs=new BinarySearchTree();
		BufferedReader br = new BufferedReader(new FileReader(new File("assignment2.txt")));  //use BufferedReader to read data line by line

		   String content;
		   String[] tokens;
		   while((content=br.readLine())!=null){              //keep reading line by line until reach the bottom
			   tokens=content.split(" ");                    //use Tokens to separate white space in order to push data 
	                   switch(tokens[0]) {                   //use switch method for choosing the correct command to operate
	                   
	                   case "insert" : bs.insert(tokens[1]); break;   //insert values in binary search tree
	                   
	                   case"remove" : bs.remove(tokens[1]); break;    //remove values 
	                   
	                   case"print_tree": bs.printTree();  break;       //print binary search in 2d
                 
	                   case"inorder_list": bs.list();   break;    //print the values in increasing order
	                   
	                   default:  System.out.println("Wrong command");               //default value for the invalid command
                
                }
            }
		
	}

}
