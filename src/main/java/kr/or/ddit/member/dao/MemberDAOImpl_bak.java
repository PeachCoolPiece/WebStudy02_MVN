package kr.or.ddit.member.dao;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import kr.or.ddit.utils.CaseConvertingUtils;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.Pagination;

public class MemberDAOImpl_bak implements MemberDAO {

//	@Override
//	public MemberVO selectMemberForAuth(String memId) {
//		StringBuffer sql = new StringBuffer();
//		// 1
//		sql.append(" SELECT MEM_ID, MEM_PASS, MEM_NAME  ");
//		sql.append(" FROM MEMBER                        ");
//		sql.append(" WHERE MEM_ID = ?                   ");
//		
//		MemberVO saved = null;
//		try(
//			Connection conn = ConnectionFactory.getConnection();
//			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
//		){
//			//2
//			pstmt.setString(1, memId);
//			
//			ResultSet rs = pstmt.executeQuery();
//			
//			if(rs.next()){
//				// 3
//				saved = simpleDataMapper(rs, MemberVO.class);
////				saved = new MemberVO();
////				saved.setMemId(rs.getString("MEM_ID"));
////				saved.setMemPass(rs.getString("MEM_PASS"));
////				saved.setMemName(rs.getString("MEM_NAME"));
//			}
//			
//			return saved;
//		}catch(SQLException e){
//			throw new RuntimeException(e);
//		}
//		
//	}
//
//	@Override
//	public int insertMember(MemberVO member) {
//		StringBuffer sql = new StringBuffer();
//		// 1. 쿼리 결정
//		sql.append(" INSERT INTO MEMBER (                             ");
//		sql.append(" 	    MEM_ID                                    ");
//		sql.append(" 	    , MEM_PASS                                ");
//		sql.append(" 	    , MEM_NAME                                ");
//		sql.append(" 	    , MEM_REGNO1                              ");
//		sql.append(" 	    , MEM_REGNO2                              ");
//		sql.append(" 	    , MEM_BIR                                 ");
//		sql.append(" 	    , MEM_ZIP                                 ");
//		sql.append(" 	    , MEM_ADD1                                ");
//		sql.append(" 	    , MEM_ADD2                                ");
//		sql.append(" 	    , MEM_HOMETEL                             ");
//		sql.append(" 	    , MEM_COMTEL                              ");
//		sql.append(" 	    , MEM_HP                                  ");
//		sql.append(" 	    , MEM_MAIL                                ");
//		sql.append(" 	    , MEM_JOB                                 ");
//		sql.append(" 	    , MEM_LIKE                                ");
//		sql.append(" 	    , MEM_MEMORIAL                            ");
//		sql.append(" 	    , MEM_MEMORIALDAY                         ");
//		sql.append(" 	    , MEM_MILEAGE                             ");
//		sql.append(" 	) VALUES (                                    ");
//		sql.append(" 			?                                     ");
//		sql.append(" 		    , ?                                   ");
//		sql.append(" 		    , ?                                   ");
//		sql.append(" 		    , ?                                   ");
//		sql.append(" 		    , ?                                   ");
//		sql.append(" 		    , TO_DATE(?, 'YYYY-MM-DD')            ");
//		sql.append(" 		    , ?                                   ");
//		sql.append(" 		    , ?                                   ");
//		sql.append(" 		    , ?                                   ");
//		sql.append(" 		    , ?                                   ");
//		sql.append(" 		    , ?                                   ");
//		sql.append(" 		    , ?                                   ");
//		sql.append(" 		    , ?                                   ");
//		sql.append(" 		    , ?                                   ");
//		sql.append(" 		    , ?                                   ");
//		sql.append(" 		    , ?                                   ");
//		sql.append(" 		    , TO_DATE(?, 'YYYY-MM-DD')            ");
//		sql.append(" 		    , 3000                                ");
//		sql.append(" 	)                                             ");
//		try (Connection conn = ConnectionFactory.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
//			// 2. 쿼리 파라미터 설정
//			int idx = 1;
//			pstmt.setString(idx++, member.getMemId());
//			pstmt.setString(idx++, member.getMemPass());
//			pstmt.setString(idx++, member.getMemName());
//			pstmt.setString(idx++, member.getMemRegno1());
//			pstmt.setString(idx++, member.getMemRegno2());
//			pstmt.setString(idx++, member.getMemBir());
//			pstmt.setString(idx++, member.getMemZip());
//			pstmt.setString(idx++, member.getMemAdd1());
//			pstmt.setString(idx++, member.getMemAdd2());
//			pstmt.setString(idx++, member.getMemHometel());
//			pstmt.setString(idx++, member.getMemComtel());
//			pstmt.setString(idx++, member.getMemHp());
//			pstmt.setString(idx++, member.getMemMail());
//			pstmt.setString(idx++, member.getMemJob());
//			pstmt.setString(idx++, member.getMemLike());
//			pstmt.setString(idx++, member.getMemMemorial());
//			pstmt.setString(idx++, member.getMemMemorialday());
//			
//			return pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	
//	
//	
//	@Override
//	public List<MemberVO> selectMemberList() {
//		StringBuffer sql = new StringBuffer();
//		// 1. 쿼리 결정
//		sql.append(" SELECT MEM_ID, MEM_NAME										  ");	
//	    sql.append("     , TO_CHAR(MEM_BIR, 'YYYY-MM-DD') MEM_BIR                     ");
//	    sql.append("     , MEM_HP, MEM_MAIL, MEM_ADD1                                 ");
//	    sql.append("     , TO_CHAR(MEM_MEMORIALDAY, 'YYYY-MM-DD') MEM_MEMORIALDAY     ");
//	    sql.append("     , MEM_MILEAGE                                                ");
//        sql.append(" FROM MEMBER                                                      ");
//        
//        List<MemberVO> list = new ArrayList<>();
//		try (Connection conn = ConnectionFactory.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
//			// 2. 쿼리 파라미터 설정
//
//			ResultSet rs = pstmt.executeQuery();
//			while (rs.next()) {
//				// 3. 결과집합 -> POJO(VO)
//				list.add(simpleDataMapper(rs, MemberVO.class));
////				list.add(
////					MemberVO.builder()
////							.memId(rs.getString("MEM_ID"))
////							.memName(rs.getString("MEM_NAME"))
////							.memBir(rs.getString("MEM_BIR"))
////							.memHp(rs.getString("MEM_HP"))
////							.memMail(rs.getString("MEM_MAIL"))
////							.memAdd1(rs.getString("MEM_ADD1"))
////							.memMemorialday(rs.getString("MEM_MEMORIALDAY"))
////							.memMileage(rs.getInt("MEM_MILEAGE"))
////							.build()
////				);
//			}
//
//			return list;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	@Override
//	public MemberVO selectMember(String memId) {
//		StringBuffer sql = new StringBuffer();
//		// 1. 쿼리 결정                                                          
//		sql.append(" SELECT                                                      											"    );
//		sql.append("     MEM_ID,    MEM_PASS,    MEM_NAME,                       											"    );
//		sql.append("     MEM_REGNO1,    MEM_REGNO2,    TO_CHAR(MEM_BIR, 'YYYY-MM-DD') MEM_BIR,                 				 "    );
//		sql.append("     MEM_ZIP,    MEM_ADD1,    MEM_ADD2,                      											"    );
//		sql.append("     MEM_HOMETEL,    MEM_COMTEL,    MEM_HP,                  											"    );
//		sql.append("     MEM_MAIL,    MEM_JOB,    MEM_LIKE,                      											"    );
//		sql.append("     MEM_MEMORIAL,    TO_CHAR(MEM_MEMORIALDAY, 'YYYY-MM-DD') MEM_MEMORIALDAY,    MEM_MILEAGE,       	"    );
//		sql.append("     MEM_DELETE                                              										"    );
//		sql.append(" FROM    member                                              										"    );
//		sql.append(" WHERE MEM_ID = ?                                            										"    );
//		try (Connection conn = ConnectionFactory.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
//			// 2. 쿼리 파라미터 설정
//			pstmt.setString(1, memId);
//			ResultSet rs = pstmt.executeQuery();
//			MemberVO member = null;
//			while (rs.next()) {
//				// 3. 결과집합 -> POJO(VO)
//				member = simpleDataMapper(rs, MemberVO.class);
//			}
//
//			return member;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	@Override
//	public int updateMember(MemberVO member) {
//		StringBuffer sql = new StringBuffer();
//		// 1. 쿼리 결정
//		
//		sql.append(" UPDATE MEMBER                                                ");
//	    sql.append(" SET                                                          ");
//		sql.append("      MEM_ZIP =?                                             ");
//		sql.append("     , MEM_ADD1 =?                                            ");
//		sql.append("     , MEM_ADD2 =?                                            ");
//		sql.append("     , MEM_HOMETEL =?                                         ");
//		sql.append("     , MEM_COMTEL =?                                          ");
//		sql.append("     , MEM_HP =?                                              ");
//		sql.append("     , MEM_MAIL =?                                            ");
//		sql.append("     , MEM_JOB =?                                             ");
//		sql.append("     , MEM_LIKE =?                                            ");
//		sql.append("     , MEM_MEMORIAL =?                                        ");
//		sql.append("     , MEM_MEMORIALDAY = TO_DATE(?, 'YYYY-MM-DD')             ");
//		sql.append(" WHERE MEM_ID =?                                              ");
//		
//		try (Connection conn = ConnectionFactory.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
//			// 2. 쿼리 파라미터 설정
//
//			int idx = 1;
//			pstmt.setString(idx++, member.getMemZip());
//			pstmt.setString(idx++, member.getMemAdd1());
//			pstmt.setString(idx++, member.getMemAdd2());
//			pstmt.setString(idx++, member.getMemHometel());
//			pstmt.setString(idx++, member.getMemComtel());
//			pstmt.setString(idx++, member.getMemHp());
//			pstmt.setString(idx++, member.getMemMail());
//			pstmt.setString(idx++, member.getMemJob());
//			pstmt.setString(idx++, member.getMemLike());
//			pstmt.setString(idx++, member.getMemMemorial());
//			pstmt.setString(idx++, member.getMemMemorialday());
//			pstmt.setString(idx++, member.getMemId());
//			
//			return pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}

	@Override
	public int deleteMember(String memId) {
		// TODO Auto-generated method stub
		return 0;
	}

@Override
public MemberVO selectMemberForAuth(String memId) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int insertMember(MemberVO member) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public List<MemberVO> selectMemberList(Pagination<MemberVO> pagination) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public MemberVO selectMember(String memId) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int updateMember(MemberVO member) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int selectTotalRecord(Pagination<MemberVO> pagination) {
	// TODO Auto-generated method stub
	return 0;
}

}
