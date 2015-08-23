package by.epam.task2.main;

import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;

import by.epam.task2.composite.ComponentText;
import by.epam.task2.logic.Worker;
import by.epam.task2.parser.ParserText;
import by.epam.task2.parser.ReaderText;
import by.epam.task2.print.OutputText;

public class Main {
	static {
		new DOMConfigurator().doConfigure("log4j.xml",
				LogManager.getLoggerRepository());
	}

	public static void main(String[] args) {

		OutputText outputText = new OutputText();

		final String FILE_NAME_TEXT = "text.txt";
		
		String readerText = ReaderText.parserText(FILE_NAME_TEXT);
		
		ParserText parserText = new ParserText();
		parserText.parseParagraph(readerText);

		ComponentText text = parserText.parseParagraph(readerText);

		int size = 3;
		Worker.deleteFirstSymbol(text);
		Worker.deleteWordOfSize(text, size);
		outputText.printText(text);
	}
}
