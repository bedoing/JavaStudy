package com.duwei.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public void MDAl(String content){
		//�����㷨��MD5��SHA��CRC
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] result = digest.digest(content.getBytes());
		//��ϢժҪ�Ľ��һ�㶼��ת����16 �����ַ�����ʽչʾ
		//String hex = Hex.encode(result);
		//MD5 ���Ϊ16 �ֽڣ�128 ������λ����ת��Ϊ16 ���Ʊ�ʾ�󳤶���32 ���ַ�
		//SHA ���Ϊ20 �ֽڣ�160 ������λ����ת��Ϊ16 ���Ʊ�ʾ�󳤶���40 ���ַ�
		//System.out.println(hex);
	}

}
