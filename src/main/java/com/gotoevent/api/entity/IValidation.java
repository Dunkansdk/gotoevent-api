package com.gotoevent.api.entity;

public interface IValidation<T> {
	
	boolean validateNullEmpty();
    boolean validateNullEmptyIdentifier();

}
