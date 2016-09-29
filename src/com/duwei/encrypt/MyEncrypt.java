package com.duwei.encrypt;

public class MyEncrypt {
	public static void main(String[] args) {
		
	}
	
	/**
     * ����
     * @param input ����Դ����Ҫ���ܵ����ݣ�
     * @param key ��Կ����ƫ����
     * @return ���ؼ��ܺ������
     */
    public static String encrypt(String input, int key) {
        //�õ��ַ������ÿһ���ַ�
        char[] array = input.toCharArray();
        for (int i = 0; i < array.length; ++i) {
            //�ַ�ת����ASCII ��ֵ
            int ascii = array[i];
            //�ַ�ƫ�ƣ�����a->b
            ascii = ascii + key;
            //ASCII ��ֵת��Ϊchar
            char newChar = (char) ascii;
            //�滻ԭ���ַ�
            array[i] = newChar;

            //����4 �д�����Լ�дΪһ��
            //array[i] = (char) (array[i] + key);
        }
        //�ַ�����ת����String
        return new String(array);
    }

    /**
     * ����
     * @param input ����Դ�������ܺ�����ݣ�
     * @param key ��Կ����ƫ����
     * @return ���ؽ��ܺ������
     */
    public static String decrypt(String input, int key) {
        //�õ��ַ������ÿһ���ַ�
        char[] array = input.toCharArray();
        for (int i = 0; i < array.length; ++i) {
            //�ַ�ת����ASCII ��ֵ
            int ascii = array[i];
            //�ָ��ַ�ƫ�ƣ�����b->a
            ascii = ascii - key;
            //ASCII ��ֵת��Ϊchar
            char newChar = (char) ascii;
            //�滻ԭ���ַ�
            array[i] = newChar;

            //����4 �д�����Լ�дΪһ��
            //array[i] = (char) (array[i] - key);
        }

        //�ַ�����ת����String
        return new String(array);
    }
}
