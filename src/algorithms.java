import java.util.LinkedList;
import java.util.Random;
import java.util.PriorityQueue;

public class algorithms {
	

	
	public LinkedList<assignment>  solution;
	public LinkedList<assignment> assign;
	public LinkedList<assignment> unassign;
	public LinkedList<assignment> mrv;
	public int unassignsize;
	public int numberofcheck;
	public int numberofassignment;
	public long duration;
	
	
	
	
	
	public algorithms(tenner t) {
		numberofcheck=0;
		numberofassignment=0;
		duration=0;
		
		assign=new LinkedList<>();
		unassign=new LinkedList<>();
		mrv=new LinkedList<>();
		solution=new LinkedList<>();
		unassignsize=0;
		unassigncell(t);	
		
		//printAssignment(unassign);
	
	}
	
	//
	public boolean consistence(assignment a,int value,tenner t){
		tenner tmp=new tenner();
		t.copytenner(tmp);
		
		assignsol(tmp);
			
		// printing step==========
	//	tmp.print();
		//printAssignment(assign);
		
		//=====================
		
			
			
			if(tmp.isConnectingCell(a.column, a.row, value)||!tmp.isDistinctRow(a.row, value))
				return false;
		
		return true;
		
	}
	
	//
	public boolean checkGoal(tenner t) {
		
		tenner tmp=new tenner();
		t.copytenner(tmp);

		assignsol(tmp);
		return tmp.goalTest();
		
	}
	
	
	
	public void unassigncell(tenner t) {
		for(int i=0;i<10;i++) {
			for(int j=0;j<3;j++) {
				if(t.vcol[i].vrow[j].value==-1) {
					assignment tmp=new assignment(t.vcol[i].vrow[j].value,i,j);
					unassign.add(tmp);
					unassignsize++;
					
					
					}

				}
			}	
		}
	
	
	
	public void printAssignment(LinkedList<assignment> a) {
		System.out.print("{ ");
		for(int i=0;i<a.size();i++) {
			 assignment tmp =a.get(i);
			System.out.print("("+tmp.column+","+tmp.row+")="+tmp.value+" ");
		}System.out.println("  }");
	}
	
	
	public void iscontest(tenner t) {
		 assignment tmp=unassign.get(0);
		 
		 
		 t.successor(tmp.column, tmp.row);
		 System.out.println(tmp.column+" "+tmp.row);
		 t.vcol[tmp.column].vrow[tmp.row].printsucc();
		 
		 for(int i=0;i<t.vcol[tmp.column].vrow[tmp.row].size;i++) {
			 
			 
			 
		 }
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public LinkedList<assignment>Simplebacktracking(tenner t) {
		long start=System.currentTimeMillis();
		  solution=backtrack(t,solution);
		  duration=System.currentTimeMillis()-start;
		 return solution;

		
	}
	
	public LinkedList<assignment> backtrack(tenner t ,LinkedList<assignment> sol) {
		
		
		
		if(assign.size()==unassignsize)
			return assign;
		
		Random r=new Random();
		assignment tmp=unassign.get(r.nextInt(unassign.size()));
		
		while(assign.contains(tmp))
			tmp=unassign.get(r.nextInt(unassign.size()));
		
		t.successor(tmp.column, tmp.row);
		
		
		
		for(int i=0;i<t.vcol[tmp.column].vrow[tmp.row].size;i++) {
			
			int successorValue=t.vcol[tmp.column].vrow[tmp.row].arr[i];
			
			numberofcheck++;
			if(consistence(tmp,successorValue,t)) {
				
				tmp.value=successorValue;
				if(!assign.contains(tmp)) {
				numberofassignment++;
					assign.add(tmp);

				sol= backtrack(t,assign);
					
					if(checkGoal(t)) {
						return sol;
						}
					assign.remove(tmp);
				}
				}}
		return null;
	}
	
	
	
	public void assignsol(tenner t) {
		for(int i=0;i<assign.size();i++) {
			assignment tmp=assign.get(i);
			t.vcol[tmp.column].vrow[tmp.row].value=tmp.value;
		}
	}
	
	
	
	
	
	public void assisolmini() {


		
			assignment a1=new assignment(5,2,2);
			assignment a2=new assignment(9,4,0);
			assignment a3=new assignment(1,5,0);
			assignment a4=new assignment(6,5,1);
			assignment a5=new assignment(9,5,2);
			assignment a6=new assignment(4,7,1);
			assignment a7=new assignment(1,8,2);
			assignment a8=new assignment(2,9,1);
			
			
			assign.add(a1);
			assign.add(a2);
			assign.add(a3);
			assign.add(a4);
			assign.add(a5);
			assign.add(a6);
			assign.add(a7);
			assign.add(a8);
			
		
	}
	
	
	
	
	public void printsucof(tenner t) {
		for(int i=0;i<unassignsize;i++) {
			unassign.get(i);
			t.successor(unassign.get(i).column, unassign.get(i).row);
			System.out.print("("+unassign.get(i).column+","+unassign.get(i).row+") :");
			t.vcol[unassign.get(i).column].vrow[unassign.get(i).row].printsucc();
			System.out.println("\n\n\n");
		}
	}
	
	
	
	public void mrvt(tenner t) {
		
		for(int i=0;i<unassignsize;i++) {
			
			addmrv(unassign.get(i),t);
			
		}
		
		
		
		
		
		
	}
	
	public void addmrv(assignment a,tenner t) {
		int k=mrv.size();
		
		int i;
		for(i=0;i<k;i++) {
			if(mrv.get(i).getmrv(t)>a.getmrv(t))
				break;
		
		}
		
		mrv.add(i, a);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public LinkedList<assignment> BacktrackingwiththeMRVheuristic(tenner t) {
		
		
		long start=System.currentTimeMillis();
		
			mrvt(t);
		  solution=backtracka(t,solution);
		  duration=System.currentTimeMillis()-start;
		 return solution;}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public LinkedList<assignment> backtracka(tenner t ,LinkedList<assignment> sol) {

		if(assign.size()==unassignsize)
			return assign;
		mrvt(t);
		assignment tmp=mrv.get(0);
		for(int i=0;i<unassignsize;i++) {
			tmp=mrv.get(i);
			if(assign.contains(tmp))
				continue;
			else
				break;
		}
		
		t.successor(tmp.column, tmp.row);
		
		
		
		for(int i=0;i<t.vcol[tmp.column].vrow[tmp.row].size;i++) {
			
			int successorValue=t.vcol[tmp.column].vrow[tmp.row].arr[i];
			
			numberofcheck++;
			if(consistence(tmp,successorValue,t)) {
				
				tmp.value=successorValue;
				if(!assign.contains(tmp)) {
				numberofassignment++;
					assign.add(tmp);
					
					

				sol= backtrack(t,assign);
					
					if(checkGoal(t)) {
						return sol;
						}
					assign.remove(tmp);
				}
				}}
		return null;
	}
	
	
	
	
	
	
	public boolean INFERENCE(tenner t,LinkedList<assignment> sol) {
		

		tenner tmp=new tenner();
		t.copytenner(tmp);
		assignsol(tmp);
		
		
		for(int i=0;i<unassignsize;i++) {

			if(unassign.get(i).getmrv(tmp)==0)
				return false;
		}
		
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
	
	public LinkedList<assignment> Forwardchecking(tenner t) {
		
		long start=System.currentTimeMillis();
		  solution=backtrackf(t,solution);
		  duration=System.currentTimeMillis()-start;
		 return solution;
		
		
	}
	
	
	
	
	
	
	public LinkedList<assignment> backtrackf(tenner t ,LinkedList<assignment> sol) {
		
		
		
		if(assign.size()==unassignsize)
			return assign;
		
		Random r=new Random();
		assignment tmp=unassign.get(r.nextInt(unassign.size()));
		
		while(assign.contains(tmp))
			tmp=unassign.get(r.nextInt(unassign.size()));
		
		t.successor(tmp.column, tmp.row);
		
		
		
		for(int i=0;i<t.vcol[tmp.column].vrow[tmp.row].size;i++) {
			
			int successorValue=t.vcol[tmp.column].vrow[tmp.row].arr[i];
			
			numberofcheck++;
			if(consistence(tmp,successorValue,t)) {
				
				tmp.value=successorValue;
				if(!assign.contains(tmp)) {
				numberofassignment++;
					assign.add(tmp);
					
					
					if(!INFERENCE(t,assign)) {

				sol= backtrack(t,assign);
					
					if(checkGoal(t)) {
						return sol;
						}
					
					
					assign.remove(tmp);
				}
				}}}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public LinkedList<assignment> ForwardcheckingwithMRVheuristic(tenner t) {
		
		
		long start=System.currentTimeMillis();
		
		mrvt(t);
	  solution=backtrackaf(t,solution);
	  duration=System.currentTimeMillis()-start;
	 return solution;
			
		
	}
	
	
	
	
	
	public LinkedList<assignment> backtrackaf(tenner t ,LinkedList<assignment> sol) {

		if(assign.size()==unassignsize)
			return assign;
		mrvt(t);
		assignment tmp=mrv.get(0);
		for(int i=0;i<unassignsize;i++) {
			tmp=mrv.get(i);
			if(assign.contains(tmp))
				continue;
			else
				break;
		}
		
		t.successor(tmp.column, tmp.row);
		
		
		
		for(int i=0;i<t.vcol[tmp.column].vrow[tmp.row].size;i++) {
			
			int successorValue=t.vcol[tmp.column].vrow[tmp.row].arr[i];
			
			numberofcheck++;
			if(consistence(tmp,successorValue,t)) {
				
				tmp.value=successorValue;
				if(!assign.contains(tmp)) {
				numberofassignment++;
					assign.add(tmp);
					
					if(!INFERENCE(t,assign)) {

				sol= backtrack(t,assign);
					
					if(checkGoal(t)) {
						return sol;
						}
					assign.remove(tmp);
				}
				}}}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
