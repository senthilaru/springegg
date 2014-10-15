package com.spsa.springegg.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spsa.springegg.domain.SPMetrics;

public class SPInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("SPSA - Pre Handle");
		SPMetrics metrics = new SPMetrics();
		metrics.setBrowser(request.getHeader("User-Agent"));
		metrics.setClientIp(request.getRemoteAddr());
		metrics.setResponseTime(System.currentTimeMillis());
		request.setAttribute("metrics", metrics);
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("SPSA - Post Handle:");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		System.out.println("SPSA - After Completion:" + ex);
		SPMetrics metrics = (SPMetrics)request.getAttribute("metrics");
		if(ex == null){
			metrics.setSuccess(true);
		}
		metrics.setResponseTime(System.currentTimeMillis() - metrics.getResponseTime());
		System.out.println("metrics:"+metrics);
		super.afterCompletion(request, response, handler, ex);
	}
	
	
	
}
