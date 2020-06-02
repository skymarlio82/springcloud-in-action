
package com.wiz.demo.sc.server_zuul.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wiz.demo.sc.server_zuul.fallback.TokenRemoteHystrix;

@FeignClient(name="USER-SERVICE", fallback=TokenRemoteHystrix.class)
public interface TokenRemote {

	@RequestMapping(value="/user/token/check")
	String checkToken(@RequestParam String token);
}