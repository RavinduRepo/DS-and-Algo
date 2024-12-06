/**
 * Simple sorting algorithms and their performance 
 * Reg: E/20/280
 *
 */

 public class E20280_CO322_Lab01_Sort {

    //create an array of given size and populate it with random data  
    static int [] create_rand_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = (int)(Math.random() * 100);
	return data; 
    }

    //create an array of given size and populate it with worst data arrangement 
    static int [] create_worst_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = data.length - i;
	return data; 
    }

    //create an array of given size and populate it with best data arrangement 
    static int [] create_best_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = i;
	return data; 
    }

    // function to swap. Would be useful since all need this 
    static void swap(int []d, int i, int j) { 
	int tmp = d[i]; 
	d[i] = d[j]; 
	d[j] = tmp;
    }

    // check if the soring worked on the array 
    static boolean isSorted(int [] data) {
	int i;
	for(i=1; i < data.length; i++)
	    if(data[i] < data[i-1]) break;
	return (i == data.length);
    }

    // If you want just display the array as well :) 
    static void display(int []data) { 
		System.out.println("=======");
		for(int i=0; i < data.length; i++) 
			System.out.print(data[i] + "  "); 
		System.out.println("\n=======");
    }

    
    /**********************************************************
     *     Implementation of sorting algorithms               *
     *********************************************************/

    static void bubble_sort(int [] data)  {
		int n = data.length;
		for (int i = 0; i < n - 1; i++){
			for (int j = 0; j < n - i - 1; j++){
				if (data[j] > data[j + 1]) {
					// swap items (j, j+1)
					swap(data, j, j+1);
				}
			}
		}
    }

    static void selection_sort(int [] data) {
		
	}

    static void insertion_sort(int [] data) {
	// Implement
    }

		       
		

    public static void main(String [] args) {

		// get all three types of data samples
		int[] best_data = create_best_data(20);
		System.out.println("best_data");
		display(best_data);

		int[] rand_data = create_rand_data(20);
		System.out.println("rand_data");
		display(rand_data);

		int[] worst_data = create_worst_data(20);
		System.out.println("worst_data");
		display(worst_data);

		// Run algorithems

		// best data
		long startTime = System.nanoTime(); // Start measuring time
        bubble_sort(best_data);
        long endTime = System.nanoTime();   // end measuring time

        System.out.println("\nSorted array:");
        display(best_data);

        long duration = endTime - startTime; // calculate the duration in nanoseconds
        System.out.println("\nbest_data Execution Time: " + duration + " nanoseconds");
		if (isSorted(best_data)) {
			System.out.println("Sorted!!!");
		}


		// rand data
		startTime = System.nanoTime(); // Start measuring time
        bubble_sort(rand_data);
        endTime = System.nanoTime();   // end measuring time

        System.out.println("\nSorted array:");
        display(rand_data);

        duration = endTime - startTime; //calculate the duration in nanoseconds
        System.out.println("\nrand_data Execution Time: " + duration + " nanoseconds");
		if (isSorted(rand_data)) {
			System.out.println("Sorted!!!");
		}


		// worst data
		startTime = System.nanoTime(); // Start measuring time
        bubble_sort(worst_data);
        endTime = System.nanoTime();   //end measuring time

        System.out.println("\nSorted array:");
        display(worst_data);

        duration = endTime - startTime; //calculate the duration in nanoseconds
        System.out.println("\nworst_data Execution Time: " + duration + " nanoseconds");
		if (isSorted(worst_data)) {
			System.out.println("Sorted!!!");
		}

	// create arrays of different size populate with data
	// measure the time taken by different algorithms to
	// sort the array.
	// Think about effects of caches, other apps running etc. 
    }
}