package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.vo.Pagination;
import kr.or.ddit.vo.ProdVO;

/**
 * 
 * 상품관리(CRUD) Persitsence Layer
 *
 */
public interface ProdDAO {
	/**
	 * 상품 등록, 등록시 prodId 생성필요
	 * @param prod
	 * @return > 0 ,  성공
	 */
	public int insertProd(ProdVO prod); 
	/**
	 * 상품 목록 조회, 추후 페이징과 검색 적용
	 * @param pagination TODO
	 * @return
	 */
	public List<ProdVO> selectProdList(Pagination<ProdVO> pagination);
	
	/**
	 * 상품 상세 조회
	 * @param prodId
	 * @return 존재하지 않으면, null 반환
	 */
	public ProdVO selectProd(String prodId);
	
	/**
	 * 상품 수정
	 * @param prod
	 * @return >0 , 성공
	 */
	public int updateProd(ProdVO prod);
	
	/**
	 * 
	 * @param prodId
	 * @return > 0 , 성공
	 */
	public default int deleteProd(String prodId) {
		throw new RuntimeException("상품 삭제 불가능.");
	}
	public int selectTotalRecord(Pagination<ProdVO> pagination);
}
