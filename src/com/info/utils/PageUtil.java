package com.info.utils;

/**
 * ��װ��ҳ��Ϣ��ʵ��
 * 
 * @param pageNo
 *            ��ǰ�ǵڼ�ҳ
 * @param allPage
 *            ��ҳ��
 * @param pageNum
 *            ÿҳ������¼
 * @param allRecord
 *            �ܼ�¼��
 * @param prePage
 *            ��һҳ
 * @param nextpage
 *            ��һҳ
 */
public class PageUtil {
	private int pageNow = 1;
	private int allPage = 1;
	private int allRecord = 1;
	private int pageSize = 12;
	private int skipCount;

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getAllPage() {
		allPage = allRecord%pageSize==0?allRecord/pageSize:allRecord/pageSize+1;
		return allPage;
	}

	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}


	public int getAllRecord() {
		return allRecord;
	}

	public void setAllRecord(int allRecord) {
		this.allRecord = allRecord;
	}

	public int getPrePage() {
		if (this.getPageNow() <= 1) {
			return 1;
		} else {
			return this.getPageNow() - 1;
		}

	}

	public int getNextpage() {
		if (this.getPageNow() >= this.getAllPage()) {
			return this.getAllPage();
		} else {
			return this.getPageNow() + 1;
		}

	}
	//getter & setter ~~~~~~~~~~~~~~~~~~~
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getSkipCount() {
		return skipCount;
	}

	public void setSkipCount(int skipCount) {
		this.skipCount = skipCount;
	}

}
