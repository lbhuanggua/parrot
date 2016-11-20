package com.lb.parrot.support.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {
	
	public static String readFromInputStream(InputStream inputStream,
			String encode) throws Exception {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buf = new byte[4096];
		int n = 0;
		while ((n = inputStream.read(buf)) > 0) {
			outputStream.write(buf, 0, n);
		}
		return new String(outputStream.toByteArray(), encode);
	}

	public static void writeToOutputStream(OutputStream outputStream,
			String content, String encode) throws Exception {
		outputStream.write(content.getBytes(encode));
	}
}
