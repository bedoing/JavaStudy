package com.duweri.interview;
/**
 * λ����Demo
 * @author ��ΰ
 * 
 */
public class BitCompute {

	public static void main(String[] args) {
		//���
		int a = 8;//1000
		int b = 9;//1001
		System.out.println("a^b = "+(a^b));
		
		int x = 15;//01111=1+2+4+8
		int y = 23;//10111=1+2+4+16
		System.out.println("x^y = "+(x^y));
		
		//������
		System.out.println("x&y = "+(x&y));
		
		//������
		System.out.println("x|y = "+ (x|y));
		
		//����������
		System.out.println("8>>2 = "+(8>>2));
		System.out.println("8<<2 = "+(8<<2));
		
		//~		ԭ��01000�Ž�������ò��룺01000��
		//ȡ�����㣺10111�����ǲ��룩�����Դ�루ȡ����1������λ���䣩��11001
		System.out.println("~ = "+(~8));
		
		System.out.println("8>>>2="+(8>>>2));
		
	}

}
