package com.xyinc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceção para produto inválido.
 * 
 * @author diogenes.feijo
 *
 */
@ResponseStatus(reason = "Produto inválido", code = HttpStatus.BAD_REQUEST)
@SuppressWarnings("serial")
public class InvalidProductException extends Exception {
	
}
