/*
Write a CSV parser that correctly handles quotes
*/

public class CSVPaser{
	//method 1: java.util.Scanner
	public static void main(String args[]) throws FileNotFoundException{
		Scanner scanner = new Scanner(new File("CSVFile.csv"));

		scanner.useDelimiter(",");
		while (scanner.hasNext()){
			System.out.print(scanner.next() + " ");
		}
		scanner.close();
	}

	//method 2: String.split() 
	public static void main(String args[]){
		String file = "CSVFile.csv";
		BufferedReader fileReader = null;

		final String DELIMITER = ",";
		try{
			String line = "";
			fileReader = new BufferedReader(new FileReader(file));

			while ((line = fileReader.readLine()) != null){
				String[] tokens = line.split(DELIMITER);
				for (String token : tokens){
					System.out.println(token);
				}
			}
		}
		catch(Exceptoin e){
			//print the info of wrong position and reason in command line
			e.printStackTrace();
		}
		finally{
			try{
				fileReader.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}

