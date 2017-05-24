package com.searchIt.Vo;

import java.io.Serializable;
import java.util.List;

public class ProviderDetails implements Serializable{
	
	private static final long serialVersionUID = -2531191777986249180L;
	private Long provider_id;		
	private Long service_provider_id;	
	private Long user_detail_id;
	private String user_name;	
	private String user_phone_no;
	private String user_email;
	private int is_service_provider;
	private String provider_address;
	private String provider_password;	
	private String provider_district;
	private String provider_area;
	private int provider_pincode;
	private int is_active;
	private String insert_date;
	private String update_date;
	private int flag;
	private List<Long> serviceid;
	
	public Long getService_provider_id() {
		return service_provider_id;
	}
	public void setService_provider_id(Long service_provider_id) {
		this.service_provider_id = service_provider_id;
	}
	
	public Long getProvider_id() {
		return provider_id;
	}
	public void setProvider_id(Long provider_id) {
		this.provider_id = provider_id;
	}
	
	public String getProvider_address() {
		return provider_address;
	}
	public void setProvider_address(String provider_address) {
		this.provider_address = provider_address;
	}
	public String getProvider_password() {
		return provider_password;
	}
	public void setProvider_password(String provider_password) {
		this.provider_password = provider_password;
	}
	public String getProvider_district() {
		return provider_district;
	}
	public void setProvider_district(String provider_district) {
		this.provider_district = provider_district;
	}
	public String getProvider_area() {
		return provider_area;
	}
	public void setProvider_area(String provider_area) {
		this.provider_area = provider_area;
	}
	public int getProvider_pincode() {
		return provider_pincode;
	}
	public void setProvider_pincode(int provider_pincode) {
		this.provider_pincode = provider_pincode;
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
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone_no() {
		return user_phone_no;
	}
	public void setUser_phone_no(String user_phone_no) {
		this.user_phone_no = user_phone_no;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public int getIs_service_provider() {
		return is_service_provider;
	}
	public void setIs_service_provider(int is_service_provider) {
		this.is_service_provider = is_service_provider;
	}
	
	public List<Long> getServiceid() {
		return serviceid;
	}
	public void setServiceid(List<Long> serviceid) {
		this.serviceid = serviceid;
	}
	public Long getUser_detail_id() {
		return user_detail_id;
	}
	public void setUser_detail_id(Long user_detail_id) {
		this.user_detail_id = user_detail_id;
	}
	@Override
	public String toString() {
		return "ProviderDetails [provider_id=" + provider_id
				+ ", service_provider_id=" + service_provider_id
				+ ", user_detail_id=" + user_detail_id + ", user_name="
				+ user_name + ", user_phone_no=" + user_phone_no
				+ ", user_email=" + user_email + ", is_service_provider="
				+ is_service_provider + ", provider_address="
				+ provider_address + ", provider_password=" + provider_password
				+ ", provider_district=" + provider_district
				+ ", provider_area=" + provider_area + ", provider_pincode="
				+ provider_pincode + ", is_active=" + is_active
				+ ", insert_date=" + insert_date + ", update_date="
				+ update_date + ", flag=" + flag + ", serviceid=" + serviceid
				+ "]";
	}
	
	
}
