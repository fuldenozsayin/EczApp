package app.eczapp;

import app.eczapp.core.utilities.exception.BusinessException;
import app.eczapp.core.utilities.exception.ProblemDetails;
import app.eczapp.core.utilities.exception.ValidationProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@SpringBootApplication
@RestControllerAdvice
public class EczAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EczAppApplication.class, args);

	}
	@ExceptionHandler //@RestControllerAdvice ile birlikte kullanilir. (Trick Noktasi)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException (BusinessException businessException){ //class adinin önemi yok
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());

		return problemDetails;
	}

	@ExceptionHandler //@RestControllerAdvice ile birlikte kullanilir. (Trick Noktasi)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException (MethodArgumentNotValidException methodArgumentNotValidException)
	{ //class adinin önemi yok
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		validationProblemDetails.setMessage("VALIDATION.EXCEPTION");
		validationProblemDetails.setValidationErrors(new HashMap<String,String>());

		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return validationProblemDetails;
	}

	@Bean
	//Bean annotation ile ben bu nesneyi IOC containere ekleyeyim, birisinin ihtiyaci oldugunda cagirir kullanirim der.
	public ModelMapper getModelMapper () {
		return new ModelMapper();
	}

}
