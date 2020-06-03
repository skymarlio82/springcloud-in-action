
package com.wiz.demo.sc.configclient.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wiz.demo.sc.configclient.remote.TokenRemote;

@Component
public class TokenRemoteHystrix implements TokenRemote {

	private final static Logger logger = LoggerFactory.getLogger(TokenRemoteHystrix.class);

	@Override
	public String validateToken(String token) {
		logger.info("==========>>>> Hystrix Callback Triggered <<<<==========");
		return "Failure";
	}
}