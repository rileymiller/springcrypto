package com.springcrypto.wallet;

import com.springcrypto.coins.ICoin;
import com.springcrypto.smartcontract.ISmartContract;

public class DigitalWallet {
	private static DigitalWallet wallet = new DigitalWallet();
	
	private DigitalWallet() { };
	
	public static DigitalWallet getInstance()
	{
		return wallet;
	}
	
	public ISmartContract addContract(ISmartContract coin, String contract)
	{
		return coin.addContract(contract);
	}
	
	public ICoin processTransaction( ICoin coin, double amount ) throws Exception
	{
		return coin.processTransaction( amount );
	}
	
	public ICoin zero( ICoin coin )
	{
		return coin.setZero();
	}
	
	public ICoin accountBalance( ICoin coin )
	{
		return coin.accountBalance();
	}
}
