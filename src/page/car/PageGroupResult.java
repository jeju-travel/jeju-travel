package page.car;

public class PageGroupResult {
	private int groupStartNumber; //밑에 링크 시작 번호
	private int groupEndNumber;  //밑에 링크 끝 번호
	
	private boolean beforePage = true; //링크를 보면 이전페이지<  (처음그룹이 앞에 그룹이 없어서 true)
	private boolean afterPage = true; // 다음 페이지>       이전링크 <> 다음링크
	
	private int selectPageNumber; // 페이지중에 현재 페이지의 번호를 넣어줄곳.

	public int getGroupStartNumber() {
		return groupStartNumber;
	}

	public void setGroupStartNumber(int groupStartNumber) {
		this.groupStartNumber = groupStartNumber;
	}

	public int getGroupEndNumber() {
		return groupEndNumber;
	}

	public void setGroupEndNumber(int groupEndNumber) {
		this.groupEndNumber = groupEndNumber;
	}

	public boolean isBeforePage() {
		return beforePage;
	}

	public void setBeforePage(boolean beforePage) {
		this.beforePage = beforePage;
	}

	public boolean isAfterPage() {
		return afterPage;
	}

	public void setAfterPage(boolean afterPage) {
		this.afterPage = afterPage;
	}

	public int getSelectPageNumber() {
		return selectPageNumber;
	}

	public void setSelectPageNumber(int selectPageNumber) {
		this.selectPageNumber = selectPageNumber;
	}
	
	
}
