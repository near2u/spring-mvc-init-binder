package com.project.custome.edit;

import java.beans.PropertyEditorSupport;

public class StudentNameCustomeEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String name) throws IllegalArgumentException {
		if(name!=null && !name.isEmpty()){
			setValue(name.toUpperCase());
		}
	
	}
}
