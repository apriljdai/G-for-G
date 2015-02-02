/*
Find the closest pair from two sorted arrays
Given two sorted arrays and a number x, find the pair whose sum is closest to x and the pair has an element from each array.
We are given two arrays ar1[0…m-1] and ar2[0..n-1] and a number x, we need to find the pair ar1[i] + ar2[j] such that absolute value of (ar1[i] + ar2[j] – x) is minimum.
*/

public void printClosest(int ar1[], int ar2[], int m, int n, int x){
	int diff = Integer.MAX_VALUE;

	int ind1, ind2;
	int left = 0, right = n - 1;
	while (left < m && right >= 0){
		int temp = Math.abs(ar1[left] + ar2[right] - x;
		if (temp < diff){
			diff = temp;
			ind1 = left;
			ind2 = right;
		}

		if (ar1[left] + ar2[right] > x)
			right--;
		else
			left++;
	}
}