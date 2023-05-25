package solarmy.front.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class TermsCondVO {
	private Integer customer_link_number;	
	private String terms_code;	
	private String terms_version;	
	private String terms_cont;	
	private String agrtr_cndtn_yn;	
	private String use_yn;	
	private String mod_date;	
	private String reg_date;
}
