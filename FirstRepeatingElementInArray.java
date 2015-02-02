/*
Find the first repeating element in an array of integers
Given an array of integers, find the first repeating element in it. We need to find the element that occurs more than once and whose index of first occurrence is smallest.

Examples:

Input:  arr[] = {10, 5, 3, 4, 3, 5, 6}
Output: 5 [5 is the first element that repeats]

Input:  arr[] = {6, 10, 5, 4, 9, 120, 4, 6, 10}
Output: 6 [6 is the first element that repeats]
*/

public int firstRepeating(int arr[]){
	int min = -1;

	HashSet<Integer> set = new HashSet<Integer>();

	//count form the most right index to 0!!
	for (int i = arr.length - 1; i >= 0; i--){
		if (set.contains(arr[i]))
			min = i;
		else
			set.add(arr[i]);
	}
	if (min != -1)
		return arr[min];
	else
		return -1;
}