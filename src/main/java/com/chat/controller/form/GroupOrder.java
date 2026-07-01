package com.chat.controller.form;

import jakarta.validation.GroupSequence;

//Set validification check order
@GroupSequence({ValidGroup1.class, ValidGroup2.class})
	public interface GroupOrder{
}

