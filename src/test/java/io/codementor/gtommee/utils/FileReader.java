package io.codementor.gtommee.utils;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

public class FileReader {

	public static String loadFromResources(ClassLoader classLoader, String file) throws IOException {
		InputStream stream = classLoader.getResourceAsStream(file);

		String out;
		try {
			out = IOUtils.toString(stream, "UTF-8");
		} finally {
			stream.close();
		}

		return out;
	}

}
