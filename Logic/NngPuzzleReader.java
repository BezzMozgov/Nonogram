package Logic;

import java.io.*;
import java.util.*;

public class NngPuzzleReader {
	private ArrayList<ArrayList<Integer>> tempArray = null;
	private int size;
	private static int max = 5; // default textBox size
	private BufferedReader br = null;
	private String line;			
	private String[] mainHeadersLines = null;
	
	public NngPuzzleReader(File file) 
		//	throws InitErrorException, IOException
		{
			try {
				this.br = new BufferedReader(new FileReader(file));
				this.line = br.readLine();
				br.close();
			}
				catch(IOException e) {};
		}

		private void readHeadFromFile() 
		{
			max = 0;
			mainHeadersLines = line.split("\\|"); // dividing puzzle header on rows and columns

			TestClass.setHeaderRows(parse(mainHeadersLines[0]));
			TestClass.setRows(size);
			TestClass.setHeaderColumns(parse(mainHeadersLines[1]));
			TestClass.setCols(size);

		}

		public void buildHead() 
		//	throws IOException
		{
			this.readHeadFromFile();
		}
		
		private ArrayList<ArrayList<Integer>> parse(String oneSideHeaderLine) {
			tempArray = new ArrayList<ArrayList<Integer>>();
			String[] oneHeaderLineSet = oneSideHeaderLine.split("\\,"); // dividing header on lines

			for (String oneHeaderLine : oneHeaderLineSet) {
				size = oneHeaderLineSet.length; // border length
				ArrayList<Integer> header = new ArrayList<Integer>();
                String[] oneHeaderValueSet = oneHeaderLine.split(" "); // dividing header line on separate values
                
                if ( isMax(oneHeaderValueSet)) {
            		max = oneHeaderValueSet.length;
                }
                
                for(String oneHeaderValue : oneHeaderValueSet){
                	
                //	try {
                		header.add(Integer.parseInt(oneHeaderValue));
                //	} catch (NumberFormatException obj) {};
                }
                
                tempArray.add(header);
            }
			return tempArray;
		}
		
		public static int getMax() {
			return max;
		}
		
		private boolean isMax(String[] string) {
			return max < string.length;
		}
}
