package com.edu.less17.institute.service;

public class ServiceProvider {
	private static final Service service = new ServiceImpl();

    private ServiceProvider() {}

    public static Service getService() {
    	return service;
    }
}
