package kr.or.ddit.props.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.or.ddit.props.vo.PropertyVO;

public interface PropertyDAO {

	List<PropertyVO> selectProperties(@Param("propertyName") String propertyName);

	int insertProperty(PropertyVO propertyVO);

	int updateProperty(PropertyVO prop);

	int deleteProperty(PropertyVO prop);

}