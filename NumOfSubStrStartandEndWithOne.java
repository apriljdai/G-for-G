/*
Given a binary string, count number of substrings that start and end with 1.
For example, if the input string is “00100101”, then there are three substrings “1001”, “100101” and “101”.
*/

public int countSubStr(char str[]){
	int one = 0;
	for (int i = 0; str[i] != '\0'; i++){
		if (str[i] == '1')
			one++;
	}

	return one * (one - 1) / 2;
}