# Java-Project-Five
In this program, we are instructed to create a class called Sort that implements various sorting methods: mergeSort, quickSort, insertionSort, upgradedQuickSort (an upgraded version of the quickSort method), and select.

# Sort Class - Methods
- void mergeSort(int input): Takes an input array of integers. Uses the merge sort algorithm to sort the input array into descending order.

- void quickSort(int input): Takes an input array of integers. Uses the quick sort algorithm to sort the input array into descending order. 

- void insertionSort(int input): Takes an input array of integers. Uses the insertion sort algorithm to sort the input array into descending order. 

- void upgradedQuickSort(int input, int d, int k): Takes an input array of integers. Uses an upgraded version of quick sort to sort the input array into descending order, where we switch to merge sort when it reaches the depth limit d and switch to insertion sort when the subarrays have fewer than k elements.

- int select(int input, int k): Takes an input array of integers. Returns the kth largest integer in the array in average O(n) time. The algorithm is allowed to reorder array elements. Example: [2, 7, -1, 5, 6, 4]. Selecting k = 0 should return 7, the largest element. Selecting k = 2 should return 5.
