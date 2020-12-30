package com.springcrypto.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.springcrypto.coins.ICoin;
import com.springcrypto.coins.bitcoin.BitcoinRobust;
import com.springcrypto.coins.ethereum.Ethereum;
import com.springcrypto.smartcontract.ISmartContract;
import com.springcrypto.wallet.DigitalWallet;

@RestController
public class DigitalWalletController {
	
	private BitcoinRobust 	btc = BitcoinRobust.getInstance();
	
	private Ethereum		eth = Ethereum.getInstance();
	
	@GetMapping("/btc/balance")
	public ICoin btc_wallet() {
		return DigitalWallet
				.getInstance()
				.accountBalance( btc );
	}
	
	@GetMapping("/btc/transaction")
	public ICoin btc_transaction(
			@RequestParam(value = "value", defaultValue = "0" )
			String value )
	{
		try
		{
			double parsedValue = Double.parseDouble( value );
			
			try 
			{				
				return DigitalWallet
						.getInstance()
						.processTransaction( btc, parsedValue );
			} 
			catch( Exception e )
			{
				throw new ResponseStatusException(
						HttpStatus.BAD_REQUEST, e.toString() );
			}
			
		} 
		catch ( NumberFormatException e )
		{
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, e.toString() );
		}
	}
	
	@GetMapping("/btc/zero")
	public ICoin btc_zero()
	{
		return DigitalWallet
				.getInstance()
				.zero( btc );
	}
	
	@GetMapping("/eth/balance")
	public ICoin eth_wallet() {
		return DigitalWallet
				.getInstance()
				.accountBalance( eth );
	}
	
	@GetMapping("/eth/transaction")
	public ICoin eth_transaction(
			@RequestParam(value = "value", defaultValue = "0" )
			String value )
	{
		try
		{
			double parsedValue = Double.parseDouble( value );
			
			try 
			{				
				return DigitalWallet
						.getInstance()
						.processTransaction( eth, parsedValue );
			} 
			catch( Exception e )
			{
				throw new ResponseStatusException(
						HttpStatus.BAD_REQUEST, e.toString() );
			}
			
		} 
		catch ( NumberFormatException e )
		{
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, e.toString() );
		}
	}
	
	@GetMapping("/eth/add_contract")
	public ISmartContract eth_add_contract(
			@RequestParam(value = "code", defaultValue = "0" )
			String code )
	{
			try 
			{				
				return DigitalWallet
						.getInstance()
						.addContract( eth, code );
			} 
			catch( Exception e )
			{
				throw new ResponseStatusException(
						HttpStatus.BAD_REQUEST, e.toString() );
			}
	}
	
	@GetMapping("/eth/zero")
	public ICoin eth_zero()
	{
		return DigitalWallet
				.getInstance()
				.zero( eth );
	}
}