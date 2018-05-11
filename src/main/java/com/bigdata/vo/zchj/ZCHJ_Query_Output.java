package com.bigdata.vo.zchj;

import java.util.ArrayList;
import java.util.List;

import com.bigdata.dao.hbase.ZCHJRow;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ZCHJ_Query_Output {

	/*
	 * { "Row": [{ "key": "MTExMQ==", "Cell": [{ "column":
	 * "aW1hZ2VieXRlczpieXRlcw==", "timestamp": 1525227755270, "$": "Qk04B"
	 * 
	 * }] }] }
	 * 
	 * { "row": [{ "key": "MTExMQ==", "cell": [{ "column":
	 * "aW1hZ2VieXRlczpieXRlcw==", "timestamp": 1525227755270, "value": "Qk04B"
	 * 
	 * }] }] }
	 * 
	 */

	public List<ZCHJRow> row;

	public List<ZCHJRow> getRow() {
		return row;
	}

	public void setRow(List<ZCHJRow> row) {
		this.row = row;
	}

	

}
