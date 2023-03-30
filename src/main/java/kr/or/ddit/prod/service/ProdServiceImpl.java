package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PKNotFoundException;
import kr.or.ddit.member.exception.UserNotFoundException;
import kr.or.ddit.prod.dao.ProdDAO;
import kr.or.ddit.prod.dao.ProdDAOImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.Pagination;
import kr.or.ddit.vo.ProdVO;

public class ProdServiceImpl implements ProdService{
	
	ProdDAO dao = new ProdDAOImpl();
	
	@Override
	public ServiceResult createProd(ProdVO prod) {
		ServiceResult result = null;
		int cnt =  dao.insertProd(prod);
		result = cnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		return result;
	}

	@Override
	public List<ProdVO> retrieveProdList(Pagination<ProdVO> pagination) {
		pagination.setTotalRecord(dao.selectTotalRecord(pagination));
		return dao.selectProdList(pagination);
	}

	@Override
	public ProdVO retrieveProd(String prodId) throws PKNotFoundException {
		ProdVO prod = dao.selectProd(prodId);
		if(prod==null)
			throw new PKNotFoundException(prodId);
		return prod;
	}

	@Override
	public ServiceResult modifyProd(ProdVO prod) throws PKNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
