package ceaser.addtwonumbers;

import java.util.Random;

public class AddTwoNumbers {
	Node A = new Node(1,0);
	Node B = new Node(1,0);
	public static void main(String[] args) {
		AddTwoNumbers an = new AddTwoNumbers();
		an.init();
		an.sumAandB();
	}
	
	
	public void init (){
		System.out.println("========init========");
		Random r  = new Random();
		A.next=new Node(r.nextInt(10),0);
		Node atemp =null;
		int a = 0;
		int b = 0;
		for(atemp = A;atemp!=null;atemp=atemp.next){
			if(a==5){
				break;
			}
			atemp.next = new Node(r.nextInt(10),0);
			a++;
		}
		B.next=new Node(r.nextInt(10),0);
		Node btemp =null;
		for(btemp = B;btemp!=null;btemp=btemp.next){
			if(b==9){
				break;
			}
			btemp.next = new Node(r.nextInt(10),0);
			b++;
		}
		Node patemp=null;
		Node pbtemp=null;
		System.out.println("A:");
		for (patemp = A;patemp.next!=null;patemp = patemp.next) {
			System.out.print(patemp.data);
		}
		System.out.println();
		System.out.println("B:");
		for (pbtemp = B;pbtemp.next!=null;pbtemp = pbtemp.next) {
			System.out.print(pbtemp.data);
		}
	}
	
	public void sumAandB(){
		System.out.println();
		System.out.println("========sumAandB========");
		Node atemp =null;
		Node btemp =null;
		Node cNode =null;
		Node cHNode =null;
		int flag = 0;
		int globalCarry = 0;
		for(btemp = B,atemp = A;null!=btemp && null!=atemp;btemp=btemp.next,atemp=atemp.next){
			//Node bNode= btemp.next;
				//Node aNode= atemp.next;
					int sum = btemp.data+atemp.data+btemp.carry+atemp.carry;
					int carry = 0;
					if(sum>9){
						carry = 1;
						if(null!=btemp.next){
							btemp.next.carry = carry;
						}else if(null!=atemp.next){
							atemp.next.carry = carry;
						}else{
							globalCarry = carry;
						}
					}
					Node ctempNode = new Node(sum%10,0);
					if(flag==0){
						cHNode = ctempNode;
						cNode = ctempNode;
					}else{
						cNode.next = ctempNode;
						cNode = ctempNode;
					}
					flag++;
					//System.out.println("---");
		}
		
		if(null!=atemp){
			while(null!=atemp){
				cNode.next = new Node(atemp.data+atemp.carry,atemp.carry);
				atemp = atemp.next;
				cNode = cNode.next;
			}
		}else if(null!=btemp){
			while(null!=btemp){
				cNode.next = new Node(btemp.data+btemp.carry,btemp.carry);
				btemp = btemp.next;
				cNode = cNode.next;
			}
		}else{
			cNode.next = new Node(globalCarry,0);
		}
		
		System.out.println("A add B :");
		while(null!=cHNode){
			System.out.print(cHNode.data);
			cHNode = cHNode.next;
		}
		
	}
	
}
