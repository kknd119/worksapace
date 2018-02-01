package com.spring81.bbs;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring81.bbs.common.PagingHelper;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPageHelper {
    
   
   
    
    @Test
    public void test01_paging() {
        
        //총페이지수 :1000
        //현재 페이지 :1
        //페이지당 레코드 수:10
        //블락당 출력할 페이지수:10
        
        int totalRecord=1000;
        int curPage = 1;
        
        PagingHelper paging = new PagingHelper(totalRecord, curPage);
        
        //ListNO
        assertEquals(paging.getListNo(),1000);
        
        //totlapage
        assertEquals(paging.getTotalPage(),100);
        
        //firstPage
        assertEquals(paging.getFirstPage(),1);
        
        //prevLink
        assertEquals(paging.getPrevLink(), 0);
        //lastPage
        assertEquals(paging.getLastPage(),10);
        
        //totalfirstpage
        assertEquals(paging.getTotalFirstPage(), 1);
        
        //nextLink
        assertEquals(paging.getNextLink(),11);
        //totlaLastLink
        assertEquals(paging.getTotalLastPage(),100);
        
        //endRecord
        assertEquals(paging.getEndRecord(), 10);
        
        //startRecord
        assertEquals(paging.getStartRecord(),1);
        
        //pageLinks
        assertArrayEquals(paging.getPageLinks(),new int[] {1,2,3,4,5,6,7,8,9,10} );
        
    }
    @Test
    public void test02_paging() {
        //총레코드수 :1000
        //현재페이지 :26
        //페이지당 출력 레코드수(rowPerBlock):20
        //블락당페이지 갯수(pagesPerBlock):10
        
        int totalRecord=1000;
        int curPage = 26;
        
        PagingHelper paging = new PagingHelper(totalRecord, curPage,20,15);
        
        //ListNO
        assertEquals(paging.getListNo(),500); //1000- 20*(26-1)+1 
        
        //totlapage
        assertEquals(paging.getTotalPage(),50);// 1000/20
        
        //페이지 그룹 : 1~15, 16~30,
        //firstPage
        assertEquals(paging.getFirstPage(),16);//16~30
        
        //prevLink
        assertEquals(paging.getPrevLink(), 15);//16-1
        //lastPage
        assertEquals(paging.getLastPage(),30);
        
        //totalfirstpage
        assertEquals(paging.getTotalFirstPage(), 1);
        
        //nextLink
        assertEquals(paging.getNextLink(),31);//30+1
        //totlaLastLink
        assertEquals(paging.getTotalLastPage(),50);//1000/20=50
        
        //endRecord
        assertEquals(paging.getEndRecord(), 520);//20*(26-1)+1+20
        
        //startRecord
        assertEquals(paging.getStartRecord(),501);//20*(26-1)+1
        
        //pageLinks
        assertArrayEquals(paging.getPageLinks(),new int[] {16,17,18,19,20,21,22,23,24,25,26,27,28,29,30} );
        
    }
}
