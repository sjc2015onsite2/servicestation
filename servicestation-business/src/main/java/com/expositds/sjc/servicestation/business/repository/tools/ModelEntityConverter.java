package com.expositds.sjc.servicestation.business.repository.tools;

import java.util.List;
import java.util.Map;

import com.expositds.sjc.servicestation.business.repository.entity.PartEntity;
import com.expositds.sjc.servicestation.business.repository.entity.ServiceEntity;
import com.expositds.sjc.servicestation.domain.model.Part;
import com.expositds.sjc.servicestation.domain.model.Service;

/**
 * Интерфейс содержит методы для восстановления объектов анимической модели в классы уровня persistance.
 * Конверация затрагивает только поля объектов не являющимися коллекциями.
 * 
 * @author Alexey Suslov
 *
 */
public interface ModelEntityConverter {
	
	Map<PartEntity, Integer> mapPartIntegerConvert(Map<Part, Integer> partMap);
	
	Map<ServiceEntity, Integer> mapServiceIntegerConverter(Map<Service, Integer> serviceMap);
	
	List<ServiceEntity> listServiceConverter(List<Service> servicelist);

}
