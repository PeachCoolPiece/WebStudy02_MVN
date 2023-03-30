package kr.or.ddit.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import org.apache.ibatis.annotations.Mapper;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.InsertGroup;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * JavaBean 규약
 * ValueObject, DataTransferObject, Model, Bean
 * ex) MemberVO, MemberDTO, MemberModel, MemberBean
 * 
 * 1. 값을 저장할 속성(property) 정의
 * 2. 캡슐화
 * 3. 캡슐화된 데이터에 접근할 인터페이스 제공(getter/setter)
 * 		get[set]프로퍼티명에서 첫문자만 대문자, camel case 적용
 * 4. 상태 비교 메소드 제공
 * 5. 상태 확인 메소드 제공
 * 6. 직렬화 가능
 *
 * 회원관리와 인증시스템을 위한 Domain Layer
 */
@Data
@EqualsAndHashCode(of="memId")
@ToString(exclude = {"memPass", "memRegno1", "memRegno2"})
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
public class MemberVO implements Serializable{
	private int rnum;
	@NotBlank(groups = InsertGroup.class)
	private String memId;
	
	@NotBlank(groups = {Default.class,DeleteGroup.class})
	@JsonIgnore
	private transient String memPass;
	@NotBlank(groups = InsertGroup.class)
	private String memName;
	
	@Size(min = 6,max = 6)
	@JsonIgnore
	private transient String memRegno1;
	@Size(min = 7,max =7)
	@JsonIgnore
	private transient String memRegno2;
	
	private LocalDateTime memBir;
	
	@NotBlank
	private String memZip;
	@NotBlank
	private String memAdd1;
	@NotBlank
	private String memAdd2;
	
	@Pattern(regexp = "\\d{2,3}-\\d{3,4}-\\d{4}")
	private String memHometel;
	@Pattern(regexp = "\\d{2,3}-\\d{3,4}-\\d{4}")
	private String memComtel;
	@Pattern(regexp = "010-\\d{3,4}-\\d{4}")
	private String memHp;
	
	@NotBlank
	@Email
	private String memMail;
	private String memJob;
	private String memLike;
	private String memMemorial;
	
	private LocalDate memMemorialday;
	
	@Min(0)
	private Integer memMileage;
	private boolean memDelete;
	
	private int prodCount;
	
	public String getMemTest() {
		return "테스트";
	}
	
	private List<ProdVO> prodList; // has many
}















