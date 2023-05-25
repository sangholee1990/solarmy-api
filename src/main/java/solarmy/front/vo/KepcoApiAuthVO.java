package solarmy.front.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class KepcoApiAuthVO {
	private String kepco_api_key;	
	private String auth_yn;	
	private String use_yn;	
	private String mod_date;	
	private String reg_date;
}
