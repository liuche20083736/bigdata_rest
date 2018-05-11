package com.bigdata.dao.hbase;

public class ZCHJCell {
	public String column;
	public long timestamp;
	public String value;

	public ZCHJCell() {
		
	}
	public ZCHJCell(String column,long timestamp,String value) {
		this.column=column;
		this.timestamp= timestamp;
		this.value=value;
	}
	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
