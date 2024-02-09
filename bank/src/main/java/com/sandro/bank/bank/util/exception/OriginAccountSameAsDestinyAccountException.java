package com.sandro.bank.bank.util.exception;

public class OriginAccountSameAsDestinyAccountException extends Exception {
	private static final long serialVersionUID = 3338053641804717819L;

	public OriginAccountSameAsDestinyAccountException() {
		super("The origin account is the same of destiny account!");
	}
}
