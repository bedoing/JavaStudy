package com.youku;
/**
 * ����顣��̬����飬���캯������������ĳ�ʼ������
 * @author ��ΰ
 */
public class JAVA_03 extends HelloA {

	public JAVA_03() {
		System.out.println("JAVA_03���캯��");
	}
	//�����
	{
		System.out.println("JAVA_03�����");
	}
	//��̬�����
	static {
		System.out.println("JAVA_03��̬�����");
	}

	public static void main(String[] args) {
		new JAVA_03();
	}

}

class HelloA {
	public HelloA() {
		System.out.println("A���캯��");
	}

	{
		System.out.println("A�Ĵ����");
	}

	static {
		System.out.println("A�ľ�̬�����");
	}

}
