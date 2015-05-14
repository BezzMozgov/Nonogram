package Logic;

import java.util.*;

public class TestClass {
	private static ArrayList<ArrayList<Integer>> headerRows = null;
	private static ArrayList<ArrayList<Integer>> headerColumns = null;
	private static int rows = 6;
	private static int cols = 4;
	
	public TestClass () {
	//	addObserver((Observer)view);
		headerRows = new ArrayList<ArrayList<Integer>>();
		headerColumns = new ArrayList<ArrayList<Integer>>();
	}
	
	public static void setRows(int rows)
	{
		if (rows < 1 ) {
			throw new NumberFormatException("and can not be less than 1");
		} else if (rows > 50) {
			throw new NumberFormatException("and can not be more than 50");
		}
		TestClass.rows = rows;
	}
	
	public static void setCols(int cols) 
	{
		if (cols < 1 ) {
			throw new NumberFormatException("and can not be less than 1");
		} else if (cols > 50) {
			throw new NumberFormatException("and can not be more than 50");
		}
		TestClass.cols = cols;
	}
	
	public static int getRows() {
		return rows;
	}
	
	public static int getCols() {
		return cols;
	}
	
	public static void setHeaderRows(ArrayList<ArrayList<Integer>> array) {
		headerRows = array;
	}
	
	public static void setHeaderColumns(ArrayList<ArrayList<Integer>> array) {
		headerColumns = array;
	}
	
	public static ArrayList<ArrayList<Integer>> getHeaderRows() {
		return headerRows;
	}
	
	public static ArrayList<ArrayList<Integer>> getHeaderColumns() {
		return headerColumns;
	}
	
	public void newGame () {
//	 	setChanged();
//	 	notifyObservers();
	}
}
