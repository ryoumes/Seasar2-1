package org.mule.extras.seasar2.config.impl;

import org.mule.extras.seasar2.config.TransactionConnector;
import org.mule.extras.seasar2.exception.S2MuleConfigurationException;
import org.mule.transport.jms.activemq.ActiveMQXAJmsConnector;

public class ActiveMQXAJmsConnectorConfig 
	extends ActiveMQJmsConnectorConfig implements TransactionConnector {
	
	/**
	 * @see org.mule.extras.seasar2.config.ConnectorConfig#getConnector()
	 */
	public Object buildComponent() {
		ActiveMQXAJmsConnector connector = new ActiveMQXAJmsConnector();
		if(brokerURL != null) {
			properties.put("brokerURL", brokerURL);
		} else {
			throw new S2MuleConfigurationException("ESML0002",new Object[]{"brokerUrl"});
		}
		//name��value��Map�^�ł���properties��bean�ɔ��f������
		populate(connector, properties);
		
		return connector;
	}
	
	public boolean isTransaction() {
		return true;
	}
}