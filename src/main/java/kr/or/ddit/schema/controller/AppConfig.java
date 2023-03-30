package kr.or.ddit.schema.controller;

import kr.or.ddit.schema.dao.ColumnSchemaDAO;
import kr.or.ddit.schema.dao.ColumnSchemaDAOImpl;
import kr.or.ddit.schema.dao.TableSchemaDAO;
import kr.or.ddit.schema.dao.TableSchemaDAOImpl;
import kr.or.ddit.schema.service.SchemaService;
import kr.or.ddit.schema.service.SchemaServiceImpl;

public class AppConfig {
	
	
	public ColumnSchemaDAO columnSchemaDAO() {
		return new ColumnSchemaDAOImpl();
	}
	public TableSchemaDAO tableSchemaDAO() {
		return new TableSchemaDAOImpl();
	}
	
	public SchemaService schemaService() {
		return new SchemaServiceImpl(new TableSchemaDAOImpl(), new ColumnSchemaDAOImpl());
	}
	

}
