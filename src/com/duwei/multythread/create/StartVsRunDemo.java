package com.duwei.multythread.create;
/**
 * 调用Thread.start&&Thread.run的区别！！！
 * @author 杜伟
 */
public class StartVsRunDemo {

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
