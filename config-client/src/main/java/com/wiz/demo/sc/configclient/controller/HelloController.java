
package com.wiz.demo.sc.configclient.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiz.demo.sc.configclient.remote.TokenRemote;

@RestController
@RefreshScope
public class HelloController {

	@Value("${hello}")
	private String hello;

	@Autowired
	private TokenRemote tokenRemote = null;

	@RequestMapping("/hello")
	public String from(HttpServletRequest req) {
		String token = req.getHeader("token");
		return this.hello + ", " + tokenRemote.validateToken(token);
	}
}