
package com.wiz.demo.sc.configclient.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wiz.demo.sc.configclient.fallback.TokenRemoteHystrix;

@FeignClient(name="USER-SERVICE", fallback=TokenRemoteHystrix.class)
public interface TokenRemote {

	@RequestMapping(value="/user/token/validate")
	String validateToken(@RequestParam(value="token") String token);
}