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
		//PageRowResult에 있는 변수값 계산해서 넣기.
		//private int rowStartNumber;	//화면에 보여주는 시작 줄 번호	(이 두개 계산)
		//private int rowEndNumber;  //화면에 보여주는 마지막 줄 번호		
		
		//방법1
		//pageRowResult.setRowStartNumber((requestPage-1)*PageInfo.ROW_COUNT_PER_PAGE+1);
		//방법2
		pageRowResult.setRowStartNumber(requestPage*PageInfo.ROW_COUNT_PER_PAGE-(PageInfo.ROW_COUNT_PER_PAGE-1));
		pageRowResult.setRowEndNumber(PageInfo.ROW_COUNT_PER_PAGE*requestPage);
		return pageRowResult;
	}
	
	public PageGroupResult getPageGroupResult(int cnt) {
		//PageGroupResult에 있는 변수값 계산해서 넣기.
		//3개씩 보여줄건데 ..16줄이면:1,2,3,4,~~~~
		//   [1,2,3] 다음 
		//이전[4,5,6] 다음
		//이전[7.8  ]
		
		//private int groupStartNumber; //밑에 링크 시작 번호1  3
		//private int groupEndNumber;  //밑에 링크 끝 번호2  4
		PageGroupResult pgr = new PageGroupResult();
		
		// 나눌때 페이지가 요청페이지 나누기 링크그룹카운트 나눈후 나머지갑을 올림해서 +1되도록 만드는 코드.
		int reqPageGroupNumber = (int)Math.ceil((double)requestPage / PageInfo.SHOW_PAGE_COUNT);
		
		pgr.setGroupStartNumber(reqPageGroupNumber*PageInfo.SHOW_PAGE_COUNT-(PageInfo.SHOW_PAGE_COUNT-1));
											//reqpagegroupnumber * 3-2 = 7
		pgr.setGroupEndNumber(reqPageGroupNumber*PageInfo.SHOW_PAGE_COUNT);
											//reqpagegroupnumber * 3 = 9
		//마지막 페이지가 부족할때를 대비해서 
		//cnt가 22줄이면 링크가 링크그룹 3개씩이면
		int totalPageNumber = (int)Math.ceil((double)cnt / PageInfo.ROW_COUNT_PER_PAGE);
		if(pgr.getGroupEndNumber()>totalPageNumber) { 
			pgr.setGroupEndNumber(totalPageNumber); //11
		}
		//private  boolean beforePage = true;//이전링크
				if(pgr.getGroupStartNumber()==1) {
			pgr.setBeforePage(false);
		}
		//private boolean afterPage = true;//다음링크

		if(pgr.getGroupEndNumber()==totalPageNumber) {
			pgr.setAfterPage(false);   //이전링크가 없어지게 나온다
		}
		
		pgr.setSelectPageNumber(requestPage);
		
		return pgr;
	}	
}
