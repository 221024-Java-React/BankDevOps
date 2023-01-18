package com.example.models;

import java.util.Enumeration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transactions")
public class AccountTransaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="transaction_id")
	private int transactionId;
	
	@Enumerated(EnumType.ORDINAL)
	private TransactionType type;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="to_id")
	private Account to;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="from_id")
	private Account from;
	
	private double amount;
		
	public AccountTransaction() {
		super();
	}

	public AccountTransaction(int transactionId, TransactionType type, Account to, Account from, double amount) {
		super();
		this.transactionId = transactionId;
		this.type = type;
		this.to = to;
		this.from = from;
		this.amount = amount;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	

	public Account getTo() {
		return to;
	}

	public void setTo(Account to) {
		this.to = to;
	}

	public Account getFrom() {
		return from;
	}

	public void setFrom(Account from) {
		this.from = from;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", type=" + type + ", to=" + to + ", from=" + from
				+ ", amount=" + amount + "]";
	}

	
}
