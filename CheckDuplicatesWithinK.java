/*
Check if a given array contains duplicate elements within k distance from each other
Given an unsorted array that may contain duplicates. 
Also given a number k which is smaller than size of array. Write a function that returns true if array contains duplicates within k distance.
*/

public boolean checkDuplicatesWithinK(int[] arr, int k){
	HashSet<Integer> set = new HashSet<Integer>();

	for (int i = 0; i < arr.length; i++){
		if (set.contains(arr[i]))
			return true;

		set.add(arr[i]);

		//remove the k+1 distant item
		if (i >= k)
			set.remove(arr[i - k]);
	}
	return false;
}