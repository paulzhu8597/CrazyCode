package com.ceaser._002addtwonumbers;

public class Node {
	public Node() {
		super();
	}
	public int data;//节点数据
	public int carry; //进位
	public Node next;
	public Node(int data, int carry) {
		super();
		this.data = data;
		this.carry = carry;
	}
}
