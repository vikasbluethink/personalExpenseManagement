package com.expensemanagement;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Expense {
	
	@Id
	private Long exp_id = System.currentTimeMillis();
	
	@Column
	private Float amount;
	
	@Column(name="create_at")
	private Date date;
	
	@Column
	private String remark;
	
//	@ManyToOne
//	private Category category;
	

	public Expense() {
		
	}
	
	public Long getExp_id() {
		return exp_id;
	}

	public void setExp_id(Long exp_id) {
		this.exp_id = exp_id;
	}

	public Expense(Float amount, Date date, String remark) {
		super();
		this.amount = amount;
		this.date = date;
		this.remark = remark;
	}
	public Long getExpId() {
		
		return exp_id;
	}

	public void setExpId(Long exp_id) {
		this.exp_id = exp_id;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	

}
