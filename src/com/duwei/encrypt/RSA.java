package com.duwei.encrypt;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSA {
	//һ���Լ������ݵĳ��Ȳ��ܴ���117 �ֽ�
	private static final int ENCRYPT_BLOCK_MAX = 117;
	//һ���Խ��ܵ����ݳ��Ȳ��ܴ���128 �ֽ�
	private static final int DECRYPT_BLOCK_MAX = 128;

	public static void main(String[] args) {

	}
	/**
	 * RSA���ܽ���API
	 * @param content
	 */
	public void encryptRsa(String content) {
		try {
			// 1����ȡcipher ����
			Cipher cipher = Cipher.getInstance("RSA");
			// 2��ͨ����Կ��������KeyPairGenerator ���ɹ�Կ��˽Կ
			KeyPair keyPair = KeyPairGenerator
					.getInstance("RSA")
					.generateKeyPair();
			PublicKey publicKey = keyPair.getPublic();//��Կ
			PrivateKey privateKey = keyPair.getPrivate();//˽Կ
			// 3,ʹ�ù�Կ��ʼ��������
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			// 4��ִ�м��ܲ���
			byte[] result = cipher.doFinal(content.getBytes());
			// ʹ��˽Կ��ʼ��������
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			// ִ�н��ܲ���
			byte[] deResult = cipher.doFinal(result);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
