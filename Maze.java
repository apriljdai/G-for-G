/*
Maze
Given an M*N array of array of characters where O = Open Space, X = Wall, S = Start, and E = End, return a list that contains a sequential path from the start position to the end position. You can't move diagonally and you can't move off the ends of the array.
You probably want to draw something like this to visualize it:

O O O X E 
O X O X O
O X X X O 
O O O O O
O S O O O
*/

//define a point class to hold the x and y corrdinates and some other generic tuple
public class Point{
	private int x;
	private int y;
	private char val;

	public Point(){
		x = 0;
		y = 0; 
		val = '';
	}

	public Point(int a, int b, char c){
		x = a;
		y = b;
		val = c;
	}

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public char getV(){
		return val;
	}
}

public class Maze{
	public void path(char[][] matrix){
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			throw new IllegalStateException("The matrix is empty!");

		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		ArrayList<Point> path = new ArrayList<Point>();
		//create a stack to keep track of points that you need to check
		//Stack<Point> stack = new Stack<Point>();

		//boolean reversed;
		char start;
		//find the start or end point by looping through the array
		int i, j;
		for (i = 0; i < matrix.length; i++){
			for (j = 0; j < matrix[0].length; j++){
				if (matrix[i][j] == 'S' || matrix[i][j] == 'E'){
					Point myPoint = new Point(i, j, matrix[i][j]);
					start = matrix[i][j];
					visited[i][j] = true;
					if (matrix[i][j] == 'E')
						reversed = true;
					path.add(myPoint);
					stack.push(myPoint);
					break;
				}
			}
			if (!path.isEmpty()){
				break;
			}
		}
		path(matrix, path, start, visited);
	}

	public void path(char[][] matrix, ArrayList<Point> path, char start, boolean[][] visited){
		Point myPoint = path.get(path.size() - 1);
		if ((myPoint.val == 'E' || myPoint.val == 'S') && myPoint.val != start){
			path.add(myPoint);
			if (start == 'E')
				Collections.reverse(path);
			System.out.println(path);
			return;
		}

		int coodx = myPoint.getX();
		int coody = myPoint.getY();
		
		Point northPoint = new Point(coodx - 1, coody, matrix[coodx - 1][coody]);
		if ((coodx != 0) && (northPoint.val != 'X') && !visit[coodx - 1][coody]){
			path.add(northPoint);
			visit[coodx - 1][coody] = true;
			path(matrix, path, start, visited);
			path.remove(path.size() - 1);
			visited[coodx - 1][coody] = false;
		}
		Point sorthPoint = new Point(coodx + 1, coody, matrix[coodx + 1][coody]);
		if ((coodx < matrix.length - 1) && (southPoint.val != 'X') && !visit[coodx + 1][coody]){
			path.add(southPoint);
			visit[coodx + 1][coody] = true;
			path(matrix, path, start, visited);
			path.remove(path.size() - 1);
			visited[coodx + 1][coody] = false;
		}
		Point westPoint = new Point(coodx, coody - 1, matrix[coodx][coody - 1]);
		if (coody != 0 && (westPoint.val != 'X') && !visit[coodx][coody - 1]){
			path.add(westPoint);
			visit[coodx][coody - 1] = true;
			path(matrix, path, start, visited);
			path.remove(path.size() - 1);
			visited[coodx][coody - 1] = false;
		}
		Point eastPoint = new Point(coodx, coody + 1, matrix[coodx][coody + 1]);
		if (coody < matrix[0].length - 1 && (eastPoint.val != 'X') && !visit[coodx][coody + 1]){
			path.add(westPoint);
			visit[coodx][coody + 1] = true;
			path(matrix, path, start, visited);
			path.remove(path.size() - 1);
			visited[coodx][coody + 1] = false;
		}
	}
}