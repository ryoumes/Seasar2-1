package org.mule.extras.seasar2.sender.jms.activemq;

import org.mule.extras.seasar2.sender.S2MuleSender;
import org.seasar.extension.unit.S2TestCase;

public class SendWithNoPropertyTest extends S2TestCase {
	
	private S2MuleSender sender_;
	
	public void setUp() throws Exception {
		include("SendWithNoPropertyTest.dicon");
	}
	
	public void testDispatch() throws Exception {
		sender_.dispatch("SendWithNoProperty : OK");
	}

}