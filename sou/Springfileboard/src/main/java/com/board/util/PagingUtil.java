//페이징 처리(계산)이 다 설정된 클래스

package com.board.util;

public class PagingUtil {
	
	private int startCount;	 // 한 페이지에서 보여줄 게시글의 시작 번호
	private int endCount;	 // 한 페이지에서 보여줄 게시글의 끝 번호
	private StringBuffer pagingHtml;// 페이징 생성자 ->링크문자열을 연결

	/**
	 * currentPage : 현재페이지
	 * totalCount : 전체 게시물 수
	 * blockCount : 한 페이지의  게시물의 수->numPerPage
	 * blockPage : 한 화면에 보여줄 페이지 수
	 * pageUrl : 호출 페이지 url
	 * addKey : 부가적인 key 없을 때는 null 처리 (&num=23형식으로 전달할 것)
	 *               전달할 매개변수가 없는 경우
	 * */
	
	public PagingUtil(int currentPage, int totalCount, int blockCount,
			int blockPage, String pageUrl) {
		this(null,null,currentPage,totalCount,blockCount,blockPage,pageUrl,null);
	}
	public PagingUtil(int currentPage, int totalCount, int blockCount,
			int blockPage, String pageUrl, String addKey) {
		this(null,null,currentPage,totalCount,blockCount,blockPage,pageUrl,addKey);
	}
	public PagingUtil(String keyField, String keyWord, int currentPage, int totalCount, int blockCount,
			int blockPage,String pageUrl) {
		this(null,null,currentPage,totalCount,blockCount,blockPage,pageUrl,null);
	}
	public PagingUtil(String keyField, String keyWord, int currentPage, int totalCount, int blockCount,
			int blockPage,String pageUrl,String addKey) {
		
		if(addKey == null) addKey = ""; //부가키가 null 일때 ""처리
		
		// 전체 페이지 수  ->122/10=12+1=13
		int totalPage = (int) Math.ceil((double) totalCount / blockCount);
		if (totalPage == 0) {
			totalPage = 1;
		}
		// 현재 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
		// 현재 페이지가 맨 마지막 페이지라면 전체 페이지와 같게 설정하라
		if (currentPage > totalPage) {  //16>15=>currentPage=15
			currentPage = totalPage;
		}
		// 현재 페이지의 처음과 마지막 글의 번호 가져오기.
		startCount = (currentPage - 1) * blockCount + 1;
		endCount = currentPage * blockCount;
		// 시작 페이지와 마지막 페이지 값 구하기.
		int startPage = (int) ((currentPage - 1) / blockPage) * blockPage + 1;
		int endPage = startPage + blockPage - 1;
		// 마지막 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		// 이전 block 페이지
		pagingHtml = new StringBuffer();//=new String();
		if (currentPage > blockPage) {
			if(keyWord==null){//검색 미사용시
				pagingHtml.append("<a href="+pageUrl+"?pageNum="+ (startPage - 1) + addKey +">");
			}else{ //검색어가 있다면
				pagingHtml.append("<a href="+pageUrl+"?keyField="+keyField+"&keyWord="+keyWord+"&pageNum="+ (startPage - 1) + addKey +">");
			}
			pagingHtml.append("이전");
			pagingHtml.append("</a>");
		}
		pagingHtml.append("&nbsp;|&nbsp;");
		//페이지 번호.현재 페이지는 빨간색으로 강조하고 링크를 제거.(현재 블럭)
		for (int i = startPage; i <= endPage; i++) {
			if (i > totalPage) {// 16>15 ->더이상 출력하지 못하게 설정
				break;
			}
			if (i == currentPage) {//현재 선택된 페이지->red로 표시
				pagingHtml.append("&nbsp;<b> <font color='red'>");
				pagingHtml.append(i);
				pagingHtml.append("</font></b>");
			} else { //현재 선택된 페이지가 아니라면
				if(keyWord==null){//검색 미사용시
					pagingHtml.append("&nbsp;<a href='"+pageUrl+"?pageNum=");
				}else{
					pagingHtml.append("&nbsp;<a href='"+pageUrl+"?keyField="+keyField+"&keyWord="+keyWord+"&pageNum=");
				}
				pagingHtml.append(i);
				pagingHtml.append(addKey+"'>");
				pagingHtml.append(i);
				pagingHtml.append("</a>");
			}
			pagingHtml.append("&nbsp;");
		}
		pagingHtml.append("&nbsp;&nbsp;|&nbsp;&nbsp;");
		// 다음 block 페이지(10페이지 기준)
		if (totalPage - startPage >= blockPage) {
			if(keyWord==null){//검색 미사용시
				pagingHtml.append("<a href="+pageUrl+"?pageNum="+ (endPage + 1) + addKey +">");
			}else{ //검색어가 존재하는 경우
				pagingHtml.append("<a href="+pageUrl+"?keyField="+keyField+"&keyWord="+keyWord+"&pageNum="+ (endPage + 1) + addKey +">");
			}
			pagingHtml.append("다음");
			pagingHtml.append("</a>");
		}
	}
	public StringBuffer getPagingHtml() {
		return pagingHtml;
	}
	public int getStartCount() {
		return startCount;
	}
	public int getEndCount() {
		return endCount;
	}
}
