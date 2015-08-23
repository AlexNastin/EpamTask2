package by.epam.task2.print;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

import by.epam.task2.composite.ComponentText;
import by.epam.task2.exeption.TechnicalExeption;

public final class OutputText {

	private static final Logger LOG = Logger.getLogger(OutputText.class);

	final String fileName = "outputText.txt";
	public void printText(ComponentText text){
		try {
			
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
			bufferedWriter.write(text.toString());
			bufferedWriter.close();
			
		} catch (IOException e) {
			LOG.warn(new TechnicalExeption(e));
		}
	}
}
