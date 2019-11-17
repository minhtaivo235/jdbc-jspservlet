package com.vmtjavaweb.paging;

import com.vmtjavaweb.sort.Sorter;

public interface IPageble {
	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	Sorter getSorter();
}
