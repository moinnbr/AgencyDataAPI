package com.example.agencydataapi.controller;
import com.example.agencydataapi.model.AgencyRefData;
import com.example.agencydataapi.service.AgencyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/api/agencydata")
public class AgencyDataApiController {
@Autowired
private AgencyDataService agencyDataService;
@GetMapping("/fetch-and-save")
public String fetchAndSaveAgencyRefData() {
List<AgencyRefData> agencyRefDataList =
agencyDataService.fetchAndTransformAgencyData();
agencyDataService.saveAgencyRefData(agencyRefDataList);
return "Agency reference data saved successfully.";
}
@GetMapping("/ref-data")
public List<AgencyRefData> getAgencyRefData() {
return agencyDataService.fetchAndTransformAgencyData();
}
}