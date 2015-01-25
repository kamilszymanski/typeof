package com.nurkiewicz.typeof;

public class WhenTypeOf<S> {

	private S object;

	WhenTypeOf(S object) {
		this.object = object;
	}

	public <T> FirstIs<S, T> is(Class<T> type) {
		return new FirstIs<>(object, type);
	}
}
