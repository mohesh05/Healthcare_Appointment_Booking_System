package com.healthcare.exception;
import java.util.*;import org.springframework.http.*;import org.springframework.web.bind.MethodArgumentNotValidException;import org.springframework.web.bind.annotation.*;
@RestControllerAdvice
public class GlobalExceptionHandler {
 @ExceptionHandler(ApiException.class) public ResponseEntity<Map<String,String>> handle(ApiException e){ return ResponseEntity.badRequest().body(Map.of("error",e.getMessage())); }
 @ExceptionHandler(MethodArgumentNotValidException.class) public ResponseEntity<Map<String,String>> handleValidation(MethodArgumentNotValidException e){ return ResponseEntity.badRequest().body(Map.of("error", Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage())); }
}
