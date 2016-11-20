package com.lb.parrot.pay.result;

import java.util.ArrayList;
import java.util.List;

import com.lb.parrot.pay.result.pojo.ToServerPayResult;

public class DownloadBillResult implements ToServerPayResult {

	private static final long serialVersionUID = 1L;

	private List<BillField> dataFieldList = new ArrayList<BillField>();

	private BillField totalField;

	public List<BillField> getDataFieldList() {
		return dataFieldList;
	}

	public void setDataFieldList(List<BillField> dataFieldList) {
		this.dataFieldList = dataFieldList;
	}

	public BillField getTotalField() {
		return totalField;
	}

	public void setTotalField(BillField totalField) {
		this.totalField = totalField;
	}

	@Override
	public String toString() {
		return "DownloadBillResult [dataFieldList=" + dataFieldList
				+ ", totalField=" + totalField + "]";
	}

}
