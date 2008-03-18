package org.mule.extras.seasar2.sender.interceptor;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;
import org.mule.extras.seasar2.sender.S2MuleSender;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;
import org.seasar.framework.util.MethodUtil;

/**
 * S2Muleの同期通信を行うときのインターセプタです
 * 
 * @author Saito_Shinya@ogis-ri.co.jp
 */
public class MethodInvocationInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -9223020020060206825L;
	
	/** S2MuleSender */
	private S2MuleSender sender;

	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		Method method = methodInvocation.getMethod();
		if(MethodUtil.isAbstract(method)) {
			Object payload = methodInvocation.getArguments();
			String methodName = method.getName();
			sender.setProperty("method", methodName);
			return sender.send(payload);
		}
		return methodInvocation.proceed();
	}
	
	public S2MuleSender getSender() {
		return sender;
	}

	public void setSender(S2MuleSender sender) {
		this.sender = sender;
	}

}
