package com.lb.parrot.support.convert;

public interface Converter<I, O> {
	
	O convert(I input) throws ConvertException;
	
}
