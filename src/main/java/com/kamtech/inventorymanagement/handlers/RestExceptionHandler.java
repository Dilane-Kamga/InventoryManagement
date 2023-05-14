package com.kamtech.inventorymanagement.handlers;

import com.kamtech.inventorymanagement.exception.EntityNotFoundException;
import com.kamtech.inventorymanagement.exception.ErrorCodes;
import com.kamtech.inventorymanagement.exception.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleException(EntityNotFoundException entityNotFoundException, WebRequest webRequest){

        final HttpStatus notFound = HttpStatus.NOT_FOUND;

        final ErrorDto errorDto = ErrorDto.builder()
                .errorCodes(entityNotFoundException.getErrorCodes())
                .httpCode(notFound.value())
                .message(entityNotFoundException.getMessage())
                .build();


        return new ResponseEntity<>(errorDto, notFound);
    }

    public ResponseEntity<ErrorDto> handleException(InvalidEntityException invalidEntityException, WebRequest webRequest){

        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        final ErrorDto errorDto = ErrorDto.builder()
                .errorCodes(invalidEntityException.getErrorCodes())
                .httpCode(badRequest.value())
                .errors(invalidEntityException.getErrors())
                .message(invalidEntityException.getMessage())
                .build();

        return new ResponseEntity<>(errorDto, badRequest);
    }
}
