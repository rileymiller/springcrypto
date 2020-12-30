package com.springcrypto.coins.ethereum;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.springcrypto.coins.ICoin;
import com.springcrypto.smartcontract.ISmartContract;

public class Ethereum implements ICoin, ISmartContract
{
	private static final double 	ETHER_USD = 524.44;
	private static final double 	TRANSACTION_FEE_USD = 11.66;
	
	private static final String		NAME = "Ethereum";
	private static final String		WHITE_PAPER = "https://blockchainlab.com/pdf/Ethereum_white_paper-a_next_generation_smart_contract_and_decentralized_application_platform-vitalik-buterin.pdf";
	
	private double 					ether = 0;
	private List<SmartContract>		smartContracts;
	private static Ethereum 		ethereum = new Ethereum();
	
	private Ethereum() { };
	
	public static Ethereum getInstance() 
	{
		
		return ethereum;
	}
	
	@Override
	public ICoin processTransaction( double requestedEther ) throws Exception
	{
		try 
		{
			if( ( ether + requestedEther ) * ETHER_USD - TRANSACTION_FEE_USD < 0 )
			{
				throw new Exception(
						String.format( "\nInsufficient funds:\n\t ETH Available:"
								+ " %1$s\n\t ETH Requested: %2$s\n\t ETH Transation Fee (USD): %3$s",
						ether, requestedEther, TRANSACTION_FEE_USD ));
			} 
			else 
			{
				ether = ether + requestedEther - (TRANSACTION_FEE_USD / ETHER_USD);
			}
		} 
		catch ( Exception e )
		{
			throw new ResponseStatusException( HttpStatus.BAD_REQUEST, e.toString() );
		}
		
		return this;
	}

	@Override
	public ICoin setZero()
	{
		ether = 0;

		return this;
	}
	
	@Override
	public ICoin accountBalance()
	{
		return this;
	}
	
	@Override
	public ISmartContract addContract( String newContract )
	{
		if( smartContracts == null )
		{
			smartContracts = new ArrayList<>();
		}
		
		SmartContract 	contract = new SmartContract(newContract);
		
		smartContracts.add(contract);
		return this;
	}
	
	/////////////////////////////////////////
	//	For Serialization
	////////////////////////////////////////
	public double getETH() 
	{
		return ether;
	}
	
	public String getName()
	{
		return NAME;
	}
	
	public String getWhitePaper()
	{
		return WHITE_PAPER;
	}
	
	public double getTransactionFeeUSD()
	{
		return TRANSACTION_FEE_USD;
	}
	
	public List<SmartContract> getSmartContracts()
	{
		return smartContracts;
	}
}
