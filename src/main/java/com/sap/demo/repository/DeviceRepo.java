package com.sap.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sap.demo.model.Device;

public interface DeviceRepo extends JpaRepository<Device, String> {

	
	@Query(value ="SELECT * FROM \"DEVICE\" d WHERE d.\"DEVICEID\" = :deviceid",nativeQuery = true)
	 List<Device> findByDeviceid(@Param("deviceid") String deviceid);
	
	

}
