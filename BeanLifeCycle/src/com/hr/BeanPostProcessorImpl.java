package com.hr;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorImpl implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object obj, String str)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("after: " + obj + ", " + str);
		return obj;
	}

	@Override
	public Object postProcessBeforeInitialization(Object obj, String str)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("before");
		return obj;
	}

}
