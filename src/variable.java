
public class variable {

	public cell []vrow; //variable row
	
	
	 
	public variable (){
		vrow=new cell[3];
		for(int i=0;i<3;i++) {
			vrow[i]=new cell();
			
		}

	}
	
	public void printv() {
		for(int i=0;i<3;i++)
			System.out.println(vrow[i].value); //print variable row
	}
	
	
}
