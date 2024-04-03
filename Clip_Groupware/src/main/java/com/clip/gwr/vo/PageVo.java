package com.clip.gwr.vo;

public class PageVo {
	
	private int page;
	private int countList;
	private int totalCount;
	private int countPage;
	private int totalPage;
	private int stagePage;
	private int endPage;

	@Override
	public String toString() {
		return "PageVo [page=" + page + ", countList=" + countList + ", totalCount=" + totalCount + ", countPage="
				+ countPage + ", totalPage=" + totalPage + ", stagePage=" + stagePage + ", endPage=" + endPage + "]";
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		//현재페이지가 전체페이지값보다 클경우 현재페이지 = 전체페이지값
		if (totalPage < page) {
			page = totalPage;
		}
		this.page = page;
	}

	public int getCountList() {
		return countList;
	}

	public void setCountList(int countList) {
		this.countList = countList;
	}

	public int getCountPage() {
		return countPage;
	}

	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}

	public int getTotalCount() {
		return totalCount;
	}
	//ex) 총 게시글 : 100
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		//전체페이징 개수 = 전체 게시글 수/ 한페이지의 게시글수(설정해줘야함)
		int totalPageResult = totalCount / countList;
		//11.111.. = 99/5
		if (totalCount % countList > 0) {
			totalPageResult++;
		}
		this.totalPage = totalPageResult;
	}

	public int getStagePage() {
		return stagePage;
	}

	public void setStagePage(int stagePage) {
		int stagePageResult = ((page - 1) / countPage) * countPage + 1;

		this.stagePage = stagePageResult;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		int endPageResult = stagePage + countPage - 1;
		if (endPageResult > totalPage) {
			endPageResult = totalPage;
		}

		this.endPage = endPageResult;
	}
}
