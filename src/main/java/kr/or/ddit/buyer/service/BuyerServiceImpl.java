package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.dao.BuyerDAO;
import kr.or.ddit.buyer.dao.BuyerDAOImpl;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PKNotFoundException;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.Pagination;

public class BuyerServiceImpl implements BuyerService {
	private BuyerDAO buyerDAO = new BuyerDAOImpl();			

	@Override
	public ServiceResult createBuyer(BuyerVO buyer) {
		int rowcnt = buyerDAO.insertBuyer(buyer);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public List<BuyerVO> retrieveBuyerList(Pagination<BuyerVO> pagination) {
		pagination.setTotalRecord(buyerDAO.selectTotalRecord(pagination));
		return buyerDAO.selectBuyerList(pagination);
	}

	@Override
	public BuyerVO retrieveBuyer(String buyerId) throws PKNotFoundException {
		BuyerVO buyer = buyerDAO.selectBuyer(buyerId);
		if(buyer==null)
			throw new PKNotFoundException(buyerId);
		return buyer;
	}

	@Override
	public ServiceResult modifyBuyer(BuyerVO buyer) {
		retrieveBuyer(buyer.getBuyerId());
		int rowcnt = buyerDAO.updateBuyer(buyer);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

}
