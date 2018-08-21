package com.sap.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sap.demo.exceptions.GatewayServicesException;
import com.sap.demo.model.Device;
import com.sap.demo.service.DeviceService;

@RestController
public class DeviceController {


	@Autowired
	private DeviceService deviceService;

	@RequestMapping("/devices")
	public List<Device> getallDevice() throws GatewayServicesException {
		return deviceService.getalldevices();

	}


	@RequestMapping(method = RequestMethod.POST, value = "/adddevices")
	public String addDevice(@RequestBody Device device)
			throws GatewayServicesException {		
		String resp = deviceService.addDevice(device);
		return resp;

	}


	@RequestMapping("/test/{id}")
	public List<Device> testNativeQuery(@PathVariable String id) {

	return deviceService.testNativeQuery(id);
	}
	
	@RequestMapping("/test2/{id}")
	public List<Device> testNativeQuery2(@PathVariable String id) {

	return deviceService.testNativeQuery(id);
	}
	

}
