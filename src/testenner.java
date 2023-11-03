
public class testenner {
	
	//test 
	public static void main(String []v) {
		
		tenner t=new tenner();
		
		randomt r=new randomt();
		
		r.generateExamplemini(t);
		
	
		
		algorithms a=new algorithms(t);
		t.print();
		System.out.println("\n\n\n\n==============================================\n\n\n\n");
		
		a.solution=a.Forwardchecking(t);
		
		
		
		
		a.assignsol(t);
		
		
		
		
		t.print();
		
		
	
		

		
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
	}

}
