package kr.or.ddit.utils;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import kr.or.ddit.vo.MemberVO;

public class PopulationUtils {
	
	/**
	 * String 타입데이터를 TimeStamp 반환할때 ('yyyy-MM-dd'T'HH:mm")을 사용
	 * @param bean
	 * @param map
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	
	public static void populate(Object bean, Map<String, ? extends Object> map) throws IllegalAccessException, InvocationTargetException {
		DateConverter converter = new DateConverter();
		converter.setPattern("yyyy-MM-dd'T'HH:mm");
	
		ConvertUtils.register(converter, Timestamp.class);
		BeanUtils.populate(bean, map);
	}
}
