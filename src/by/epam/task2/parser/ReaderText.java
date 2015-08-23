package by.epam.task2.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import by.epam.task2.exeption.TechnicalExeption;

public final class ReaderText {

	private static final Logger LOG = Logger.getLogger(ReaderText.class);

	private static BufferedReader reader;

	public static String parserText(String fileName) {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			reader = new BufferedReader(new FileReader(fileName));
			while (reader.ready()) {
				stringBuilder.append(reader.readLine() + "\r\n");
			}

		} catch (IOException e) {
			LOG.warn(new TechnicalExeption(e));
		}
		return stringBuilder.toString();
	}
}
