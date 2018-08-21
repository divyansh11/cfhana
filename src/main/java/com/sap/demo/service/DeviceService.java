package com.sap.demo.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.demo.exceptions.GatewayServicesException;
import com.sap.demo.model.Device;
import com.sap.demo.repository.DeviceRepo;

@Service
public class DeviceService {

	@Autowired
	private DeviceRepo devicerepo;

	public List<Device> getalldevices() throws GatewayServicesException {

		List<Device> devices = new ArrayList<>();
		try {
			devicerepo.findAll().forEach(devices::add);
		} catch (Exception e) {
			throw new GatewayServicesException(e.getMessage());
		}

		return devices;

	}


	public String addDevice(Device device) throws GatewayServicesException {
		try {
			devicerepo.save(device);

		} catch (Exception e) {

			throw new GatewayServicesException(e.getMessage());
		}
			return "Success";

		}
	
	public List<Device> testNativeQuery(String deviceGuid)
	{
		
		return devicerepo.findByDeviceid(deviceGuid);
		
	}
	
	
	public List<Device> testNativeQuery2(String deviceGuid) throws GatewayServicesException
	{
		
		List<Device> devices = new ArrayList<>();
		try {
			devicerepo.findByDeviceid(deviceGuid).forEach(devices::add);
		} catch (Exception e) {
			throw new GatewayServicesException(e.getMessage());
		}

		return devices;
		
	}
	
	

	}


