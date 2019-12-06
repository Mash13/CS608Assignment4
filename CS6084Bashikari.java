import java.io.File;
import java.util.Scanner;

public class CS6084Bashikari {
	
	static int blobCount = 0;
	
	public static char[][] blobCheck(char[][] list, int row, int column) {
         			 
         			list[row][column] = 'y';      			
         			 
         			//to the right of found blob
         			if (column != 24) {
         			 
         				if (list[row][column + 1] == 'b') {
         		      	
         					list = blobCheck(list, row, column + 1);
       	      	
       	      			}
         			
         			}
         			
         			//down
	      			if (row != 24) {
	         			
	      				if (list[row + 1][column] == 'b') {
         		      	
       	      			list = blobCheck(list, row + 1, column);
       	      	
       	      			}
         			
	      			}
         			
	      			//down right
	      			if (row != 24 && column != 24) {
	         			
	      				if (list[row + 1][column + 1] == 'b') {
         		      	
         					list = blobCheck(list, row + 1, column + 1);
       	      	
       	      			}
         			
	      			}
         			
	      			//down left
	      			if (row != 24 && column != 0) {
         			
	      				if (list[row + 1][column - 1] == 'b') {
         		      	
         					list = blobCheck(list, row + 1, column - 1);
       	      	
	      				}
       	      		
	      			}
	      			
	      			//up right
	      			if (row != 0 && column != 24) {
	         			
	      				if (list[row - 1][column + 1] == 'b') {
         		      	
         					list = blobCheck(list, row - 1, column + 1);
       	      	
	      				}
       	      		
	      			}
	      			
	      			//up
	      			if (row != 0) {
	         			
	      				if (list[row - 1][column] == 'b') {
         		      	
         					list = blobCheck(list, row - 1, column);
       	      	
	      				}
       	      		
	      			}
	      			
	      			//up left
	      			if (row != 0 && column != 0) {
	         			
	      				if (list[row - 1][column - 1] == 'b') {
         		      	
         					list = blobCheck(list, row - 1, column - 1);
       	      	
	      				}
       	      		
	      			}
	      			
	      			//left
	      			if (column != 0) {
	         			
	      				if (list[row][column - 1] == 'b') {
         		      	
         					list = blobCheck(list, row, column - 1);
       	      	
	      				}
       	      		
	      			}
        
        return list;
		
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(new File("blob.txt"));
		
		int row = 0;
		int column = 0;
		int bCount = 0;
				
	    char[][] list = new char[25][25];
	    
	    char[] c2 = new char[25];
	        
	      while(in.hasNextLine()) {
	        	  
	             String c = in.nextLine();
	             
	             c2 = c.toCharArray();
	             
	             for (int i = 0; i < c2.length; i++) {
	            	 
	            	 if (c2[i] == 'b') {
	            		 
	            		 bCount++;
	            		 
	            	 }
	            	 
	             }
	             
	             for (column = 0; column < c2.length; column++) {
	            	 
	            	 list[row][column] = c2[column];
	            	 
	             }
	            	 
	             row++;
	          
	       }		      
	      
	      for (row = 0; row < c2.length; row++) {
	         	 
	         	 for (column = 0; column < c2.length; column++) {
	      
	         		if(list[row][column] == 'b') {
	         		 
	         			
	         			blobCount++;
	         			 list = blobCheck(list, row, column);
	         			//blobCount++;
	         			 
	         			 
	         		 }
	         		 
	         	 }
	         	 
	      }
	 	  
	      System.out.println("The number of blob's in this text file is " + blobCount);
	      System.out.println("The number of b's in this text file is " + bCount);
	      
	       in.close();
	        
	}
}