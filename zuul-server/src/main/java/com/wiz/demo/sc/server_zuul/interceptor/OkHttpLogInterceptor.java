
package com.wiz.demo.sc.server_zuul.interceptor;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Response;

@Slf4j
public class OkHttpLogInterceptor implements Interceptor {

	@Override
	public Response intercept(Chain chain) throws IOException {
		log.info("OkHttpUrl := " + chain.request().url());
		return chain.proceed(chain.request());
	}
}