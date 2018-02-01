package com.duwei.multythread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCallableDemo {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();//�̳߳�
		
		Task task = new Task();//����
		Future<Integer> result = executorService.submit(task);//�ύ���񣬷���һ��Future
		//Future���Ƕ��ھ����Runnable����Callable�����ִ�н������ȡ����
		//��ѯ�Ƿ���ɡ���ȡ�������Ҫʱ����ͨ��get������ȡִ�н�����÷���������ֱ�����񷵻ؽ����
		
		executorService.shutdown();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("���߳���ִ��");
		
		try {
			System.out.println("task���н��"+result.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("��������ִ�����");
	}

	static class Task implements Callable<Integer>{

		@Override
		public Integer call() throws Exception {//�н�����صģ�ִ�к�ʱ��������
			System.out.println("���߳��ڽ�����");
			Thread.sleep(3000);
			int sum = 0;
			for (int i = 0; i < 100; i++) {
				sum +=i;
			}
			return sum;
		}

	}

}


