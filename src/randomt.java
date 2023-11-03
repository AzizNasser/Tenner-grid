import java.util.Random;
public class randomt {

	Random r=new Random();
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	//picking random empty cell
	//arr[0] for column
	//arr[1] for row
	public  int[] position(tenner t) {
		int tmpcol;
		int tmprow;
		int[]arr=new int[2];
		tmpcol=r.nextInt(10);
		tmprow=r.nextInt(3);
		
		while(!t.isempty(tmpcol, tmprow)) {
			tmpcol=r.nextInt(10);
			tmprow=r.nextInt(3);
		}
		arr[0]=tmpcol;
		arr[1]=tmprow;
		
		return arr;
	}
	
	
	
	
	
	//assign 16 random value to a 16 random variable in the whole grid  
	private void grid(tenner t) {
		
		int[]arr;
		int tmpn;
		for(int i=0;i<16;i++) {
			
			arr=position(t);
			
			while(true) {
				tmpn=r.nextInt(10);
				//making sure that one value in each row
				if(!t.isDistinctRow(arr[1], tmpn))
					continue;
				
				//making sure that no corner or(diagonally contiguous cells) 
				 else if(t.isConnectingCell(arr[0], arr[1], tmpn)) {
					 continue;
				 }

				
				 else {
					t.vcol[arr[0]].vrow[arr[1]].value=tmpn; 
					break;}
			}
			
		
		}
		
	}
	
	
	
	//generating bottom number and and variable value
	public void generate(tenner t) {
		grid(t);
		bottomg(t);
		t.print();
	}
	
	
	
	
	public void generateExample(tenner t) {
		t.vcol[1].vrow[0].value=6;
		t.vcol[1].vrow[1].value=0;
		t.vcol[1].vrow[2].value=4;
		
		t.vcol[2].vrow[0].value=2;
		t.vcol[2].vrow[1].value=1;
		
		t.vcol[3].vrow[0].value=0;
		t.vcol[3].vrow[1].value=7;
		
		
		t.vcol[4].vrow[1].value=8;
		t.vcol[4].vrow[2].value=2;
		
		t.vcol[6].vrow[2].value=3;
		
		t.vcol[7].vrow[0].value=8;
		t.vcol[7].vrow[2].value=7;
		
		t.vcol[8].vrow[0].value=5;
		t.vcol[8].vrow[1].value=9;
		
		t.vcol[9].vrow[0].value=7;
		t.vcol[9].vrow[2].value=8;
		
		t.bottv[0]=13;t.bottv[1]=10;t.bottv[2]=8;
		t.bottv[3]=7;t.bottv[4]=19;t.bottv[5]=16;
		t.bottv[6]=11;t.bottv[7]=19;t.bottv[8]=15;
		t.bottv[9]=17;
		
		t.print();
		
		
		
		
		
	}
	
	
	
	public void generateExamplemini(tenner t) {
		
		t.vcol[0].vrow[0].value=4;
		t.vcol[0].vrow[1].value=3;
		t.vcol[0].vrow[2].value=6;
		
		
		
		
		t.vcol[1].vrow[0].value=6;
		t.vcol[1].vrow[1].value=0;
		t.vcol[1].vrow[2].value=4;
		
		t.vcol[2].vrow[0].value=2;
		t.vcol[2].vrow[1].value=1;
		
		t.vcol[3].vrow[0].value=0;
		t.vcol[3].vrow[1].value=7;
		t.vcol[3].vrow[2].value=0;
		
		
		t.vcol[4].vrow[1].value=8;
		t.vcol[4].vrow[2].value=2;
		
		t.vcol[6].vrow[0].value=3;
		t.vcol[6].vrow[1].value=5;
		t.vcol[6].vrow[2].value=3;
		
		t.vcol[7].vrow[0].value=8;
		t.vcol[7].vrow[2].value=7;
		
		t.vcol[8].vrow[0].value=5;
		t.vcol[8].vrow[1].value=9;
		
		t.vcol[9].vrow[0].value=7;
		t.vcol[9].vrow[2].value=8;
		
		t.bottv[0]=13;t.bottv[1]=10;t.bottv[2]=8;
		t.bottv[3]=7;t.bottv[4]=19;t.bottv[5]=16;
		t.bottv[6]=11;t.bottv[7]=19;t.bottv[8]=15;
		t.bottv[9]=17;
		
		
		
		
		
		
		
	}
	
	
	
	
	
	public void bottomg(tenner t) {
		tenner tt=new tenner();
		t.copytenner(tt);
		int tmpn;
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<3;j++) {
				if(t.vcol[i].vrow[j].value==-1) {
				tt.successor(i, j);
						for(int k=0;k<tt.vcol[i].vrow[j].size;k++) {
						tmpn=tt.vcol[i].vrow[j].arr[k];
		
//						if(!tt.isDistinctRow(j, tmpn))
//							continue;
//						
//						
//						 else if(tt.isConnectingCell(i, j, tmpn)) {
//							 continue;
//						 }

						
						// else {
							tt.vcol[i].vrow[j].value=tmpn; 
							break;
						//	break;}
					
						}

					}

				}
			}
		
		
		
		
		
		
		
		for(int i=0;i<10;i++) {
			t.bottv[i]=tt.sumcol1(i);
		}
		
		
		
		
		
		
		}
	
	
	
	
	
	
}
