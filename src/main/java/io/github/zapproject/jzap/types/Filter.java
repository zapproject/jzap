// package io.github.zapproject.jzap.types;

import java.math.BigInteger;

interface Filter {
	/**
	 * Setter for from block, utilizes BigInteger
	 */
	public void setFromBlock(BigInteger fromBlock);

	/**
	 * Setter for To block using BigInteger
	 */
	public void setToBlock(BigInteger toBlock);

	/**
	 * Setter for provider, utilizing byte[] for address
	 */
	public void setProvider(byte[] provider);

	/**
	 * Setter for subscriber, utilizing byte[] for address
	 */
	public void setSubscriber(byte[] subscriber);

	/**
	 * Setter for terminator, utilizing byte[] for address
	 */
	public void setTerminator(byte[] terminator);

	/**
	 * Setter for endpoint string
	 */
	public void setEndpoint(String endpoint);

	/**
	 * Setter for BigInteger representing id
	 */
	public void setId(BigInteger id);


	/**
	 * Getter for from block, returns BigInteger
	 */
	public BigInteger getFromBlock();

	/**
	 * Getter for to block, returns BigInteger
	 */
	public BigInteger getToBlock();

	/**
	 * Getter for provider, returns byte[] for address
	 */
	public byte[] getProvider();

	/**
	 * Getter for subscriber, returns byte[] for address
	 */
	public byte[] getSubscriber();

	/**
	 * Getter for terminator, returns byte[] for address
	 */
	public byte[] getTerminator();

	/**
	 * Getter for endpoint, returns String
	 */
	public String getEndpoint();

	/**
	 * Getter for id, returns BigInteger
	 */
	public BigInteger getId();
}