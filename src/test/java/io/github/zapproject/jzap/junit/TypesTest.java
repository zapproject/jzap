package io.github.zapproject.jzap.junit;

import io.github.zapproject.jzap.types.ArbiterTypes.SubscriptionInit;
import io.github.zapproject.jzap.types.BondageTypes.TokenBondType;
import io.github.zapproject.jzap.types.CurveTypes.CurveType;
import io.github.zapproject.jzap.types.DispatchTypes.ResponseArgs;
import io.github.zapproject.jzap.types.ProviderTypes.InitProvider;
import io.github.zapproject.jzap.types.RegistryTypes.Endpoint;
import io.github.zapproject.jzap.types.TokenDotFactoryTypes.NextEndpoint;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TypesTest {
	static String provider;
	static byte[] endpoint = new byte[32];
	static List <byte[]> params = new ArrayList<byte[]>();
	static List <BigInteger> cur = new ArrayList<BigInteger>();

	TypesTest () {
		super();
	}

	@BeforeAll
	static void setup() {
		provider = "provider";
		System.arraycopy("endpoint".getBytes(), 0, endpoint, 0, 8);
		params.add(endpoint);
		cur.add(new BigInteger("1"));
	}

	@Test
	void testArbiterTypes() {
		SubscriptionInit subInit = new SubscriptionInit();
		subInit.provider = provider;
		subInit.endpoint = endpoint;
		subInit.endpointParams = params;
		subInit.blocks = new BigInteger("1");
		subInit.pubKey = new BigInteger("1");

		assertEquals(provider, subInit.provider);
		assertEquals(endpoint, subInit.endpoint);
		assertEquals(params.get(0)[0], subInit.endpointParams.get(0)[0]);
		assertEquals(1, subInit.blocks.intValue());
		assertEquals(1, subInit.pubKey.intValue());
	}

	@Test
	void testBondageTypes() {
		TokenBondType tb = new TokenBondType();
		tb.endpoint = endpoint;
		tb.dots = new BigInteger("1");

		assertEquals(endpoint, tb.endpoint);
		assertEquals(1, tb.dots.intValue());
	}

	@Test
	void testCurveTypes() {
		CurveType curve = new CurveType();
		curve.curve = cur;
		
		assertEquals(1, curve.curve.get(0).intValue());
	}

	@Test
	void testDispatchTypes() {
		List<String> list = new ArrayList<String>();
		list.add("response");
		ResponseArgs args = new ResponseArgs();
		args.queryID = new BigInteger("1");
		args.responseParams = list;
		args.dynamic = true;

		assertEquals(1, args.queryID.intValue());
		assertEquals("response", args.responseParams.get(0));
		assertEquals(true, args.dynamic);
	}

	@Test
	void testProviderTypes() {
		InitProvider prov = new InitProvider();
		prov.publicKey = new BigInteger("1");
		prov.title = "title".getBytes();

		assertEquals(1, prov.publicKey.intValue());
		assertEquals("title".getBytes()[0], prov.title[0]);
	}

	@Test
	void testRegistryTest() {
		Endpoint ep = new Endpoint();
		ep.endpoint = endpoint;

		assertEquals(endpoint, ep.endpoint);
	}

	@Test
	void testTokenDotFactoryTypes() {
		NextEndpoint next = new NextEndpoint();
		next.provider = provider;
		next.endpoint = endpoint;

		assertEquals(provider, next.provider);
		assertEquals(endpoint, next.endpoint);
	}
}
