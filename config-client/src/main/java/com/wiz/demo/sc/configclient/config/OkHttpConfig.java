
package com.wiz.demo.sc.configclient.config;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wiz.demo.sc.configclient.interceptor.OkHttpLogInterceptor;

import feign.Feign;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;

@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class OkHttpConfig {

	@Bean
	public OkHttpClient okHttpClient() {
		return new OkHttpClient.Builder()
			.connectTimeout(30, TimeUnit.SECONDS)
			.readTimeout(30, TimeUnit.SECONDS)
			.writeTimeout(30, TimeUnit.SECONDS)
			.retryOnConnectionFailure(true)
			.connectionPool(new ConnectionPool(10, 5L, TimeUnit.MINUTES))
			.addInterceptor(new OkHttpLogInterceptor())
			.build();
	}
}