package com.expositds.sjc.servicestation.buisness.repository.tools;

/**
 * Интерфейс содержит методы для конвертации объектов класса уровня persistance в объеекты анимической модели.
 * Конверация затрагивает только поля объектов не являющимися коллекциями.
 * 
 * @author Alexey Suslov
 *
 */
public interface BasicEntityModelObjectConverter {
	
	Object convert(Object entity, Class<?> clazz);

}
