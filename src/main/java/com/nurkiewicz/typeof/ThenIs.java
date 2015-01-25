package com.nurkiewicz.typeof;

import java.util.function.Consumer;

/**
 * @author Tomasz Nurkiewicz
 * @since 22.09.13, 21:39
 */
public class ThenIs<S, T> {

	final Then<S> parent;
	private final Class<T> expectedType;

	ThenIs(Then<S> parent, Class<T> expectedType) {
		this.parent = parent;
		this.expectedType = expectedType;
	}

	public Then<S> then(Consumer<T> thenBlock) {
		if (matchingType()) {
			thenBlock.accept(castObject());
			return new TerminalThen<>();
		}
		return parent;
	}

	private T castObject() {
		return (T) parent.unwrap();
	}

	private boolean matchingType() {
		S object = parent.unwrap();
		return object != null && expectedType.isAssignableFrom(object.getClass());
	}
}
