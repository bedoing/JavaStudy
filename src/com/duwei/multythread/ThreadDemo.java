package com.duwei.multythread;
/**
 * ����Thread.start&&Thread.run�����𣡣���
 * @author ��ΰ
 */
public class ThreadDemo {

	public static void main(String[] args) {
//		Thread thread = new Thread("t1"){
//			@Override
//			public void run(){
//				System.out.println(Thread.currentThread().getName());
//			}
//		};
//		thread.start();
//----------------------------------------
		Thread thread = new Thread("t1"){
			@Override
			public void run(){
				System.out.println(Thread.currentThread().getName());
			}
		};
		thread.run();
	}

}
