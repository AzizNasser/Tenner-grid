
public class reportTest {
	
	
	
	
	
	
	
	public  void Simplebacktracking() {
		
		
		
		int count=0;
		int count1=1;
		
		while(count<5)	{
		
		
			tenner t=new tenner();		
			randomt r=new randomt();
			System.out.println("================================================\n\nGAME  "+count1+"\n\n");
		r.generate(t);
	algorithms a=new algorithms(t);
		System.out.println("\n\n");

	a.solution=a.Simplebacktracking(t);
	count1++;
	if(a.solution==null) {
		System.out.println("no solution");
		t.print();
		System.out.println("\ntime used to check(millisecond): "+a.duration);
	System.out.println("================================================\n\n\n\n");}
	else
	{
		count++;
		System.out.println("solution found");
		a.assignsol(t);
		t.print();	
		System.out.println("number of variable assignments: "+a.numberofassignment);
		System.out.println("number of consistency checks: "+a.numberofcheck);
		System.out.println("time used to solve the problem(millisecond): "+a.duration);
		System.out.println("final CSP Tenner variable assignments");
		a.printAssignment(a.solution);
		System.out.println("================================================\n\n\n\n");
	}
		}	
		
	}

	
	
	
	
	public  void BacktrackingwiththeMRVheuristic() {
		
		
		
		int count=0;
		int count1=1;
		
		while(count<5)	{
		
		
			tenner t=new tenner();		
			randomt r=new randomt();
			System.out.println("================================================\n\nGAME  "+count1+"\n\n");
		r.generate(t);
	algorithms a=new algorithms(t);
		System.out.println("\n\n");

	a.solution=a.BacktrackingwiththeMRVheuristic(t);
	count1++;
	if(a.solution==null) {
		System.out.println("no solution");
		t.print();
		System.out.println("\ntime used to check(millisecond): "+a.duration);
	System.out.println("================================================\n\n\n\n");}
	else
	{
		count++;
		System.out.println("solution found");
		a.assignsol(t);
		t.print();	
		System.out.println("number of variable assignments: "+a.numberofassignment);
		System.out.println("number of consistency checks: "+a.numberofcheck);
		System.out.println("time used to solve the problem(millisecond): "+a.duration);
		System.out.println("final CSP Tenner variable assignments");
		a.printAssignment(a.solution);
		System.out.println("================================================\n\n\n\n");
	}
		}	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public  void Forwardchecking() {
		
		
		
		int count=0;
		int count1=1;
		
		while(count<5)	{
		
		
			tenner t=new tenner();		
			randomt r=new randomt();
			System.out.println("================================================\n\nGAME  "+count1+"\n\n");
		r.generate(t);
	algorithms a=new algorithms(t);
		System.out.println("\n\n");

	a.solution=a.Forwardchecking(t);
	count1++;
	if(a.solution==null) {
		System.out.println("no solution");
		t.print();
		System.out.println("\ntime used to check(millisecond): "+a.duration);
	System.out.println("================================================\n\n\n\n");}
	else
	{
		count++;
		System.out.println("solution found");
		a.assignsol(t);
		t.print();	
		System.out.println("number of variable assignments: "+a.numberofassignment);
		System.out.println("number of consistency checks: "+a.numberofcheck);
		System.out.println("time used to solve the problem(millisecond): "+a.duration);
		System.out.println("final CSP Tenner variable assignments");
		a.printAssignment(a.solution);
		System.out.println("================================================\n\n\n\n");
	}
		}	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
public  void ForwardcheckingwithMRVheuristic() {
		
		
		
		int count=0;
		int count1=1;
		
		while(count<5)	{
		
		
			tenner t=new tenner();		
			randomt r=new randomt();
			System.out.println("================================================\n\nGAME  "+count1+"\n\n");
		r.generate(t);
	algorithms a=new algorithms(t);
		System.out.println("\n\n");

	a.solution=a.ForwardcheckingwithMRVheuristic(t);
	count1++;
	if(a.solution==null) {
		System.out.println("no solution");
		t.print();
		System.out.println("\ntime used to check(millisecond): "+a.duration);
	System.out.println("================================================\n\n\n\n");}
	else
	{
		count++;
		System.out.println("solution found");
		a.assignsol(t);
		t.print();	
		System.out.println("number of variable assignments: "+a.numberofassignment);
		System.out.println("number of consistency checks: "+a.numberofcheck);
		System.out.println("time used to solve the problem(millisecond): "+a.duration);
		System.out.println("final CSP Tenner variable assignments");
		a.printAssignment(a.solution);
		System.out.println("================================================\n\n\n\n");
	}
		}	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
