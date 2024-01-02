package com.sandro.bank.bank.service.validation.user;

import java.util.InputMismatchException;

public class CpfValidator {

	public static Boolean validate(Long cpf) {
		String SOMENTE_ZEROS = "00000000000";
		String SOMENTE_UM = "11111111111";
		String SOMENTE_DOIS = "22222222222";
		String SOMENTE_TRES = "33333333333";
		String SOMENTE_QUATRO = "44444444444";
		String SOMENTE_CINCO = "55555555555";
		String SOMENTE_SEIS = "66666666666";
		String SOMENTE_SETE = "77777777777";
		String SOMENTE_OITO = "88888888888";
		String SOMENTE_NOVE = "99999999999";
		if (cpf.equals(SOMENTE_ZEROS) || cpf.equals(SOMENTE_UM) || cpf.equals(SOMENTE_DOIS) || cpf.equals(SOMENTE_TRES)
				|| cpf.equals(SOMENTE_QUATRO) || cpf.equals(SOMENTE_CINCO) || cpf.equals(SOMENTE_SEIS)
				|| cpf.equals(SOMENTE_SETE) || cpf.equals(SOMENTE_OITO) || cpf.equals(SOMENTE_NOVE)
				|| (cpf.toString().length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (int) (cpf.toString().charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);

			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (cpf.toString().charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			if ((dig10 == cpf.toString().charAt(9)) && (dig11 == cpf.toString().charAt(10))) {
				return (true);
			} else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}
}
