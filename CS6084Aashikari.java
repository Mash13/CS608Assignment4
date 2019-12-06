import java.io.*;
import java.util.*;

public class CS6084Aashikari {
	
	static int partition(int arr[], int low, int high) { 
		
		int pivot = arr[high];  
		int i = (low-1); 
		
		for (int j=low; j<high; j++) { 

			if (arr[j] <= pivot) { 
				
				i++; 

				int temp = arr[i]; 
				
				arr[i] = arr[j]; 
				arr[j] = temp; 
				
			} 
		} 

		int temp = arr[i+1]; 
		
		arr[i+1] = arr[high]; 
		arr[high] = temp; 

		return i+1; 
	} 

	static void sort(int arr[], int low, int high) { 
		
		if (low < high) { 

			int pi = partition(arr, low, high); 

			sort(arr, low, pi-1); 
			sort(arr, pi+1, high); 
			
		} 
	} 

	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(new File("inputData4A.txt"));
	    int[] list = new int[100];

	        for (int i = 0; i < list.length; i++){
	        		list[i] = in.nextInt();
	        }	        

	        partition(list, 0, 99);
	        sort(list, 0, 99);
	        
	        //Arrays.sort(list);
	        
	        System.out.println(list[10]);
	        System.out.println(list[25]);
	        System.out.println(list[50]);
	        System.out.println(list[70]);
	        System.out.println(list[90]);
		    
	        in.close();
	    
	} 
}