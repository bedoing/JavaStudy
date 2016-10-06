package com.duwei.designpattern.singleton;

class StaticInnerSingleton {  
    private StaticInnerSingleton() {}  
      
    private static class HolderClass {  
    	//��̬ʵ�������࣬����HolderClass������һ��Singletonʵ����
    	//��֤�̰߳�ȫ
        private final static StaticInnerSingleton instance = new StaticInnerSingleton();  
    }  
      
    public static StaticInnerSingleton getInstance() {  
        return HolderClass.instance;  
        //��ʼ����ʱ�ų�ʼ���ⲿ�����������
    }  
}  
