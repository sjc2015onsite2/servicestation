package com.expositds.sjc.servicestation.business.service.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.business.repository.entity.ClientNotificationEntity;
import com.expositds.sjc.servicestation.domain.model.ClientNotification;

/**
 * @author Alexey Suslov
 *
 */
@Component
public class ClientNotificationEntityModelConverter implements Converter<ClientNotificationEntity, ClientNotification> {

	@Override
	public ClientNotification convert(ClientNotificationEntity source) {
		ClientNotification clientNotification = new ClientNotification(source.getMessage());
		clientNotification.setClientNotificationId(source.getClientNotificationId());
		return clientNotification;
	}

}
