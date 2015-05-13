public class NullPointer {
	public static void main(String[] args) 
	{
		int []arr2D[] = new int[5][];
		arr2D[1] = new int[5];
		arr2D[2] = new int[6];
		System.out.println(arr2D[0] + " and " + arr2D[2]);
		System.out.println(arr2D[2].length);
	}
}
