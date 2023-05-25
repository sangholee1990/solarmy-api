package solarmy.front.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class OutputStatDataVO {
	private Integer customer_link_number	;	
	private float prv_pwr;	
	private float prv_gas;	
	private float prv_water;	
	private float prd_prv_pwr;	
	private float prd_prv_gas;	
	private float prd_prv_water;	
	private float pre_pwr;	
	private float pre_gas;	
	private float pre_water;	
	private float prd_pre_pwr;	
	private float prd_pre_gas;	
	private float prd_pre_water;	
	private String mod_date;	
	private String reg_date;
	private String date_time;
	private String date;
	private String time;	
}
