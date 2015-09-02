// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Test.java

package product;

import java.io.PrintStream;

public class Test
{

	public Test()
	{
	}

	public static void main(String args[])
	{
		String a = "hello2";
		String b = "hello";
		String c = "hello";
		String d = "hello2";
		String e = (new StringBuilder(String.valueOf(c))).append(2).toString();
		System.out.println((new StringBuilder("d=")).append(d).toString());
		System.out.println((new StringBuilder("e=")).append(e).toString());
		System.out.println(a == d);
		System.out.println(a == e);
		System.out.println(e == "hello2");
	}
}
