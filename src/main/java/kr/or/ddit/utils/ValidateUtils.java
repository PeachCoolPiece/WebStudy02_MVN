package kr.or.ddit.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;

import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.vo.BuyerVO;

public class ValidateUtils {
	private static Validator validator;
	static {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator =  factory.getValidator();
	}
	public static<T> boolean validate(T target,Map<String, List<String>> errors, Class<?>...groupHints){
		Set<ConstraintViolation<T>> violations = validator.validate(target,groupHints);
		boolean valid = violations.isEmpty();
		if( ! valid) {
			for( ConstraintViolation<T> single : violations) {
				String propertyName =  single.getPropertyPath().toString();
				String message =  single.getMessage();
				List<String> already =  errors.get(propertyName);
				if(already == null) {
					already = new ArrayList<>();
				}
				already.add(message);
				errors.put(propertyName,already);
			}
		}
		return valid;
	}
}
