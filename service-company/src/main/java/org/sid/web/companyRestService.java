package org.sid.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@RestController
public class companyRestService {
	@Value("${xParam}")
	private int xParam;
	
	@Value("${yParam}")
	private int yParam;
	
	@Value("${me}")
	private String me;
	@GetMapping("/myConf")
	public Map<String,Object> myConf(){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("xParam", xParam);
		map.put("yParam", yParam);
		map.put("me", me);
		map.put("thred", Thread.currentThread().getName());
		
		return map;
	}
	

}
