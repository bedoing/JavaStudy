package com.duwei.classloading.classloader;

public class ClassLoaderTest {

	public static void main(String[] args) {
		ClassLoader loader = ClassLoaderTest.class.getClassLoader();    
		//��ü���ClassLoaderTest.class�������������
		while(loader != null) {
		    System.out.println(loader);
		    loader = loader.getParent();    //��ø��������������
		}
		//System.out.println(loader);
	}

}
