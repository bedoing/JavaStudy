package com.duwei.multythread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * ����������������
 * http://developer.51cto.com/art/201508/487488.htm
 *
 * @author ��ΰ
 */
public class ProducerConsumerInJava {

    public static void main(String args[]) {
        System.out.println("�����java��ʹ�� wait and notify");
        System.out.println("�������������������");
        Queue<Integer> buffer = new LinkedList<>();
        int maxSize = 10;
        Thread producer = new Producer(buffer, maxSize, "PRODUCER");
        Thread consumer = new Consumer(buffer, maxSize, "CONSUMER");
        producer.start();
        consumer.start();
    }
}

class Producer extends Thread {
    private Queue<Integer> queue;
    private int maxSize;

    public Producer(Queue<Integer> queue, int maxSize, String name) {
        super(name);
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        System.out.println("������,�����ߵȴ� ");
                        queue.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                Random random = new Random();
                int i = random.nextInt();
                System.out.println("����ֵ : " + i);
                queue.add(i);
                queue.notifyAll();
            }
        }
    }
}

class Consumer extends Thread {
    private Queue<Integer> queue;
    private int maxSize;

    public Consumer(Queue<Integer> queue, int maxSize, String name) {
        super(name);
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    System.out.println("���п�" + "-�����ߵȴ�-" + "�����߷�����");
                    try {
                        queue.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                System.out.println("���� : " + queue.remove());
                queue.notifyAll();
            }
        }
    }
} 