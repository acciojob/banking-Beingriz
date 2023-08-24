package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance, 0);
        this.rate  = rate;
        this.maxWithdrawalLimit= maxWithdrawalLimit;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(getMaxWithdrawalLimit()<=0){
            throw new Exception("Maximum Withdraw Limit Exceed");
        }
        if(getBalance() < amount){
            throw  new Exception("Insufficient Balance");
        }else {
            setBalance(getBalance()-amount);
            setMaxWithdrawalLimit(getMaxWithdrawalLimit()-1);
        }

    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        return (getBalance()*getRate()*years)/100;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        // principle  = getbalance();
        // rate = getRate()
        double amount = getBalance()*Math.pow(1+getRate()/times,times*years);
        return amount-getBalance();
    }

}
