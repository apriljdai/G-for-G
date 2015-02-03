/*
Duplicate elements question
1) A sorted array of length z contains integer values in the range of 1 to z-1. 
Assume that there is exactly one duplicate value. Write a function that finds the duplicate value in constant memory.
*/


//method 1: Keep a sum variable and run through the array, adding each element. Also keep a sum2 variable which contains the sum of 1 to z-1
public int findDuplicate(int[] arr){
	int sum1 = 0;
	int n = arr.length - 1;
	int sum2 = (1 + n) * n / 2;
	for (int a: arr){
		sum1 += a;
	}
	int res = sum1 - sum2;
	return res;
}
//runtime: O(Z)

//method 2: binary search, taking into account the difference of the index and the index's value.
public int findDuplicate(int[] arr){
	int left = 0, right = arr.length - 1;

	while (left <= right){	
		int mid = left + (right - left) / 2;

		if (arr[mid] == arr[mid + 1] || arr[mid] == arr[mid - 1])
			return arr[mid];

		if (arr[mid] = mid + 1)
			return findDuplicate(arr, mid + 1, right);
		else
			return findDuplicate(arr, left, mid);
	}
	return arr[left];
}
//runtime: O(logZ)

/*
3) now the array can have multiple duplicates and you can use as much memory as you want. You only need to find one duplicate.
*/

public int findDuplicate(int[] arr){
	HashSet<Integer> set = new HashSet<Integer>();

	for (int a: arr){
		if (set.contains(a))
			return a;
		set.add(a);
	}
	return -1;
}
//runtime: O(Z)

/*
4) Given a sorted array and a value in the array, how to tell if the element has duplicates?
*/

public boolean haveDuplicate(int[] arr, int n){
	if (n > arr[arr.length - 1] || n < arr[0])
		throw new IllegalArgumentException("The number is not in the array!");
	
	int left = 0, right = arr.length - 1;
	while (left <= right){
		int mid = left + (right - left) / 2;

		if ((arr[mid] == n && arr[mid + 1] == n) || (arr[mid] == n && arr[mid - 1] == n))
			return true;
		if ((arr[mid] == n && arr[mid + 1] != n) || (arr[mid] == n && arr[mid - 1] != n))
			return false;
		if (arr[mid] < n)
			left = mid + 1;
		else
			right = mid - 1;
	}
	return -1;
}
//runtime: O(logZ)

/*
5) Back to original question (Array of length z with elements ranging from 1 to z-1, with at least one duplicate and possibly multiple.) 
Can you find a duplicate in linear time with a constant memory constraint? (There has to be at least one duplicate by the pigeon-hole principle.)
*/


