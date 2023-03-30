package kr.or.ddit.schema.service;

import java.util.List;

import kr.or.ddit.schema.dao.ColumnSchemaDAO;
import kr.or.ddit.schema.dao.ColumnSchemaDAOImpl;
import kr.or.ddit.schema.dao.TableSchemaDAO;
import kr.or.ddit.schema.dao.TableSchemaDAOImpl;
import kr.or.ddit.vo.ColumnSchemaVO;
import kr.or.ddit.vo.TableSchemaVO;

public class SchemaServiceImpl implements SchemaService{
	// 의존관계 형성을 위한 코드로 발생하는 강결합을 DI(의존성 주입) 구조를 통해 해결해야함
	private TableSchemaDAO tableDAO;
	private ColumnSchemaDAO colDAO;
	
	
	public SchemaServiceImpl(TableSchemaDAO tableDAO, ColumnSchemaDAO colDAO) {
		this.tableDAO = tableDAO;
		this.colDAO = colDAO;
	}

	@Override
	public List<TableSchemaVO> retrieveTableSchmaList() {
		
		List<TableSchemaVO> list =  tableDAO.selectTableSchemaList();
		if(list.size() == 0) {
			throw new RuntimeException("테이블이 하나도 없음");
		}else {
			return list;
		}
	}

	@Override
	public List<ColumnSchemaVO> retrieveColumnSchemaListByTableName(String tableNAme) {
		List<ColumnSchemaVO> list =  colDAO.selectColumnSchemaListByTableName(tableNAme);
		if(list.size() == 0) {
			throw new RuntimeException(String.format("%s 테이블의 컬럼이 없음", tableNAme));
		}else {
			return list;
		}
		
	}

}
