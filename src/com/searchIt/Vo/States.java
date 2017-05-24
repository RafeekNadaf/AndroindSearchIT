package com.searchIt.Vo;

public class States {
	
	private Long state_id;		
	private String state_name;	
	private int is_active;
	private String  insert_date;
	private String stringupdate_dat;
	
	public Long getState_id() {
		return state_id;
	}
	public void setState_id(Long state_id) {
		this.state_id = state_id;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	public int getIs_active() {
		return is_active;
	}
	public void setIs_active(int is_active) {
		this.is_active = is_active;
	}
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	public String getStringupdate_dat() {
		return stringupdate_dat;
	}
	public void setStringupdate_dat(String stringupdate_dat) {
		this.stringupdate_dat = stringupdate_dat;
	}
	
	

}
