package kr.or.ddit.schema.service;

import java.util.List;

import kr.or.ddit.vo.ColumnSchemaVO;
import kr.or.ddit.vo.TableSchemaVO;

public interface SchemaService {

	/**
	 * 테이블이 존재하지 않는 경우 , RuntimeException 발생
	 * @return
	 */
	public List<TableSchemaVO> retrieveTableSchmaList();
	/**
	 * 해당 테이블의 컬럼 정보가 없는 경우, RuntimeException 발생	
	 * @param tableNAme
	 * @return
	 */
	public List<ColumnSchemaVO> retrieveColumnSchemaListByTableName(String tableNAme);
		
	

}
