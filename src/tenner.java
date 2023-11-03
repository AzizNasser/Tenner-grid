
public class tenner {
	public variable[] vcol;  // variable column
	public int []bottv;      // bottom variable
	
	
	
	public tenner() {
		vcol=new variable[10];                          // vcol[0] vrow[0]      vcol[1] vrow[0]     .........
		for(int i=0;i<10;i++) {						    // vcol[0] vrow[1]      vcol[1] vrow[1]     ........					
			vcol[i]=new variable();					    //   .............       ..............
													    // vcol[0] vrow[2]      ...............	    vcol[9] vrow[2]
		}												// =========================================================
		bottv=new int[10];								// bottv[0]               bottv[1]  .....         bottv[9]
		
		
	
		
		
			
		
		
		
	}
	
	//print 10X3 tenner 
	//-1 means empty cell
	public void  print() {
		System.out.println();
		for(int i=0;i<3;i++) {
			for(int j=0;j<10;j++) {
				System.out.printf(" %-4d",vcol[j].vrow[i].value);
			}
			System.out.println();
		}
		System.out.println("------------------------------------------------");
		for(int i=0;i<10;i++) {
			System.out.printf(" %-4d",bottv[i]);
			
		}
		System.out.println();		
	}
	
	
	//Numbers appear only once in a row.
	public boolean isDistinctRow(int row,int n) {
		for(int i=0;i<10;i++) {
			if(vcol[i].vrow[row].value==n)
				return false;
		}
		return true;
	}
	
	//diagonally contiguous cells or corner 
	//return true if there is diagonally contiguous cells
	public boolean isConnectingCell(int column,int row,int tmp) {
		if(tmp==-1) {
			
			return false;
			}
		
		if(column==0) {
			
			
			
			if(row==0) {
				
			if(downright(column,row,tmp))
					return true;}
			
			if(row==1){
				
				if(downright(column,row,tmp)||upright(column,row,tmp))
					return true;}
				
			if(row==2) {
				
				if(upright(column,row,tmp))
					return true;}
		
			
			
			
			return false;	
			
		}
		
		
		
		
		if(column==9) {
			
			
			
			if(row==0) {
				
			if(downleft(column,row,tmp))
					return true;}
			
			if(row==1) {
				
				if(downleft(column,row,tmp)||upleft(column,row,tmp))
					return true;}
				
			if(row==2) {
				
				if(upleft(column,row,tmp))
					return true;}
		
			
			
			
				return false;
			
		}
		
		
		if(row==0) {
			
			if(downright(column,row,tmp)||downleft(column,row,tmp))
				return true;
		return false;	
		}
		
		
		
		if(row==2) {
			
			if(upright(column,row,tmp)||upleft(column,row,tmp))
				return true;
		return false;	
		}
			
			
			
		
if(upright(column,row,tmp)||upleft(column,row,tmp)||downright(column,row,tmp)||downleft(column,row,tmp))  {
		
	return true;
		}

		return false;
	}
	
	
	
	//========================== PRIVATE METHODS  USED FOR isConnectingCell() ===========================================
	
	private boolean upright(int column,int row,int tmp) {
		
		
		if(isempty(column+1,row-1))
			return false;
		
		if(tmp==vcol[column+1].vrow[row-1].value)
		return true;
		return false;
	}
	
	private boolean upleft(int column,int row,int tmp) {
		
		
			
		if(isempty(column-1,row-1))
			return false;
		
		if(tmp==vcol[column-1].vrow[row-1].value)
		return true;
		return false;
	}
	
	
	
	private boolean downright(int column,int row,int tmp) {
		if(isempty(column+1,row+1))
			return false;
		
		if(tmp==vcol[column+1].vrow[row+1].value)
		return true;
		return false;
	}
	
	private boolean downleft(int column,int row,int tmp) {
		if(isempty(column-1,row+1))
			return false;
		
		if(tmp==vcol[column-1].vrow[row+1].value)
		return true;
		return false;
	}
	
	//==========================================================================================================
		
	
		//ADDING the column 
		// returning  integer array of size two arr[2]
		//for arr[0] sum of column
		//for arr[1] number of empty cell (-1)
		public int[] sumcol(int column) {
			int[]arr=new int[2];
			int sum=0;
			int numberOfEmpty=0;
			int tmp;
			for(int i=0;i<3;i++) {
				tmp=vcol[column].vrow[i].value;
				if(tmp==-1) {
					numberOfEmpty++;
					continue;}
				sum+=tmp;
					
			}
			arr[0]=sum;
			arr[1]=numberOfEmpty;
			return arr;
		}
		
		//flag for empty cell
		public boolean isempty(int column,int row) {
			int tmp=vcol[column].vrow[row].value;
			return tmp==-1;
		}
		
		
		//used to get all legal value for specific cell
		//if cell is already assigned no legal value appears
		public void successor(int column,int row) {
			if(!isempty(column,row))
				return;
			int counter=vcol[column].vrow[row].size=0;
			
			for(int i=0;i<10;i++) {
			if(!isDistinctRow(row,i))
				continue;
			if(isConnectingCell(column,row,i))
				continue;
			vcol[column].vrow[row].arr[counter++]=i;
			}
			
			vcol[column].vrow[row].size=counter;
			
		}
		
		
		
		
		public boolean goalTest() {
			int[] arr;
			for(int i=0;i<10;i++) {
				arr=sumcol(i);
				if(arr[0]==bottv[i]&&arr[1]==0)
					continue;
				else
					return false;
			}
			
			return true;
		}
		
		
		public boolean fail(int column) {
			int[] arr=sumcol(column);
			
			if(arr[0]!=bottv[column]&&arr[1]==3)
			return true;
			
			return false;
		}
		
		
		
		
		public void copytenner(tenner t) {
			for(int i=0;i<10;i++) {
				t.bottv[i]=bottv[i];
				for(int j=0;j<3;j++) {
					t.vcol[i].vrow[j].value=vcol[i].vrow[j].value;
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		public int sumcol1(int column) {
			
			int sum=0;
			
			int tmp;
			for(int i=0;i<3;i++) {
				tmp=vcol[column].vrow[i].value;
				if(tmp==-1) {
					
					continue;}
				sum+=tmp;
					
			}
			
			return sum;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
				
				
			
		
		
		
		
		
		
		
	
	
	

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	

}
