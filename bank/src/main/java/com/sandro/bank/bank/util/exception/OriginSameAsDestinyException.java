package com.sandro.bank.bank.util.exception;

public class OriginSameAsDestinyException extends Exception {
	private static final long serialVersionUID = 3338053641804717819L;

	public OriginSameAsDestinyException() {
		super("The origin and the destiny account is the same!");
	}
}
