
package com.wiz.demo.sc.server_zuul.filter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.wiz.demo.sc.server_zuul.remote.TokenRemote;

public class TokenFilter extends ZuulFilter {

	private final static Logger logger = LoggerFactory.getLogger(TokenFilter.class);

	private List<String> whiteList = null;
	private TokenRemote tokenRemote = null;

	public TokenFilter(List<String> whiteList, TokenRemote tokenRemote) {
		super();
		this.whiteList = whiteList;
		this.tokenRemote = tokenRemote;
	}

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
		logger.info("===> TokenFilter {},{},{}", method, url, whiteList);
		boolean isWhite = whiteList.stream().anyMatch(elem -> url.endsWith(elem));
		String token = request.getHeader("token");
		if (isWhite || (!StringUtils.isEmpty(token) && tokenRemote.checkToken(token).equals("Success"))) {
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