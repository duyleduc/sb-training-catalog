package com.training.sbtrainingcatalog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST,reason = "catalogID already exists")
public class CatalogAlreadyExists extends RuntimeException{
}
