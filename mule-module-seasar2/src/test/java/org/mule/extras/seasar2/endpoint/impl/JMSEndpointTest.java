/*
 * Copyright (c) Osaka Gas Information System Research Institute Co., Ltd.
 * All rights reserved.  http://www.ogis-ri.co.jp/
 * 
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.extras.seasar2.endpoint.impl;

import org.mule.api.MuleContext;
import org.mule.api.endpoint.EndpointBuilder;
import org.mule.api.endpoint.InboundEndpoint;
import org.mule.context.DefaultMuleContextFactory;
import org.mule.extras.seasar2.endpoint.AbstractEndpoint;
import org.mule.transport.jms.filters.JmsPropertyFilter;
import org.mule.transport.jms.transformers.JMSMessageToObject;
import org.seasar.extension.unit.S2TestCase;

public class JMSEndpointTest extends S2TestCase {
	
	private DefaultMuleContextFactory factory_;
	private AbstractEndpoint endpointConfig_;
	
	public JMSEndpointTest(String name) 
	{
		super(name);
	}
	
	public void setUp() throws Exception
	{
		include("JMSEndpointTest.dicon");
	}
	
	public void testBuildEndpointBuilder() throws Exception 
	{
		MuleContext muleContext = factory_.createMuleContext();
		EndpointBuilder builder = endpointConfig_.buildEndpointBuilder(muleContext);
		InboundEndpoint inboundEndpoint = builder.buildInboundEndpoint();
		
		assertEquals("EndpointURI isn't correct"
				,"Foo"
				,inboundEndpoint.getEndpointURI().getAddress());
		
		assertEquals("UriScheme isn't correct"
				,"jms"
				,endpointConfig_.getUriScheme());
		
		String style 
			= (String)inboundEndpoint.getProperties().get("JMSReplyTo");
		
		assertEquals("Property isn't correct"
				,"Bar"
				,style);		
	}

}
