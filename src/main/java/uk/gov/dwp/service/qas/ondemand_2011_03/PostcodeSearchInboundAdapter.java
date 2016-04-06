package uk.gov.dwp.service.qas.ondemand_2011_03;

import com.qas.ondemand_2011_03.QASearch;

public class PostcodeSearchInboundAdapter{

    /**
	 * @param search the search to process
	 */
	public String handleSearchRequest(QASearch search) {
		return search.getSearch();
	}


}
