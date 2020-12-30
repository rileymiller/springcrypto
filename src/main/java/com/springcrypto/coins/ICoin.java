package com.springcrypto.coins;

public interface ICoin {
	ICoin processTransaction( double amount ) throws Exception;
	
	ICoin setZero();
	
	ICoin accountBalance();
}
