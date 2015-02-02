/*
Sort an array in wave form
Given an unsorted array of integers, sort the array into a wave like array. 
An array ‘arr[0..n-1]’ is sorted in wave form if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..
*/

public void sortInWave(int arr[], int n){
	for (int i = 0; i < n; i += 2){
		if (i > 0 && arr[i - 1] > arr[i])
			swap(arr[i - 1], arr[i]);
		if (i < n - 1 && arr[i] < arr[i + 1])
			swap(arr[i], arr[i + 1]);
	}
}

public void swap(int a, int b){
	int temp = a;
	a = b; 
	b = temp;
}