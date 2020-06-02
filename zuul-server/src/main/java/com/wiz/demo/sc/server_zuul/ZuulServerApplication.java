
package com.wiz.demo.sc.server_zuul;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.wiz.demo.sc.server_zuul.filter.TokenFilter;
import com.wiz.demo.sc.server_zuul.remote.TokenRemote;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServerApplication.class, args);
	}

	@Value("${url-whitelist}")
	private List<String> whiteList = null;

	@Autowired
	private TokenRemote tokenRemote = null;

	@Bean
	public TokenFilter tokenFilter() {
		return new TokenFilter(whiteList, tokenRemote);
	}
}