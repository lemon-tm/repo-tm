package com.lemon.filter;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.lemon.entity.LemonUser;
import com.lemon.service.LemonUserService;

/**
 * 自定义DB Realm
 * 
 */
public class LemonAuthorizingRealm extends AuthorizingRealm {

	/**
	 * 登录认证
	 * 
	 * 1、编写表单：表单action和username、password的参数都是什么？
	 * 回答：提交到你想提交的地方，username、password参数名称都任意
	 * 2、例如，提交到了一个SpringMVC的handler：
	 * 1）获取用户名、密码
	 * 2）
	 * Subject currentUser = SecurityUtils.getSubject（）；
	 * UsernamePasswordToken token = new UsernamePasswordToken(username, password);
	 * currentUser.login(token) ;
	 * 3.当Subject调用login方法时，即会出发当前的doGetAuthenticationInfo方法，且把
	 * UsernamePasswordToken对象传入，然后在该方法中执行真正的认证：访问数据库进行比对；
	 * 1）获取用户名密码
	 * 2）
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		
		LemonUser user = lemonUserService.findByUsername(token.getUsername());
		
		if (user != null) {
			//UnifiedUser unifiedUser = unifiedUserMng.findById(user.getId());
			String principal = user.getUsername() ;
			String credentials = user.getPassword() ;
			String realmName = getName() ;
			
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, realmName) ;
			
			return info ;
		} else {
			return null;
		}
	}
//@PostConstruct，相当于bean节点的init-method配置
//	@PostConstruct
//	public void setCredentialMatcher(){
//		HashedCredentialsMatcher cher = new HashedCredentialsMatcher() ;
//		cher.setHashAlgorithmName("MD5") ;
//		cher.setHashIterations(1024) ;
//		setCredentialsMatcher(cher) ;
//	}
	/**
	 * 授权
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();
		String username = (String) principals.getPrimaryPrincipal();
		LemonUser user = lemonUserService.findByUsername(username);
//		CmsSite site=CmsThreadVariable.getSite();
//		
//		if (user != null) {
//			Set<String> viewPermissionSet=new HashSet<String>();
//			Set<String> perms = user.getPerms(site.getId(),viewPermissionSet);
//			if (!CollectionUtils.isEmpty(perms)) {
//				// 权限加入AuthorizationInfo认证对象
//				auth.setStringPermissions(perms);
//			}
//		}
		return auth;
	}
	
	public void removeUserAuthorizationInfoCache(String username){
		  SimplePrincipalCollection pc = new SimplePrincipalCollection();
		  pc.add(username, super.getName()); 
		  super.clearCachedAuthorizationInfo(pc);
	}
	
	
	protected LemonUserService lemonUserService ;
	
	@Autowired
	public void setLemonUserService(LemonUserService lemonUserService) {
		this.lemonUserService = lemonUserService;
	}

//	protected UnifiedUserMng unifiedUserMng;

//	@Autowired
//	public void setUnifiedUserMng(UnifiedUserMng unifiedUserMng) {
//		this.unifiedUserMng = unifiedUserMng;
//	}

}
