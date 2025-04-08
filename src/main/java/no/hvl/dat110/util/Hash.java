package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	
	public static BigInteger hashOf(String entity) {

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] digest = md.digest(entity.getBytes("UTF-8"));

			BigInteger hashint = new BigInteger(1, digest);

			return hashint;
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static BigInteger addressSize() {

		int bits = bitSize(); // 128
		BigInteger size = BigInteger.valueOf(2).pow(bits); // 2^128
		return size;
	}
	
	public static int bitSize() {

		int digestlen = 0;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			digestlen = md.getDigestLength(); // i bytes
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return digestlen * 8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
