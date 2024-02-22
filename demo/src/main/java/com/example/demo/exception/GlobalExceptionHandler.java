package com.example.demo.exception;



import com.example.demo.exception.custom.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(EmailAlreadyExistException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> emailAlreadyExist(EmailAlreadyExistException emailAlreadyExistException){
        return new ResponseEntity<>(createMessage(ErrorType.EMAIL_ALREADY_EXISTS),HttpStatus.BAD_GATEWAY);
    }



    @ExceptionHandler(TokenNotValidException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> tokenNotValid(TokenNotValidException tokenNotValidException){
        return new ResponseEntity<>(createMessage(ErrorType.TOKEN_NOT_VALID),HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(InvalidRoleException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> invalidRole(InvalidRoleException invalidRoleException){
        return new ResponseEntity<>(createMessage(ErrorType.INVALID_ROLE),HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(CompanyNotExistException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> companyNotExist(CompanyNotExistException companyNotExistException){
        return new ResponseEntity<>(createMessage(ErrorType.COMPANY_NOT_EXIST),HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(MoneyNotEnoughException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> moneyNotEnough(MoneyNotEnoughException moneyNotEnoughException){
        return new ResponseEntity<>(createMessage(ErrorType.MONEY_NOT_ENOUGH),HttpStatus.BAD_GATEWAY);
    }


    @ExceptionHandler(WrongMailException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> wrongMail(WrongMailException wrongMailException){
        return new ResponseEntity<>(createMessage(ErrorType.WRONG_MAIL),HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(WrongPasswordException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> wrongPassword(WrongPasswordException wrongPasswordException){
        return new ResponseEntity<>(createMessage(ErrorType.WRONG_PASSWORD),HttpStatus.BAD_GATEWAY);
    }

    public ErrorMessage createMessage(ErrorType errorType){
        ErrorMessage errorMessage=new ErrorMessage();
        errorMessage.setMessage(errorType.message);
        errorMessage.setStatusCode(errorType.statusCode);
        return errorMessage;
    }

}
