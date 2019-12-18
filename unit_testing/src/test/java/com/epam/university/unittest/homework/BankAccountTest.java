package com.epam.university.unittest.homework;

import java.text.MessageFormat;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.core.Is.is;
import java.lang.IllegalArgumentException;

public class BankAccountTest {
    private final String name = "testName";
    private final double balance = 100000;
    private final double limit = 10000;
    private final String activeStatus = "Active";
    private final String frozenStatus = "Frozen";
    private BankAccount account;
    
    @Before
    public void setup() {
        account = new BankAccount (name, balance, limit);
    }
    
    @Before
    public void log() {
        System.out.println (account.getAccountDetails());
    }
    
    //Constuctors--------------------------------------------------------------------
    @Test
    public void testAccountDetailsWithLimit () {
        //Given
        String expected = makeExpectedDetails (name, activeStatus, balance, limit);
        //When
        //Then
        Assert.assertEquals (expected, account.getAccountDetails());
    }
    
    @Test
    public void testAccountDetailsWithoutLimit () {
        //Given
        String expected = makeExpectedDetails (name, activeStatus, balance, 0);
        //When
         account = new BankAccount (name, balance);
        //Then
        Assert.assertEquals (expected, account.getAccountDetails());
    }
    
    //Credit-------------------------------------------------------------------------
    @Test
    public void testCredit () {
        //Given
        double amount = 1000.5;
        String expected = makeExpectedDetails (name, activeStatus, balance + amount, limit);
        //When
        account.credit(amount);
        //Then
        Assert.assertEquals (expected, account.getAccountDetails());
    }
    @Test
    public void testCreditWithZero () {
        //Given
        String expected = makeExpectedDetails (name, activeStatus, balance, limit);
        //When
        account.credit(0);
        //Then
        Assert.assertEquals (expected, account.getAccountDetails());
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void testCreditWithNegative () {
        //Given
        double amount = -10000;
        //When
        account.credit(amount);
        //Then
    }
    
    //Debit--------------------------------------------------------------------------
    @Test
    public void testDebit () {
        //Given
        double amount = 10000;
        String expected = makeExpectedDetails (name, activeStatus, balance - amount, limit);
        //When
        try{
            account.debit(amount);
        } catch (AccountFrozenException e) {
            Assert.assertThat(e.getMessage(), is("Something bad happened"));
        }
        //Then
        Assert.assertEquals (expected, account.getAccountDetails());
    }
    
    @Test
    public void testDebitWithZero () {
        //Given
        String expected = makeExpectedDetails (name, activeStatus, balance, limit);
        //When
        try{
            account.debit(0);
        } catch (AccountFrozenException e) {
            Assert.assertThat(e.getMessage(), is("Something bad happened"));
        }
        //Then
        Assert.assertEquals (expected, account.getAccountDetails());
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void testDebitWithNegative () {
        //Given
        double amount = -10000;
        //When
        try{
            account.debit(amount);
        } catch (AccountFrozenException e) {
            Assert.assertThat(e.getMessage(), is("Something bad happened"));
        }
        //Then
    }
    
    @Test
    public void testDebitUnderTheLimit () {
        //Given
        double amount = balance - limit + 1000;
        String expected = makeExpectedDetails (name, frozenStatus, balance-amount, limit);
        //When
        try{
            account.debit(amount);
        } catch (AccountFrozenException e) {
            Assert.assertThat(e.getMessage(), is("Something bad happened"));
        }
        //Then
        Assert.assertEquals (expected, account.getAccountDetails());
    }
    
    //BelowLimit--------------------------------------------------------------------------
     
    @Test
    public void testCreditBelowTheLimit () {
        //Given
        double extraAmount = 1000.56;
        double amount = balance - limit + extraAmount;
        String expected = makeExpectedDetails (name, activeStatus, balance-amount+extraAmount, limit);
        //When
        try{
            account.debit(amount);
        } catch (AccountFrozenException e) {
            Assert.assertThat(e.getMessage(), is("Something bad happened"));
        }
        
        account.credit (extraAmount);
        //Then
        Assert.assertEquals (expected, account.getAccountDetails());
    }
    
    @Test(expected = AccountFrozenException.class) 
    public void testdebitBelowTheLimit () throws AccountFrozenException {
        //Given
        double amount = balance - limit;
        String expected = makeExpectedDetails (name, activeStatus, balance-amount, limit);
        //When
        try{
            account.debit(amount);
        } catch (AccountFrozenException e) {
            Assert.assertThat(e.getMessage(), is("Something bad happened"));
        }
        
        account.debit (1000);
        //Then
    }
    
    //Others--------------------------------------------------------------------------
     
    private String makeExpectedDetails (String name, String status, double balance, double limit){
        String bMessage = "Because you are over your credit limit. ";
        
        return MessageFormat.format("Dear {0}, your account is {1}. {2}Your current balance is: {3}and your limit is: {4}",
                name, status, (status.equals(frozenStatus) ? bMessage: ""), balance, limit);
        
    }
}
