package com.api.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class StackTraceUtil {

	private StackTraceUtil() {
	}
	
	public static String parse(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		return sw.toString();
	}
}
