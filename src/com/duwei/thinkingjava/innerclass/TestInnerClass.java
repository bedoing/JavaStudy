package com.duwei.thinkingjava.innerclass;


public class TestInnerClass {
	
	private Inner inner = this.new Inner();
	
	public void loadInner(){
		inner = new Inner();
	}
	
	class Inner{
		public void say(){
			System.out.println("say");
		}
	}
	
	public static void main(String[] args) {
		
		
	}
}
