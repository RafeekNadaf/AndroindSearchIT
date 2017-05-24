package com.searchIt.Vo;

import java.util.ArrayList;


public class Services {
	private Long service_provider_id;			
	private String service_provider_name;
	private String insert_date;
	private String update_date;	
	private int is_active;
	private int flag;
	private ArrayList<ProviderDetails> providerDetails;
	
	
	public Long getService_provider_id() {
		return service_provider_id;
	}
	public void setService_provider_id(Long service_provider_id) {
		this.service_provider_id = service_provider_id;
	}
	public String getService_provider_name() {
		return service_provider_name;
	}
	public void setService_provider_name(String service_provider_name) {
		this.service_provider_name = service_provider_name;
	}
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public int getIs_active() {
		return is_active;
	}
	public void setIs_active(int is_active) {
		this.is_active = is_active;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	public ArrayList<ProviderDetails> getProviderDetails() {
		return providerDetails;
	}
	public void setProviderDetails(ArrayList<ProviderDetails> providerDetails) {
		this.providerDetails = providerDetails;
	}
	
	@Override
	public String toString() {
		return "Services [service_provider_id=" + service_provider_id
				+ ", service_provider_name=" + service_provider_name
				+ ", insert_date=" + insert_date + ", update_date="
				+ update_date + ", is_active=" + is_active + ", flag=" + flag
				+ ", providerDetails=" + providerDetails + "]";
	}
	
	
	
}
