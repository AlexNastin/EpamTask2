package by.epam.task2.logic;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.task2.composite.ComponentText;

public class Worker {

	public final static String regexOfCheckWord = "[a-zA-Z]+";
	public final static String regexOfConsonantLetter = "[^AaEeIiOoUu]";

	public static boolean checkWord(ComponentText component) {
		boolean check = false;
		String componentString = component.getFirstElement().toString();
		Pattern pattern = Pattern.compile(regexOfCheckWord);
		Matcher matcher = pattern.matcher(componentString);
		if (matcher.find()) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}

	public static boolean checkConsonantLetter(ComponentText component) {
		boolean check = false;
		String componentString = component.getFirstElement().toString();
		Pattern pattern = Pattern.compile(regexOfConsonantLetter);
		Matcher matcher = pattern.matcher(componentString);
		if (matcher.find()) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}

	public static void deleteFirstSymbol(ComponentText text) {
		@SuppressWarnings("unchecked")
		List<ComponentText> listText = (List<ComponentText>) text.getList();
		for (int i = 0; i < listText.size(); i++) {
			ComponentText componentParagraph = text.getChild(i);// получил параграфы
															
			for (int j = 0; j < componentParagraph.getList().size(); j++) {
				ComponentText componentSentence = componentParagraph
						.getChild(j);// получил предложения

				for (int y = 0; y < componentSentence.getList().size(); y++) {
					ComponentText componentLexeme = componentSentence.getChild(y);// получил лексемы

					for (int m = 0; m < componentLexeme.getList().size(); m++) {
						ComponentText componentWord = componentLexeme.getChild(m);// получил слова
						if (checkWord(componentLexeme)) {
							componentWord.removeAll(Collections.singletonList(componentWord.getFirstElement()));
						}
					}
				}
			}
		}
	}

	public static void deleteWordOfSize(ComponentText text, int sizeWord) {
		@SuppressWarnings("unchecked")
		List<ComponentText> listText = (List<ComponentText>) text.getList();
		for (int i = 0; i < listText.size(); i++) {
			ComponentText componentParagraph = text.getChild(i);// получил параграфы
															
			for (int j = 0; j < componentParagraph.getList().size(); j++) {
				ComponentText componentSentence = componentParagraph.getChild(j);// получил предложения

				for (int y = 0; y < componentSentence.getList().size(); y++) {
					ComponentText componentLexeme = componentSentence.getChild(y);// получил лексемы

					for (int m = 0; m < componentLexeme.getList().size(); m++) {
						ComponentText componentWord = componentLexeme.getChild(m);// получил слова
					
						if (sizeWord == componentWord.getList().size()&& checkConsonantLetter(componentLexeme.getFirstElement())) {
							componentLexeme.remove(componentWord);
						}
					}
				}
			}
		}
	}
}
