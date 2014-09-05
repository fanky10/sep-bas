package com.genfersco.sepbas.configuration;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import com.genfersco.sepbas.app.services.ServicesManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/config/dispatcher-servlet.xml",
		"classpath:/dataAccessContext.xml" })
public class ResourceBoundleMessageSourceTest extends TestCase {
	@Resource
	private String homeMessage;
	@Autowired
	private ServicesManager servicesManager;
	
	@Test
	public void getMessageTest(){
		assertTrue(StringUtils.hasText(homeMessage));
	}
	
	@Test
	public void testServicesManager(){
		assertFalse(servicesManager==null);
	}
}