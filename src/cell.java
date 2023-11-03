
public class cell {
	public int value;
	public int[] arr;
	public int size;
	//each cell has value and  array of possible value
	public cell() {
		value=-1;  // for empty cell
		size=0;
		arr=new int[10];
		
	}
	
	public void printsucc() {
		for(int i=0;i<size;i++)
			System.out.print(arr[i]+" ");
	}

}
