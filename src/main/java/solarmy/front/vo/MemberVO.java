package solarmy.front.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false) 
public class MemberVO {
	private String product_serial_number;
	private Integer customer_link_number;
	private String kepco_api_key;
	private String sns_id;
	private String sns_pwd;
	private String sns_key;
	private String sns_type;
	private String user_name;
	private String phone_number;
	private String zip_number;
	private String addr;
	private String addr_dtl;
	private double lon;
	private double lat;
	private double house_area;
	private Integer male_cnt;
	private Integer female_cnt;
	private Integer room_cnt;
	private Integer tv_cnt;
	private Integer air_conditioner_cnt;
	private Integer washing_machine_cnt;
	private Integer dryer_cnt;
	private Integer rice_cooker_cnt;
	private Integer fan_cnt;
	private Integer disk_washer_cnt;
	private Integer computer_cnt;
	private String use_yn;
	private String mod_date;
	private String reg_date;
}
