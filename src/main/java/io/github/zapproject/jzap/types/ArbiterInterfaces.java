// package io.github.zapproject.jzap.types;

// import java.math.BigInteger;



// abstract class SubscriptionInit extends DefaultTx {
// 	/**
// 	 * Setter for provider address, utilizes byte[] for address
// 	 */
// 	public abstract void setProvider(byte[] provider);

// 	/**
// 	 * Setter for endpoint String
// 	 */
// 	public abstract void setEndpoint(String endpoint);

// 	/**
// 	 * Setter for endpoint params, utilizing String[]
// 	 */
// 	public abstract void setEndpointParams(String[] endpoint_params);

// 	/**
// 	 * Setter for BigInteger representing blocks
// 	 */
// 	public abstract void setBlocks(BigInteger blocks);

// 	/**
// 	 * Setter for BigInteger representing pubkey
// 	 */
// 	public abstract void setPubkey(BigInteger pubkey);



// 	/**
// 	 * Getter for provider address, returns byte[] for address
// 	 */
// 	public abstract byte[] getProvider();

// 	/**
// 	 * Getter for endpoint, returns String for endpoint
// 	 */
// 	public abstract String getEndpoint();

// 	/**
// 	 * Getter for endpoint params, returns String[] for endpoint params
// 	 */
// 	public abstract String[] getEndpointParams();

// 	/**
// 	 * Getter for blocks, returns BigInteger
// 	 */
// 	public abstract BigInteger getBlocks();

// 	/**
// 	 * Getter for pubkey, returns BigInteger
// 	 */
// 	public abstract BigInteger getPubkey();
// }



// abstract class SubscriptionEnd extends DefaultTx {
// 	/**
// 	 * Setter for provider address, utilizes byte[] for address
// 	 */
// 	public abstract void setProvider(byte[] provider);

// 	/**
// 	 * Setter for subscriber address, utilizes byte[] for address
// 	 */
// 	public abstract void setSubscriber(byte[] subscriber);

// 	/**
// 	 * Setter for endpoint String
// 	 */
// 	public abstract void setEndpoint(String endpoint);


// 	/**
// 	 * Getter for provider address, returns byte[] for address
// 	 */
// 	public abstract byte[] getProvider();

// 	/**
// 	 * Getter for subscriber address, returns byte[] for address
// 	 */
// 	public abstract byte[] getSubscriber();

// 	/**
// 	 * Getter for endpoint, returns String for endpoint
// 	 */
// 	public abstract String getEndpoint();
// }



// abstract class SubscriptionType extends DefaultTx {
// 	/**
// 	 * Setter for provider address, utilizes byte[] for address
// 	 */
// 	public abstract void setProvider(byte[] provider);

// 	/**
// 	 * Setter for subscriber address, utilizes byte[] for address
// 	 */
// 	public abstract void setSubscriber(byte[] subscriber);

// 	/**
// 	 * Setter for endpoint String
// 	 */
// 	public abstract void setEndpoint(String endpoint);


// 	/**
// 	 * Getter for provider address, returns byte[] for address
// 	 */
// 	public abstract byte[] getProvider();

// 	/**
// 	 * Getter for subscriber address, returns byte[] for address
// 	 */
// 	public abstract byte[] getSubscriber();

// 	/**
// 	 * Getter for endpoint, returns String for endpoint
// 	 */
// 	public abstract String getEndpoint();
// }



// abstract class SubscriptionParams extends DefaultTx {
// 	/**
// 	 * Setter for receiver address, utilizes byte[] for address
// 	 */
// 	public abstract void setReceiver(byte[] receiver);

// 	/**
// 	 * Setter for endpoint String
// 	 */
// 	public abstract void setEndpoint(String endpoint);

// 	/**
// 	 * Setter for params, utilizing String[]
// 	 */
// 	public abstract void setParams(String[] params);


// 	/**
// 	 * Getter for provider address, returns byte[] for address
// 	 */
// 	public abstract byte[] getProvider();

// 	/**
// 	 * Getter for endpoint, returns String for endpoint
// 	 */
// 	public abstract String getEndpoint();

// 	/**
// 	 * Getter for params, returns String[] for params
// 	 */
// 	public abstract String[] getParams();
// }



// abstract class DataPurchaseEvent extends Filter {
// 	/**
// 	 * Setter for public key String
// 	 */
// 	public abstract void setPublicKey(String publicKey);

// 	/**
// 	 * Setter for BigInteger amount
// 	 */
// 	public abstract void setAmount(BigInteger amount);

// 	/**
// 	 * Setter for endpoint String
// 	 */
 
// 	public abstract void setEndpoint(String endpoint);

// 	/**
// 	 * Setter for endpoint params, utilizing String[]
// 	 */
// 	public abstract void setEndpointParams(String[] endpoint_params);



// 	/**
// 	 * Getter for public key, returns String
// 	 */
// 	public abstract String getPublicKey();

// 	/**
// 	 * Getter for amount, returns BigInteger
// 	 */
// 	public abstract BigInteger getAmount();

// 	/**
// 	 * Getter for endpoint, returns String for endpoint
// 	 */
 
// 	public abstract String getEndpoint();

// 	/**
// 	 * Getter for endpoint params, returns String[] for endpoint params
// 	 */
// 	public abstract String[] getEndpointParams();
// }



// abstract class SubscriptionEndEvent extends Filter {
// 	/**
// 	 * Setter for terminator address, utilizes byte[] for address
// 	 */
// 	public abstract void setTerminator(byte[] terminator);



// 	/**
// 	 * Getter for terminator, returns byte[]
// 	 */
// 	public abstract byte[] getTerminator();
// }



// interface ParamsPassedEvent {
// 	/**
// 	 * Setter for sender address, utilizes byte[] for address
// 	 */
// 	public void setSender(byte[] sender);

// 	/**
// 	 * Setter for receiver address, utilizes byte[] for address
// 	 */
// 	public void setReceiver(byte[] receiver);

// 	/**
// 	 * Setter for endpoint String
// 	 */
// 	public void setEndpoint(String endpoint);

// 	/**
// 	 * Setter for params, utilizing String[]
// 	 */
// 	public void setParams(String[] params);


// 	/**
// 	 * Getter for sender, returns byte[]
// 	 */
// 	public byte[] getSender();

// 	/**
// 	 * Getter for provider, returns byte[]
// 	 */
// 	public byte[] getProvider();

// 	/**
// 	 * Getter for endpoint, returns String for endpoint
// 	 */
// 	public String getEndpoint();

// 	/**
// 	 * Getter for params, returns String[] for params
// 	 */
// 	public String[] getParams();
// }