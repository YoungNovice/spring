package com.ssm.chapter9.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * BeanPostProcessor 方法在每一个Bean的生命周期中都会执行
 */
public class BeanPostProcessorImpl implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("【" + bean.getClass().getSimpleName() + "】对象" + beanName + "开始实例化");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("【" + bean.getClass().getSimpleName() + "】对象" + beanName + "实例化完成");
		return bean;
	}

}