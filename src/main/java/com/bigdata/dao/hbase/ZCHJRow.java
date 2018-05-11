package com.bigdata.dao.hbase;
import java.util.List;

public class ZCHJRow {
		public String key;
		public List<ZCHJCell> cell;

		public ZCHJRow(){
			
		}
		public ZCHJRow(String key,List<ZCHJCell> cell){
			this.key=key;
			this.cell=cell;
		}
		
		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public List<ZCHJCell> getCell() {
			return cell;
		}

		public void setCell(List<ZCHJCell> cell) {
			this.cell = cell;
		}

		

	}