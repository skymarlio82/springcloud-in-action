
package com.wiz.demo.sc.server_zuul.filter;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.wiz.demo.sc.server_zuul.remote.TokenRemote;

@Component
public class TokenFilter extends ZuulFilter {

	private final static Logger logger = LoggerFactory.getLogger(TokenFilter.class);

	@Value("${whitelist}")
	private String urlList = null;

	@Autowired
	private TokenRemote tokenRemote = null;

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String method = request.getMethod();
		String url = request.getRequestURL().toString();
		List<String> whiteList = Arrays.asList(urlList.split(","));
		logger.info("===> TokenFilter {},{},{}", method, url, whiteList);
		boolean isWhite = whiteList.stream().anyMatch(elem -> url.endsWith(elem));
		String token = request.getHeader("token");
		logger.info("===> token: {}", token);
		if (isWhite || (!StringUtils.isEmpty(token) && tokenRemote.validateToken(token).equals("Success"))) {
			ctx.setSendZuulResponse(true);
			ctx.setResponseStatusCode(200);
			ctx.set("isSuccess", true);
			return null;
		} else {
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(400);
			ctx.setResponseBody("Token incorrect");
			ctx.set("isSuccess", false);
			return null;
		}
	}
}