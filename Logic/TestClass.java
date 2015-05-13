package Logic;

import java.util.*;
import View.*;
import exceptions.*;

public class TestClass {
	private static ArrayList<ArrayList<Integer>> headerRows = new ArrayList<ArrayList<Integer>>();
	private static ArrayList<ArrayList<Integer>> headerColumns = new ArrayList<ArrayList<Integer>>();
	private static int rows = 5;
	private static int cols = 5;
	
	public TestClass () {
	//	addObserver((Observer)view);
	}
	
	public static void setRows(int rows)
	{
		if (rows < 1 || rows > 50) {
			return;
		}
		TestClass.rows = rows;
	}
	
	public static void setCols(int cols) 
	{
		if (cols < 1 || cols > 50) {
			return;
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
		System.out.println("ROWS");
		for( ArrayList<Integer> i : array){
		    for (Integer j : i ) {
		    	System.out.println(String.valueOf(j));
		    }
		}
	}
	
	public static void setHeaderColumns(ArrayList<ArrayList<Integer>> array) {
		headerColumns = array;
		System.out.println("COLS");
		for( ArrayList<Integer> i : array){
		    for (Integer j : i ) {
		    	System.out.println(String.valueOf(j));
		    }
		}
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
