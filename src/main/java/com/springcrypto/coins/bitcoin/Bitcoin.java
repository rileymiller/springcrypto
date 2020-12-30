package com.springcrypto.coins.bitcoin;

import com.springcrypto.coins.ICoin;

public class Bitcoin implements ICoin {
	protected static final String 	NAME = "Bitcoin";
	protected static final String 	WHITE_PAPER = "https://bitcoin.org/bitcoin.pdf";
	protected double 				btc = 0;
	
	private static Bitcoin 			bitcoin = new Bitcoin();
	
	protected Bitcoin() { };
	
	public static Bitcoin getInstance() 
	{
		return bitcoin;
	}
	
	/**
	 * Processes a BTC transaction in the digital wallet by adding
	 * or removing BTC. If the call tries to deduct more funds than
	 * are available in the wallet, it throws an error.
	 * 
	 * @param requestedBTC
	 * @return this
	 * @throws Exception
	 */
	public Bitcoin processTransaction( double requestedBTC ) throws Exception
	{
		if( btc + requestedBTC < 0 )
		{
			throw new Exception(
					String.format( "\nInsufficient funds:\n\t"
					+ " BTC Available: %1$s\n\t BTC Requested: %2$s", btc, requestedBTC ));
		} else 
		{
			btc = btc + requestedBTC;
		}
		
		return this;
	}
	
	/**
	 * Sets the BTC balance to zero
	 * 
	 * @return this
	 */
	public Bitcoin setZero()
	{
		btc = 0;
		
		return this;
	}
	
	/**
	 * Returns the BTC balance in the Digital Wallet
	 * 
	 * @return this
	 */
	public Bitcoin accountBalance()
	{
		return this;
	}
	
	/////////////////////////////////////////
	//	For Serialization
	////////////////////////////////////////
	public double getBTC() 
	{
		return btc;
	}
	
	public String getName()
	{
		return NAME;
	}
	
	public String getWhitePaper()
	{
		return WHITE_PAPER;
	}
	
	public double getSatoshis()
	{
		return btc * 100000000;
	}
}
