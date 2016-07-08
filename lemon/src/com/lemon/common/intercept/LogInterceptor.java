package com.lemon.common.intercept;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lemon.entity.ForbiddenIp;
import com.lemon.entity.LemonUser;
import com.lemon.entity.VisitorRecord;
import com.lemon.service.ForbiddenIpService;
import com.lemon.service.VisitorRecordService;
/**
 * 通过这个拦截器，记录匿名登录的用户信息 ，用于统计
 * 
 * 
preHandle：在执行action里面的处理逻辑之前执行，它返回的是boolean，这里如果我们返回true在接着执行postHandle和afterCompletion，如果我们返回false则中断执行。
 
postHandle：在执行action里面的逻辑后返回视图之前执行。
 
afterCompletion：在action返回视图后执行。
 
HandlerInterceptorAdapter适配器是Spring MVC为了方便我们使用HandlerInterceptor而对HandlerInterceptor 的默认实现，里面的3个方法没有做任何处理，在preHandle方法直接返回true，这样我们继承HandlerInterceptorAdapter后只需要实现3个方法中我们需要的方法即可，而不像继承HandlerInterceptor一样不管是否需要3个方法都要实现。
 
当然借助于HandlerInterceptor我们可以实现很多其它功能，比如日志记录、请求处理时间分析等，权限验证只是其中之一
*/
public class LogInterceptor extends HandlerInterceptorAdapter {
	@Resource
	private VisitorRecordService visitorRecordService ;
	@Resource
	private ForbiddenIpService forbiddenIpService ;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
//		  String requestUrl = request.getRequestURL().toString();//得到请求的URL地址
//        String requestUri = request.getRequestURI();//得到请求的资源
//        String queryString = request.getQueryString();//得到请求的URL地址中附带的参数
//        
//        String remoteHost = request.getRemoteHost();
//        
//        
//        String method = request.getMethod();//得到请求URL地址时使用的方法
//        String localAddr = request.getLocalAddr();//获取WEB服务器的IP地址
//        String localName = request.getLocalName();//获取WEB服务器的主机名

		String remoteAddr = getIpAddr(request) ;//得到来访者的IP地址
		String referer = request.getHeader("Referer") ;//来源页面
        String browser = request.getHeader("User-Agent"); 
        String requestUrl = request.getRequestURL().toString();//得到请求的URL地址
        
        List<ForbiddenIp> list = forbiddenIpService.getAllList() ;
        for(ForbiddenIp b:list){
        	if(remoteAddr.equals(b.getId())){
        		return false ;
        	}
        }
        VisitorRecord vr = new VisitorRecord() ;
        LemonUser user =  (LemonUser) request.getSession().getAttribute("user");  
        if(null!=user){
        	vr.setUserId(user.getId()) ;
        }
        vr.setIp(remoteAddr) ;
        vr.setReferer(referer) ;
        vr.setBrowser(browser) ;
        vr.setVisitTime(new Date()) ;
        vr.setRequestUrl(requestUrl) ;
        
        visitorRecordService.save(vr) ;
        return true ;
	}
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		super.postHandle(request, response, handler, modelAndView);
	}
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
	
	public String getIpAddr(HttpServletRequest request){
		String ip= request.getHeader("x-forwarded-for") ;
		if(null==ip || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getHeader("Proxy-Client-Ip") ;
		}
		if(null==ip || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getHeader("WL-Proxy-Client-IP") ;
		}
		if(null==ip || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getRemoteAddr() ;
		}
		return ip ;
	}
	

}
