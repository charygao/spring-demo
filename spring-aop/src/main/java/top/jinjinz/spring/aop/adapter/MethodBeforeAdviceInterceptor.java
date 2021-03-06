package top.jinjinz.spring.aop.adapter;

import top.jinjinz.spring.aop.aspectj.AbstractAspectJAdvice;
import top.jinjinz.spring.aop.aspectj.AspectJAdvice;
import top.jinjinz.spring.aop.intercept.Joinpoint;
import top.jinjinz.spring.aop.intercept.MethodInterceptor;
import top.jinjinz.spring.aop.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * 拦截器-before
 * @author jinjin
 * @date 2019-04-19
 */
public class MethodBeforeAdviceInterceptor extends AbstractAspectJAdvice implements MethodInterceptor {
    private Joinpoint joinPoint;
    public MethodBeforeAdviceInterceptor(AspectJAdvice aspectJAdvice) {
        super(aspectJAdvice);
    }

    private void before(Method method,Object[] args,Object target) throws Throwable{
        super.invokeAdviceMethod(this.joinPoint,null,null);
    }
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        this.joinPoint = methodInvocation;
        before(methodInvocation.getMethod(), methodInvocation.getArguments(), methodInvocation.getThis());
        return methodInvocation.proceed();
    }
}
