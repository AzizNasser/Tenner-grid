
public class assignment {
	int value;
	int column;
	int row;
	
	
	
	public assignment() {
		this.value = 0;
		this.column = 0;
		this.row = 0;
	}
	
	
	
	
	
	
	public assignment(int value, int column, int row) {
		this.value = value;
		this.column = column;
		this.row = row;
	}
	
	
	
	public int getmrv(tenner t) {
		t.successor(column, row);
		return t.vcol[column].vrow[row].size;
		
		
		
		
	}
	

	
}
