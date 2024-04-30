package com.rocoplayer.app.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @author ZJ
 *
 */
public class IOUtil {

	public static void copy(InputStream in, OutputStream os) {
		
		byte[] buffer = new byte[4096];
		while (true) {
			try {
				int read = in.read(buffer);
				if(read < 0) {
					break;
				}
				
				os.write(buffer, 0, read);
			} catch (IOException e) {
				break;
			}
		}
		
		try {
			os.close();
			in.close();
		} catch (IOException e) {
		}
	}
}
