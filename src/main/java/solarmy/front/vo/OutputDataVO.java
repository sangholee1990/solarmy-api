package solarmy.front.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class OutputDataVO {
	private Integer customer_link_number;	
	private float temp;	
	private float hmdty;	
	private float pm25;	
	private float pm10;	
	private float dust;	
	private float co2;	
	private float pwr;	
	private float gas;	
	private float water;	
	private float prd_pwr;	
	private float prd_gas;	
	private float prd_water;	
	private String mod_date;	
	private String reg_date;
	private String date_time;
	private String date;
	private String time;
}
