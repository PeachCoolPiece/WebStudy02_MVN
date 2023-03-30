package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="buyerId")
public class BuyerVO implements Serializable {
	private int rnum;
	@NotBlank(groups = {UpdateGroup.class,DeleteGroup.class})
	private String buyerId;
	@NotBlank
	private String buyerName;
	
	@NotBlank
	private String buyerLgu;
	private String lprodNm;
	
	private String buyerBank;
	private String buyerBankno;
	private String buyerBankname;
	private String buyerZip;
	private String buyerAdd1;
	private String buyerAdd2;
	
	@NotBlank
	private String buyerComtel;
	@NotBlank
	private String buyerFax;
	@NotBlank
	@Size(min = 3, max = 20)
	@Email
	private String buyerMail;
	private String buyerCharger;
	private String buyerTelext;
	
	private List<ProdVO> prodList; // has many - 1:N
	
	private int prodCount;
}















