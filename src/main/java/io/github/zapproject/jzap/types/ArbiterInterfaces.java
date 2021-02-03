// package io.github.zapproject.jzap.types;

import java.math.BigInteger;



interface SubscriptionInit extends DefaultTx {
	/**
	 * Setter for provider address, utilizes byte[] for address
	 */
	public void setProvider(byte[] provider);

	/**
	 * Setter for endpoint String
	 */
	public void setEndpoint(String endpoint);

	/**
	 * Setter for endpoint params, utilizing String[]
	 */
	public void setEndpointParams(String[] endpoint_params);

	/**
	 * Setter for BigInteger representing blocks
	 */
	public void setBlocks(BigInteger blocks);

	/**
	 * Setter for BigInteger representing pubkey
	 */
	public void setPubkey(BigInteger pubkey);



	/**
	 * Getter for provider address, returns byte[] for address
	 */
	public byte[] getProvider();

	/**
	 * Getter for endpoint, returns String for endpoint
	 */
	public String getEndpoint();

	/**
	 * Getter for endpoint params, returns String[] for endpoint params
	 */
	public String[] getEndpointParams();

	/**
	 * Getter for blocks, returns BigInteger
	 */
	public BigInteger getBlocks();

	/**
	 * Getter for pubkey, returns BigInteger
	 */
	public BigInteger getPubkey();
}



interface SubscriptionEnd extends DefaultTx {
	/**
	 * Setter for provider address, utilizes byte[] for address
	 */
	public void setProvider(byte[] provider);

	/**
	 * Setter for subscriber address, utilizes byte[] for address
	 */
	public void setSubscriber(byte[] subscriber);

	/**
	 * Setter for endpoint String
	 */
	public void setEndpoint(String endpoint);


	/**
	 * Getter for provider address, returns byte[] for address
	 */
	public byte[] getProvider();

	/**
	 * Getter for subscriber address, returns byte[] for address
	 */
	public byte[] getSubscriber();

	/**
	 * Getter for endpoint, returns String for endpoint
	 */
	public String getEndpoint();
}



interface SubscriptionType extends DefaultTx {
	/**
	 * Setter for provider address, utilizes byte[] for address
	 */
	public void setProvider(byte[] provider);

	/**
	 * Setter for subscriber address, utilizes byte[] for address
	 */
	public void setSubscriber(byte[] subscriber);

	/**
	 * Setter for endpoint String
	 */
	public void setEndpoint(String endpoint);


	/**
	 * Getter for provider address, returns byte[] for address
	 */
	public byte[] getProvider();

	/**
	 * Getter for subscriber address, returns byte[] for address
	 */
	public byte[] getSubscriber();

	/**
	 * Getter for endpoint, returns String for endpoint
	 */
	public String getEndpoint();
}



interface SubscriptionParams extends DefaultTx {
	/**
	 * Setter for receiver address, utilizes byte[] for address
	 */
	public void setReceiver(byte[] receiver);

	/**
	 * Setter for endpoint String
	 */
	public void setEndpoint(String endpoint);

	/**
	 * Setter for params, utilizing String[]
	 */
	public void setParams(String[] params);


	/**
	 * Getter for provider address, returns byte[] for address
	 */
	public byte[] getProvider();

	/**
	 * Getter for endpoint, returns String for endpoint
	 */
	public String getEndpoint();

	/**
	 * Getter for params, returns String[] for params
	 */
	public String[] getParams();
}



interface DataPurchaseEvent extends Filter {
	/**
	 * Setter for public key String
	 */
	public void setPublicKey(String publicKey);

	/**
	 * Setter for BigInteger amount
	 */
	public void setAmount(BigInteger amount);

	/**
	 * Setter for endpoint String
	 */
	public void setEndpoint(String endpoint);

	/**
	 * Setter for endpoint params, utilizing String[]
	 */
	public void setEndpointParams(String[] endpoint_params);



	/**
	 * Getter for public key, returns String
	 */
	public String getPublicKey();

	/**
	 * Getter for amount, returns BigInteger
	 */
	public BigInteger getAmount();

	/**
	 * Getter for endpoint, returns String for endpoint
	 */
	public String getEndpoint();

	/**
	 * Getter for endpoint params, returns String[] for endpoint params
	 */
	public String[] getEndpointParams();
}



interface SubscriptionEndEvent extends Filter {
	/**
	 * Setter for terminator address, utilizes byte[] for address
	 */
	public void setTerminator(byte[] terminator);



	/**
	 * Getter for terminator, returns byte[]
	 */
	public byte[] getTerminator();
}



interface ParamsPassedEvent {
	/**
	 * Setter for sender address, utilizes byte[] for address
	 */
	public void setSender(byte[] sender);

	/**
	 * Setter for receiver address, utilizes byte[] for address
	 */
	public void setReceiver(byte[] receiver);

	/**
	 * Setter for endpoint String
	 */
	public void setEndpoint(String endpoint);

	/**
	 * Setter for params, utilizing String[]
	 */
	public void setParams(String[] params);


	/**
	 * Getter for sender, returns byte[]
	 */
	public byte[] getSender();

	/**
	 * Getter for provider, returns byte[]
	 */
	public byte[] getProvider();

	/**
	 * Getter for endpoint, returns String for endpoint
	 */
	public String getEndpoint();

	/**
	 * Getter for params, returns String[] for params
	 */
	public String[] getParams();
}