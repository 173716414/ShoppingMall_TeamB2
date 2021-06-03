package com.entity;

public class PageModel {
	
	private int sumCount;
	private int everyPageCount;
	private int currentPage;
	private int sumPageCount;
	private final int INDEXPAGE = 1;
	private int nextPage;
	private int upPage;
	private int lastPage;
	public int getCurrentPage() {
		return currentPage;
	}
	public int getEveryPageCount() {
		return everyPageCount;
	}
	public int getINDEXPAGE() {
		return INDEXPAGE;
	}
	public int getLastPage() {
		return lastPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public int getSumCount() {
		return sumCount;
	}
	//¼ÆËã×ÜÒ³Êý
	public int getSumPageCount() {
		if(sumCount != 0){
			if(sumCount%everyPageCount == 0){
				sumPageCount = sumCount/everyPageCount;
			}		
			else{
				sumPageCount = (sumCount/everyPageCount)+1; 
			}
		}
		else{
			sumPageCount = 1;
		}
		return sumPageCount;
	}
	public int getUpPage() {
		return upPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public void setEveryPageCount(int everyPageCount) {
		this.everyPageCount = everyPageCount;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public void setSumCount(int sumCount) {
		this.sumCount = sumCount;
	}
	public void setUpPage(int upPage) {
		this.upPage = upPage;
	}
}
