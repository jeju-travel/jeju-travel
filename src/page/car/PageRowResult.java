package page.car;

public class PageRowResult {
	private int rowStartNumber;	//화면에 보여주는 시작 줄 번호	16	16~20이면
	private int rowEndNumber;  //화면에 보여주는 마지막 줄 번호   20
	
	public int getRowStartNumber() {
		return rowStartNumber;
	}
	public void setRowStartNumber(int rowStartNumber) {
		this.rowStartNumber = rowStartNumber;
	}
	public int getRowEndNumber() {
		return rowEndNumber;
	}
	public void setRowEndNumber(int rowEndNumber) {
		this.rowEndNumber = rowEndNumber;
	}
	
	
}
