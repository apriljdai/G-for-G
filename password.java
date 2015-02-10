import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;


public class Password {
	public static void isValid(String str, BufferedWriter bw) throws IOException{
		//check if the the length is no longer than 20
		if (str == null || str.length() == 0 || str.length() > 20){
			bw.write("<" + str + "> is not acceptable.\n");
			//System.out.println("<" + str + "> is not acceptable.");
			return;
		}
		//put all char to the lowercase
		str = str.toLowerCase();
		HashSet<Character> vowel = new HashSet<Character>();
		HashSet<Character> cons = new HashSet<Character>();
		for (char i = 'a'; i <= 'z'; i++){
			if (isVowel(i)){
				vowel.add(i);
			}
			else{
				cons.add(i);
			}
		}
		isValid(str, vowel, cons, bw);
	}

	public static boolean isVowel(Character c){
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
			return true;
		}
		return false;
	}

	public static void isValid(String str, HashSet<Character> vowel, HashSet<Character> cons, BufferedWriter bw) throws IOException{
		//check if the character is all alphabetic
		for (int i = 0; i < str.length(); i++){
			if (str.charAt(i) < 'a' || str.charAt(i) > 'z'){
				System.out.println("Not valid password.");
				return;
			}
		}
		//must contain at least one vowel
		boolean check = false;
		for (int i = 0; i < str.length(); i++){
			if (vowel.contains(str.charAt(i))){
				check = true;
				break;
			}
		}
		if (!check){
			bw.write("<" + str + "> is not acceptable.\n");
			//System.out.println("<" + str + "> is not acceptable.\n");
			return;
		}

		//cannot contain three consecutive vowels or three consecutive consonents
		boolean isVow = false, isCons = false;
		for (int i = 0; i < str.length() - 2; i++){
			if (vowel.contains(str.charAt(i)) && vowel.contains(str.charAt(i + 1)) && vowel.contains(str.charAt(i + 2))){
				isVow = true;
				break;
			}
			else if (cons.contains(str.charAt(i)) && cons.contains(str.charAt(i + 1)) && cons.contains(str.charAt(i + 2))){
				isCons = true;
				break;
			}
		}
		if (isVow || isCons){
			bw.write("<" + str + "> is not acceptable.\n");
			//System.out.println("<" + str + "> is not acceptable.");
			return;
		}

		//cannot contain two consecutive occurences of the same letter, except for "ee" or "oo"
		boolean isSame = false;
		for (int i = 0; i < str.length() - 1; i ++){
			if (str.charAt(i) == str.charAt(i + 1)){
				if (str.charAt(i) == 'e' || str.charAt(i) == 'o')
					continue;
				else{
					isSame = true;
					break;
				}
			}
		}
		if (isSame){
			bw.write("<" + str + "> is not acceptable.\n");
			//System.out.println("<" + str + "> is not acceptable.");
			return;
		}
		bw.write("<" + str + "> is acceptable.\n");
		//System.out.println("<" + str + "> is acceptable.");
	}

	public static void main(String args[]) throws IOException{
		//Note: the user must have this file in the current directory
		try{
			BufferedReader br = new BufferedReader(new FileReader("/say.in.txt"));
			FileWriter fw = new FileWriter("/say.out.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			String line;
			while (!(line = br.readLine()).equals("end")){
				isValid(line, bw);
			}
			br.close();
			bw.close();
		}
		catch(IOException e){
			System.out.println("Error to get the file.");
		}
	}
}