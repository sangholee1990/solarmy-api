package solarmy.front.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class SysInfoVO {
	private Integer customer_link_number;	
	private Integer pwr_svn_trg;	
	private Integer gas_svn_trg;	
	private Integer wtr_svn_trg;	
	private String alarm_use_yn;	
	private String alarm_sound_yn;	
	private String alarm_vbrtn_yn;	
	private String alarm_optm_yn;	
	private String use_yn;	
	private String reg_date;	
	private String mod_date;	
	private float tmp;	
	private float tmp2;	
	private float tmp3;	
	private float tmp4;	
	private float tmp5;	
	private String tmp6;	
	private String tmp7;
	private String tmp8;
	private String tmp9;
	private String tmp10;
}
