package com.ssm.chapter9.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 * 实现了DsiposableBean接口 针对IOC 容器
 *
 * @author xuanyang
 */
@Component("disposableBean")
public class DisposableBeanImpl implements DisposableBean {

	@Override
	public void destroy() throws Exception {
		System.out.println("调用接口DisposableBean的destroy方法");
	}

}
