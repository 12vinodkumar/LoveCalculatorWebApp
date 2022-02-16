package com.example.lc.propertyEditor;

import java.beans.PropertyEditorSupport;

import org.springframework.lang.Nullable;

public class NameCustomEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(@Nullable String text) {
		
		String MyConvertedStr =	text.toUpperCase();
			setValue(MyConvertedStr);
		

	}

}
