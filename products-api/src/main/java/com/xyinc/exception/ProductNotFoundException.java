package com.xyinc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceção para produto não encontrado.
 * 
 * @author diogenes.feijo
 *
 */
@ResponseStatus(reason = "Produto não encontrado", code = HttpStatus.NOT_FOUND)
@SuppressWarnings("serial")
public class ProductNotFoundException extends Exception {

}
