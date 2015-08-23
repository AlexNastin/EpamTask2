package by.epam.task2.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import by.epam.task2.exeption.TechnicalExeption;

public final class ReaderRegex {

	private static final Logger LOG = Logger.getLogger(ReaderRegex.class);

	public static final String path = "src/Regex.properties";
	
	private static final String namePropertyOfParagraph = "paragraph";
	private static final String namePropertyOfSentence = "sentence";
	private static final String namePropertyOfLexeme = "lexeme";
	private static final String namePropertyOfWord = "word";
	private static final String namePropertyOfSymbol = "symbol";

	public static final String REGEXP_PARAGRAPH;
	public static final String REGEXP_SENTENCE;
	public static final String REGEXP_LEXEME;
	public static final String REGEXP_WORD;
	public static final String REGEXP_SYMBOL;

	static {
		BufferedReader reader;

		List<String> regexList = new ArrayList<String>();
		try {
			Properties property = new Properties();
			reader = new BufferedReader(new FileReader(path));
			property.load(reader);
			String regexParagraph = property.getProperty(namePropertyOfParagraph);
			regexList.add(regexParagraph);
			String regexSentence = property.getProperty(namePropertyOfSentence);
			regexList.add(regexSentence);
			String regexLexeme = property.getProperty(namePropertyOfLexeme);
			regexList.add(regexLexeme);
			String regexWord = property.getProperty(namePropertyOfWord);
			regexList.add(regexWord);
			String regexSymbol = property.getProperty(namePropertyOfSymbol);
			regexList.add(regexSymbol);
		} catch (IOException e) {
			LOG.warn(new TechnicalExeption(e));
		}
		REGEXP_PARAGRAPH = regexList.get(0);
		REGEXP_SENTENCE = regexList.get(1);
		REGEXP_LEXEME = regexList.get(2);
		REGEXP_WORD = regexList.get(3);
		REGEXP_SYMBOL = regexList.get(4);
	}
}
