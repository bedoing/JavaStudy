package com.duwei.designpattern.state2;

public class Context {

	private State state; // ά��һ���Գ���״̬���������
	private int value; // ��������ֵ��������ֵ�ı仯���ܻᵼ�¶���״̬�����仯

	// ����״̬����
	public void setState(State state) {
		this.state = state;
	}

	public void request() {
		// ��������
		state.handle(); // ����״̬�����ҵ�񷽷�
		// ��������
	}
}
