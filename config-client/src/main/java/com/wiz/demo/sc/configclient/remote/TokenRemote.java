
package com.wiz.demo.sc.configclient.remote;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wiz.demo.sc.configclient.fallback.TokenRemoteHystrix;

@FeignClient(name="USER-SERVICE", fallback=TokenRemoteHystrix.class)
public interface TokenRemote {

//	@RequestMapping(value="/user/token/validate")
//	String validateToken(@RequestParam(value="token") String token);

//	@RequestMapping(value="/user/token/validate", method=RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//	String validateToken(String token);

	@RequestMapping(value="/user/token/validate", method=RequestMethod.POST)
	String validateToken(Map<String, Object> inputs);
}