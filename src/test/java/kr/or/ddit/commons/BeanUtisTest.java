package kr.or.ddit.commons;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;

import kr.or.ddit.vo.MemberVO;

public class BeanUtisTest {
	
	@Test
	public void timestampTest() throws IllegalAccessException, InvocationTargetException {
		Map<String, String> prameterMap = new HashMap<>();
		MemberVO member = new MemberVO();
		prameterMap.put("memBir", "2023-03-16T17:46");
		prameterMap.put("memMemorialday", "2023-03-08");
		
		DateConverter converter = new DateConverter();
		converter.setPattern("yyyy-MM-dd'T'HH:mm");
		ConvertUtils.register(converter, Timestamp.class);
		BeanUtils.populate(member, prameterMap);
	
		System.out.println(member.getMemBir());
		System.out.println(member.getMemMemorialday());
	}
}
