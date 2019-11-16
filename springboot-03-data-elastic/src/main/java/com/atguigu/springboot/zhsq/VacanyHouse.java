package com.atguigu.springboot.zhsq;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/8/19 15:25
 *
 */
//@Document(indexName = "es_dm_house_vacany",type = "_doc")
public class VacanyHouse {

//	@Id
	private String residenceAddress;
	private String placeId;
	private String placeName;
	private String buildingNo;
	private String houseNo;
	private	String openTime;
	private String openTimestamp;
	private String openType;
	private String openTypeCn;

	public String getResidenceAddress() {
		return residenceAddress;
	}

	public void setResidenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getOpenTimestamp() {
		return openTimestamp;
	}

	public void setOpenTimestamp(String openTimestamp) {
		this.openTimestamp = openTimestamp;
	}

	public String getOpenType() {
		return openType;
	}

	public void setOpenType(String openType) {
		this.openType = openType;
	}

	public String getOpenTypeCn() {
		return openTypeCn;
	}

	public void setOpenTypeCn(String openTypeCn) {
		this.openTypeCn = openTypeCn;
	}

	//    "place_name": "田林十四村",
//    "residence_address": "田林十四村20号102室",
//    "building_no": "20",
//    "house_no": "102",
//    "open_time": "1565644261000",
//    "open_timestamp": "2019-08-13 05:11:01",
//    "open_type": "100101",
//    "open_type_cn": "IC卡开门"

}
