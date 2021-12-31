package com.effectivejava.util;

public class Util {

    private static final Util INSTANCE = new Util();

    public static Util getInstance()
	{
		return INSTANCE;
	}

    private Util() {}
}
