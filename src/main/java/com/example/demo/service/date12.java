package com.example.demo.service;

import java.util.Date;

public class date12 {

	private Date date1;
	private Date date2;

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public date12(Date date1, Date date2) {
		super();
		this.date1 = date1;
		this.date2 = date2;
	}

	public date12() {
		super();
	}

	@Override
	public String toString() {
		return "date12 [date1=" + date1 + ", date2=" + date2 + "]";
	}

}
