package com.auth.util;

import java.util.ArrayList;
import java.util.List;

public class Page {  
    private int pageSize=1;            //ҳ��С  
    private int pageIndex=0;           //��ǰҳ��  
    private int totalPageCount=0;      //��ҳ��  
    private int record=0;              //��¼����  
    private Integer nextPage;          //��һҳ  
    private Integer prePage;           //��һҳ  
    private List<?> resultList;     
      
  
   
    public List<?> getResultList() {
		return resultList;
	}

	public void setResultList(List<?> resultList) {
		this.resultList = resultList;
	}

	//�õ���ʼ��¼��  
    public int getSartRow(){  
        return (pageIndex-1)*pageSize;  
    }  
      
    //�õ������¼��  
    public int getEndRow(){  
        return pageSize;  
    }  
  
    public int getPageSize() {  
        return pageSize;  
    }  
  
    public void setPageSize(int pageSize) {  
        this.pageSize = pageSize;  
    }  
  
    public int getPageIndex() {  
        return pageIndex;  
    }  
  
    //�õ���ǰҳ  
    public void setPageIndex(int pageIndex) {  
        this.pageIndex = pageIndex;  
        //��һҳ  
        setNextPage();  
        //��һҳ  
        setPrePage();  
    }  
  
    public int getTotalPageCount() {  
        return totalPageCount;  
    }  
  
    //��ҳ��  
    public void setTotalPageCount() {  
        int totalP = record % getPageSize() == 0 ? record / getPageSize() :  
            record/ getPageSize() + 1;  
        this.totalPageCount = totalP;  
    }  
  
    public int getRecord() {  
        return record;  
    }  
      
    //�ܼ�¼��  
    public void setRecord(int record) {  
        this.record = record;  
        //������ҳ��  
        setTotalPageCount();  
    }  
  
    public Integer getNextPage() {  
        return nextPage;  
    }  
  
    //������һҳ  
    public void setNextPage() {  
        this.nextPage = this.pageIndex+1;  
          
    }  
  
    public Integer getPrePage() {  
        return prePage;  
    }  
  
    //������һҳ  
    public void setPrePage() {  
        this.prePage =this.pageIndex-1;  
        if(this.prePage<1){  
            this.prePage=1;  
        }  
    }  
      
      
  
}  