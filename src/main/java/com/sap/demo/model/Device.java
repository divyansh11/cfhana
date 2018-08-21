package com.sap.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="\"DEVICE\"")
public class Device {

	@Id
	@Column(name="\"DEVICEID\"")
	private String deviceid;	
	@Column(name="\"DEVICENAME\"")
	private String devicename;

	public Device() {
	}

	public Device(String deviceid, String devicename) {
		super();
		this.deviceid = deviceid;
		this.devicename = devicename;
	}

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public String getDevicename() {
		return devicename;
	}

	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}
	
	

}