package com.test1;

public class TextEditor {
	private SpellChecker spellthoi;
	public TextEditor(SpellChecker spellcheck)
	{
		System.out.println("Inside TextEditor");
		this.spellthoi = spellcheck;
	}
	public void spellCheck()
	{
		spellthoi.checkSpelling();
	}
	
}
