package com.springcrypto.coins.ethereum;

public class SmartContract
{
	private String contract;
	
	public SmartContract() { };
	
	public SmartContract( String contract )
	{
		this.contract = contract;
	}
	
	public String getContract()
	{
		return this.contract;
	}
}