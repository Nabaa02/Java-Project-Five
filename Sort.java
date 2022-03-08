/**
 * @author Nabaa Khan
 * A class implementing various sorting methods 
 */
public class Sort{ 
  
  /** The integer array */
  private int[] array;
  
  /**
   * Sorts input array into descending order using insertionSort technique
   * @param array is the input array
   */
  public static void insertionSort(int[] array){
    //iterates through "unsorted section" of array starting from the first index (instead of the 0th)
    for(int i = 1; i < array.length; i++){
      //stores first element of unsorted section into variable "temp"
      int temp = array[i];
      //initializes j to start at end of "sorted section" of array
      int j = i - 1;
      //iterates as long as j is greater than or equal to 0 AND
      //as long as the current element of sorted section is less than the stored element from unsorted section
      while(j >= 0 && array[j] < temp){
        //shifts element of sorted section to the right
        array[j + 1] = array[j];
        //decrement j
        j--;
      }
      //inserts element from unsorted section
      array[j + 1] = temp;
    }
  }
  
  /**
   * Helper method for quickSort 
   * Swaps the ith and jth elements of input array
   * @param array is the input array
   * @param i is the ith element to be swapped of input array
   * @param j is the jth element to be swapped of input array
   */
  public static void swap(int[] array, int i, int j){
    //stores ith element to be swapped into variable "temp"
    int temp = array[i];
    //assigns jth element to index i
    array[i] = array[j];
    //assigns ith element (saved in "temp") to index j
    array[j] = temp;
  }
  
  /**
   * Helper method for quickSort
   * Splits the array into unsorted and sorted sections
   * @param array is the input array
   * @param lowerBound is the starting index from which user would like to partition the array
   * @param upperBound is the last index from which user would like to partition the array 
   * @return integer value representing the index at which partition method has completed
   */
  public static int partition(int[] array, int lowerBound, int upperBound){
    //assigns a pivot value, which serves as reference from which to split the array 
    int pivot = array[(lowerBound + upperBound) / 2];
    //initializes "start" to start from the lowerBound index
    int start = lowerBound;
    //initializes "end" to start from the upperBound index
    int end = upperBound;
    //iterates as long as start is less than end
    while(start < end){
      //iterates as long as the current element is greater than the pivot value
      while(array[start] > pivot){
        //increment start
        start++;
      }
      //iterates as long as the current element is less than the pivot value
      while(array[end] < pivot){
        //decrement end
        end--;
      }
      //if start is still less than end, swap the elements currently at the "start" and "end" indexes
      if(start < end){
        //call the "swap" helper method
        swap(array, start, end);
      }
      //otherwise, return the index at which "end" is currently at
      else{
        return end;
      }
    }
    //return the index at which "end" is currently at
    return end;
  }
  
  /**
   * Sorts input array into descending order using quickSort technique
   * @param array is the input array
   * @param lowerBound is the starting index from which user would like to sort the array 
   * @param upperBound is the last index from which user would like to sort the array 
   */
  public static void quickSort(int[] array, int lowerBound, int upperBound){
    //if lowerBound is less than upperBound, start sorting procedure
    if(lowerBound < upperBound){
      //stores the value returned from the partition method into variable "split"
      int split = partition(array, lowerBound, upperBound);
      //recursive call to quickSort method from the beginning of the array to the index before the split index 
      quickSort(array, lowerBound, split - 1);
      //recursive call to quickSort method from the index after the split index to the end of the array
      quickSort(array, split + 1, upperBound);
    }
  }
  
  /**
   * Helper method for mergeSort
   * Merges the sorted sublists into one list
   * @param array is the input array
   * @param lowerBound is the starting index from which user would like to merge the array
   * @param upperBound is the last index from which user would like to merge the array
   */
  public static void merge(int[] array, int lowerBound, int mid, int upperBound){
    //initializes i to start at the beginning of the array
    int i = lowerBound;
    //initializes j to start at index after mid index
    int j = mid + 1;
    //initializes k to start at the beginning of the array
    int k = lowerBound;
    //create a temporary array
    int[] tempArray = new int[array.length]; 
    //iterates as long as i is less than or equal to mid and j is less than or equal to the last index
    while(i <= mid && j <= upperBound){
      //if the element at i is greater than or equal to the element at j,
      if(array[i] >= array[j]){
        //insert element at i into temporary array
        tempArray[k] = array[i];
        //increment i
        i++;
      }
      //otherwise, if the element at i is less than the element at j,
      else{
        //insert element at j into temporary array
        tempArray[k] = array[j];
        //increment j
        j++;
      }
      //increment k
      //note: in either if-else case, we increment k, as we continue to add elements to the temporary array
      k++;
    }
    //if i is greater than mid, meaning if every element in first sublist (with i iterating through) has already been added to the temporary array, continue on
    if(i > mid){
      //iterate as long as j is less than or equal to the last index
      while(j <= upperBound){
        //insert remaining elements in second sublist into temporary array 
        tempArray[k] = array[j];
        //increment j
        j++;
        //increment k
        k++;
      }
    }
    //otherwise, if j is greater than last index, meaning if every element in second sublist (with j iterating through) has already been added to the temporary array, continue on
    else{
      //iterates as long as i is less than or equal to mid 
      while(i <= mid){
        //insert remaining elements in first sublist into temporary array
        tempArray[k] = array[i];
        //increment i
        i++;
        //increment k
        k++;
      }
    }
    //iterates through temporary array starting from beginning of that array
    for(k = lowerBound; k <= upperBound; k++){
      //copies everything from temporary array back into original array
      array[k] = tempArray[k];
    }
  }
  
  /**
   * Sorts input array into descending order using mergeSort technique
   * @param array is the input array
   * @param lowerBound is the starting index from which user would like to sort the array
   * @param upperBound is the last index from which user would like to sort the array
   */
  public static void mergeSort(int[] array, int lowerBound, int upperBound){
    //if lowerBound is less than upperBound, start sorting procedure
    if(lowerBound < upperBound){
      //stores middle value of array into variable "mid"
      int mid = (lowerBound + upperBound) / 2;
      //recursive call to mergeSort method from the beginning of the array to the mid index
      mergeSort(array, lowerBound, mid);
      //recursive call to mergeSort method from index after mid index to the end of the array
      mergeSort(array, mid + 1, upperBound);
      //call merge method to merge the sorted sublists into one sorted list
      merge(array, lowerBound, mid, upperBound);
    }
  }
  
  /** 
   * Returns kth largest integer in input array
   * @param array is the input array
   * @param k is the kth element to be returned
   * @return integer value representing the kth largest integer
   */
  public static int select(int[] array, int k){
    //call quickSort to sort the method first  
    insertionSort(array);
    //return the kth largest integer from sorted list
    return array[k];
  }
  
  /**
   * Sorts input array into descending order, taking into account the k value and the depth limit 
   * @param array is the input array
   * @param d is the depth limit
   * @param k is the number of elements in the array's subarrays
   * note: I wrote System.out.println after each call to make sure the method was sorting using the correct sorting method 
   */
  public static void upgradedQuickSort(int[] array, int d, int k){
    //if the array's length is less than k, call insertionSort 
    if(array.length < k){
      insertionSort(array);
      System.out.println("Used insertionSort");
    }
    //otherwise, if the array's length is greater than k, continue on
    else{
      //if the value from the partition helper method is less than the depth limit, call quickSort
      if(partition(array, 0, array.length - 1) < d){
        quickSort(array, 0, array.length - 1);
        System.out.println("Used quickSort");
      }
      //otherwise, call mergeSort
      else{
        mergeSort(array, 0, array.length - 1);
        System.out.println("Used mergeSort");
      }
    }
  }
  
  /**
   * Prints the array
   * @param array is the input array
   * @return String version of the array
   */
  public static String print(int[] array){
    //initialize the String and store it in variable "result"
    String result = "";
    //iterates through starting from beginning of the array
    for(int i = 0; i < array.length - 1; i++){
      //append each element at index i with a comma after it
      result += array[i] + ", ";
    }
    //iterates through array starting from the index before the last index
    //this is done so that there isn't an extra comma at the end 
    for(int i = array.length - 1; i < array.length; i++){
      //append last element  
      result += array[i];
    }
    //return the String version of the array
    return result;
  }
  
  /**
   * Main method to test all methods
   * @param array of String arguments
   */
  public static void main(String args[]){
    //TESTING INSERTION SORT
    //arrays to test method on
    int[] array1 = {3, 4, 5, 6, 7, 8, 9, 10};
    int[] array2 = {50, 44, 32, 28, 22, 17, 10, 8, 5, 2};
    int[] array3 = {5, 23, 30, 15, 12, 32, 45, 50, 11};
    System.out.println("INSERTION SORT");
    System.out.println("Before -- ascending order: " + print(array1));
    insertionSort(array1);
    System.out.println("After: " + print(array1));
    System.out.println("Before -- descending order: " + print(array2));
    insertionSort(array2);
    System.out.println("After: " + print(array2));
    System.out.println("Before -- random order: " + print(array3));
    insertionSort(array3);
    System.out.println("After: " + print(array3));
    //TESTING QUICK SORT
    //arrays to test method on
    int[] a1 = {3, 4, 5, 6, 7, 8, 9, 10};
    int[] a2 = {50, 44, 32, 28, 22, 17, 10, 8, 5, 2};
    int[] a3 = {5, 23, 30, 15, 12, 32, 45, 50, 11};
    System.out.println("QUICK SORT");
    System.out.println("Before -- ascending order: " + print(a1));
    quickSort(a1, 0, a1.length - 1);
    System.out.println("After: " + print(a1));
    System.out.println("Before -- descending order: " + print(a2));
    quickSort(a2, 0, a2.length - 1);
    System.out.println("After: " + print(a2));
    System.out.println("Before -- random order: " + print(a3));
    quickSort(a3, 0, a3.length - 1);
    System.out.println("After: " + print(a3));
    //TESTING MERGE SORT
    //arrays to test method on
    int[] arr1 = {3, 4, 5, 6, 7, 8, 9, 10};
    int[] arr2 = {50, 44, 32, 28, 22, 17, 10, 8, 5, 2};
    int[] arr3 = {5, 23, 30, 15, 12, 32, 45, 50, 11};
    System.out.println("MERGE SORT");
    System.out.println("Before -- ascending order: " + print(arr1));
    mergeSort(arr1, 0, arr1.length - 1);
    System.out.println("After: " + print(arr1));
    System.out.println("Before -- descending order: " + print(arr2));
    mergeSort(arr2, 0, arr2.length - 1);
    System.out.println("After: " + print(arr2));
    System.out.println("Before -- random order: " + print(arr3));
    mergeSort(arr3, 0, arr3.length - 1);
    System.out.println("After: " + print(arr3));
    //SELECT
    //arrays to test method on
    System.out.println("SELECT");
    System.out.println("Selecting k = 2 should return 8" + "\n" + "Answer: " + select(array1, 2)); 
    System.out.println("Selecting k = 5 should return 17" + "\n" + "Answer: " + select(array2, 5));
    System.out.println("Selecting k = 7 should return 11" + "\n" + "Answer: " + select(array3, 7));
    //UPGRADED QUICK SORT
    //arrays to test method on
    int[] ar1 = {3, 4, 5, 6, 7, 8, 9, 10};
    int[] ar2 = {50, 44, 32, 28, 22, 17, 10, 8, 5, 2};
    int[] ar3 = {5, 23, 30, 15, 12, 32, 45, 50, 11};
    System.out.println("UPGRADED QUICK SORT");
    System.out.println("Before -- ascending order: " + print(ar1));
    upgradedQuickSort(ar1, 10, 40);
    System.out.println("After: " + print(ar1));
    System.out.println("Before -- descending order: " + print(ar2));
    upgradedQuickSort(ar2, 10, 5);
    System.out.println("After: " + print(ar2));
    System.out.println("Before -- random order: " + print(ar3));
    upgradedQuickSort(ar3, 2, 5);
    System.out.println("After: " + print(ar3));
  }
} 
  
  