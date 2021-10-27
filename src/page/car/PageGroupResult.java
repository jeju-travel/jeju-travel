package page.car;

public class PageGroupResult {
	private int groupStartNumber; //�ؿ� ��ũ ���� ��ȣ
	private int groupEndNumber;  //�ؿ� ��ũ �� ��ȣ
	
	private boolean beforePage = true; //��ũ�� ���� ����������<  (ó���׷��� �տ� �׷��� ��� true)
	private boolean afterPage = true; // ���� ������>       ������ũ <> ������ũ
	
	private int selectPageNumber; // �������߿� ���� �������� ��ȣ�� �־��ٰ�.

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
