package com.youku;

import java.util.HashMap;
/**
 * ʹ��==������ж϶����Ƿ����
 * @author ��ΰ
 *
 */
public class JAVA_01 {
	
	public static void main(String[] args) {
		A classa = new A("he");
		A classb = new A("he");
		System.out.println(classa == classb);//false
		System.out.println(classa.equals(classb));//false
	}
}
class A{
	public A(String str){}
	
	@Override
	public boolean equals(Object obj) {
		return this.hashCode()==obj.hashCode();//false,�Զ���equals����
		//return super.equals(obj);// ���ࣺreturn (this == obj);
	}
}
