package com.spring.BankingSystemSpring.Entity;


import jakarta.persistence.*;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private Client client;
	//private Date transactionDate;
	private String description;
	@OneToOne
	private Account fromAccount;
	@OneToOne
	private Account toAccount;
	@Column(name = "amount_of_transfered_money")
	private Integer amountOfTransferedMoney;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	/*public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}*/
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Account getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Account getToAccount() {
		return toAccount;
	}
	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}
	public Integer getAmountOfTransferedMoney() {
		return amountOfTransferedMoney;
	}
	public void setAmountOfTransferedMoney(int amountOfTransferedMoney) {
		this.amountOfTransferedMoney = amountOfTransferedMoney;
	}
	
}
