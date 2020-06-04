
package com.wiz.demo.sc.server_zuul.fallback;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wiz.demo.sc.server_zuul.remote.TokenRemote;

@Component
public class TokenRemoteHystrix implements TokenRemote {

	private final static Logger logger = LoggerFactory.getLogger(TokenRemoteHystrix.class);

//	@Override
//	public String validateToken(String token) {
//		logger.info("==========>>>> Hystrix Callback Triggered <<<<==========");
//		return "Failure";
//	}

	@Override
	public String validateToken(Map<String, Object> inputs) {
		logger.info("==========>>>> Hystrix Callback Triggered <<<<==========");
		return "Failure";
	}
}