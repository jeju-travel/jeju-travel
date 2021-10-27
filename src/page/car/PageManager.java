package page.car;

public class PageManager {
	private int requestPage;
	
	public PageManager() {}
	
	public PageManager(int requestPage) {
		super();
		this.requestPage = requestPage;
	}	
	
	public PageRowResult getPageRowResult() {
		PageRowResult pageRowResult = new PageRowResult();
		//PageRowResult�� �ִ� ������ ����ؼ� �ֱ�.
		//private int rowStartNumber;	//ȭ�鿡 �����ִ� ���� �� ��ȣ	(�� �ΰ� ���)
		//private int rowEndNumber;  //ȭ�鿡 �����ִ� ������ �� ��ȣ		
		
		//���1
		//pageRowResult.setRowStartNumber((requestPage-1)*PageInfo.ROW_COUNT_PER_PAGE+1);
		//���2
		pageRowResult.setRowStartNumber(requestPage*PageInfo.ROW_COUNT_PER_PAGE-(PageInfo.ROW_COUNT_PER_PAGE-1));
		pageRowResult.setRowEndNumber(PageInfo.ROW_COUNT_PER_PAGE*requestPage);
		return pageRowResult;
	}
	
	public PageGroupResult getPageGroupResult(int cnt) {
		//PageGroupResult�� �ִ� ������ ����ؼ� �ֱ�.
		//3���� �����ٰǵ� ..16���̸�:1,2,3,4,~~~~
		//   [1,2,3] ���� 
		//����[4,5,6] ����
		//����[7.8  ]
		
		//private int groupStartNumber; //�ؿ� ��ũ ���� ��ȣ1  3
		//private int groupEndNumber;  //�ؿ� ��ũ �� ��ȣ2  4
		PageGroupResult pgr = new PageGroupResult();
		
		// ������ �������� ��û������ ������ ��ũ�׷�ī��Ʈ ������ ���������� �ø��ؼ� +1�ǵ��� ����� �ڵ�.
		int reqPageGroupNumber = (int)Math.ceil((double)requestPage / PageInfo.SHOW_PAGE_COUNT);
		
		pgr.setGroupStartNumber(reqPageGroupNumber*PageInfo.SHOW_PAGE_COUNT-(PageInfo.SHOW_PAGE_COUNT-1));
											//reqpagegroupnumber * 3-2 = 7
		pgr.setGroupEndNumber(reqPageGroupNumber*PageInfo.SHOW_PAGE_COUNT);
											//reqpagegroupnumber * 3 = 9
		//������ �������� �����Ҷ��� ����ؼ� 
		//cnt�� 22���̸� ��ũ�� ��ũ�׷� 3�����̸�
		int totalPageNumber = (int)Math.ceil((double)cnt / PageInfo.ROW_COUNT_PER_PAGE);
		if(pgr.getGroupEndNumber()>totalPageNumber) { 
			pgr.setGroupEndNumber(totalPageNumber); //11
		}
		//private  boolean beforePage = true;//������ũ
				if(pgr.getGroupStartNumber()==1) {
			pgr.setBeforePage(false);
		}
		//private boolean afterPage = true;//������ũ

		if(pgr.getGroupEndNumber()==totalPageNumber) {
			pgr.setAfterPage(false);   //������ũ�� �������� ���´�
		}
		
		pgr.setSelectPageNumber(requestPage);
		
		return pgr;
	}	
}
