package com.cit.employeeportal.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection ="payroll")
public class PayrollDO {
	
	@Id
	private ObjectId _id;
	
	private String username;
	
	private String empNo;
	
	private String monthYear;
	
	private Long basicpay;
	
	private Long hra;
	
	private Long conveyance;
	
	private Long pf;
	
	private Long totalEarnings;
	
	private Long totalDeduction;
	
	private Long netPayable;

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public Long getBasicpay() {
		return basicpay;
	}

	public void setBasicpay(Long basicpay) {
		this.basicpay = basicpay;
	}

	public Long getHra() {
		return hra;
	}

	public void setHra(Long hra) {
		this.hra = hra;
	}

	public Long getConveyance() {
		return conveyance;
	}

	public void setConveyance(Long conveyance) {
		this.conveyance = conveyance;
	}

	public Long getPf() {
		return pf;
	}

	public void setPf(Long pf) {
		this.pf = pf;
	}

	public Long getTotalEarnings() {
		return totalEarnings;
	}

	public void setTotalEarnings(Long totalEarnings) {
		this.totalEarnings = totalEarnings;
	}

	public Long getTotalDeduction() {
		return totalDeduction;
	}

	public void setTotalDeduction(Long totalDeduction) {
		this.totalDeduction = totalDeduction;
	}

	public Long getNetPayable() {
		return netPayable;
	}

	public void setNetPayable(Long netPayable) {
		this.netPayable = netPayable;
	}
	
}
