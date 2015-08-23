package by.epam.task2.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.task2.composite.ComponentText;
import by.epam.task2.composite.CompositeText;
import by.epam.task2.composite.SymbolLeaf;

public final class ParserText {

	
	public ParserText() {	
	}

	int count = 0;

	public int getCount() {
		return count;
	}

	// ищем абзцы.
	public ComponentText parseParagraph(String allText) {
		ComponentText text = new CompositeText();

		Pattern pattern = Pattern.compile(ReaderRegex.REGEXP_PARAGRAPH);// получаем regex абзаца
		Matcher matcher = pattern.matcher(allText);// ищем соответстивия
		while (matcher.find()) {
			String paragraph = matcher.group();// извлекаем соответстиве
			paragraph.trim();
			text.add(parseSentence(paragraph));
		}
		return text;
	}

	// парсить на предложенения
	public ComponentText parseSentence(String allSentence) {
		ComponentText paragraph = new CompositeText();
		
		Pattern pattern = Pattern.compile(ReaderRegex.REGEXP_SENTENCE);
		Matcher matcher = pattern.matcher(allSentence);
		while (matcher.find()) {

			String sentence = matcher.group();
			sentence.trim();
			paragraph.add(parseLexem(sentence));
		}
		return paragraph;
	}

	// парсим сразу и на слова и на припенания
	public ComponentText parseLexem(String allLexem) {
		ComponentText sentense = new CompositeText();
		Pattern pattern = Pattern.compile(ReaderRegex.REGEXP_LEXEME);
		Matcher matcher = pattern.matcher(allLexem);
		while (matcher.find()) {
			count++;
			String lexem = matcher.group();
			lexem.trim();
			sentense.add(parseWord(lexem));
		}
		return sentense;
	}

	public ComponentText parseWord(String allWord) {
		ComponentText lexem = new CompositeText();
		Pattern pattern = Pattern.compile(ReaderRegex.REGEXP_WORD);
		Matcher matcher = pattern.matcher(allWord);
		while (matcher.find()) {
			String word = matcher.group();
			word.trim();
			lexem.add(parseSymbols(word));
		}
		return lexem;
	}

	public ComponentText parseSymbols(String allSymbols) {
		ComponentText word = new CompositeText();
		Pattern pattern = Pattern.compile(ReaderRegex.REGEXP_SYMBOL);
		Matcher matcher = pattern.matcher(allSymbols);
		while (matcher.find()) {
			String symbol = matcher.group();
			symbol.trim();
			ComponentText componentSymbol = new SymbolLeaf(symbol);
			word.add(componentSymbol);
		}

		return word;
	}
}
