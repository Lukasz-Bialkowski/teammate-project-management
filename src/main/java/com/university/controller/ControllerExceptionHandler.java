package com.university.controller;

import com.university.exception.ForbiddenException;
import com.university.exception.TaskNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTaskNotFoundException(TaskNotFoundException ex, HttpServletRequest request, HttpServletResponse response) {
        LOGGER.error("Requested Task not found: {}", ex.getMessage());
    }

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handleForbiddenResourceException(ForbiddenException ex, HttpServletRequest request, HttpServletResponse response) {
        LOGGER.error("Requested resource of type: {}, is forbidden for user: {}", ex.getResource(), ex.getUser().getEmail());
    }


/*    private static final String MESSAGE_HEADER = "X-HRTools-Message";
    private static final String DEBUG_MESSAGE_HEADER = "X-HRTools-Debug-Message";
    private static final String STATUS_HEADER = "X-HRTools-Status";
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerBase.class);
    URLCodec codec = new URLCodec("UTF-8");
    @Autowired
    @Qualifier("languageTranslator")
    protected LanguageTranslator translator;
    @Autowired
    protected ValidationMesagesGenerator validationMessagesGenerator;

    public ControllerBase() {
    }

    @ExceptionHandler({Exception.class})
    public void handleException(Exception e, HttpServletRequest request, HttpServletResponse response) {
        LOGGER.error("Uncaught exception: {}", e.getMessage(), e);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setHeader("X-HRTools-Message", this.encodeMessage(e.getMessage()));
    }

    @ExceptionHandler({TranslationKeyCarryingException.class})
    public void handleException(TranslationKeyCarryingException e, HttpServletRequest request, HttpServletResponse response) {
        LOGGER.error("Uncaught exception: {}", e.getMessage(), e);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        String translatedMessage = this.translator.translate(e.getClass().getName(), e.getKey(), LocaleContextHolder.getLocale(), true);
        response.setHeader("X-HRTools-Message", this.encodeMessage(translatedMessage));
    }

    @ExceptionHandler({MethodConstraintViolationException.class})
    public void handleMethodValidationException(MethodConstraintViolationException e, HttpServletRequest request, HttpServletResponse response) {
        LOGGER.debug("Validation exception: {}", e.getMessage(), e);
        StringBuilder builder = new StringBuilder("Wystąpiły błędy:");
        List messages = this.validationMessagesGenerator.constraintViolationMessages(e.getConstraintViolations(), LocaleContextHolder.getLocale());
        int cnt = 0;
        Iterator var7 = messages.iterator();

        while(var7.hasNext()) {
            String message = (String)var7.next();
            builder.append(message);
            ++cnt;
            if(cnt < messages.size()) {
                builder.append(",");
            }
        }

        this.setError(response, builder.toString());
    }

    @ExceptionHandler({OptimisticLockException.class})
    public void handleOptimisticLockingException(OptimisticLockException e, HttpServletRequest request, HttpServletResponse response) {
        this.setError(response, e.getClass(), "msg");
    }

    @ExceptionHandler({JpaSystemException.class})
    public void handleJpaSystemException(JpaSystemException e, HttpServletRequest request, HttpServletResponse response) {
        LOGGER.debug(e.getMessage(), e);
        this.setError(response, e.getClass(), "msg");
    }

    @ExceptionHandler({AccessDeniedException.class})
    public void handleAccessDeniedException(AccessDeniedException e, HttpServletRequest request, HttpServletResponse response) {
        this.setError(response, "Brak uprawnień do wykonania tej operacji", HttpStatus.FORBIDDEN.value());
    }

    @ExceptionHandler({BadCredentialsException.class})
    public void handleBadCredentialsException(BadCredentialsException e, HttpServletRequest request, HttpServletResponse response) {
        this.setError(response, e.getClass(), "msg");
    }

    protected void setError(HttpServletResponse response, String message) {
        this.setError(response, message, HttpStatus.BAD_REQUEST.value());
    }

    protected void setError(HttpServletResponse response, String message, int status) {
        response.setStatus(status);
        response.setHeader("X-HRTools-Message", this.encodeMessage(message));
    }

    protected void setError(HttpServletResponse response, Class<?> cls, String key) {
        String message = this.translator.translate(cls.getName(), key, LocaleContextHolder.getLocale(), true);
        this.setError(response, message);
    }

    protected void setSuccess(HttpServletResponse response, String message) {
        response.setHeader("X-HRTools-Status", ResponseStatus.OK.name());
        response.setHeader("X-HRTools-Message", this.encodeMessage(message));
    }

    protected void setSuccess(HttpServletResponse response, Class<?> cls, String key) {
        String message = this.translator.translate(cls.getName(), key, LocaleContextHolder.getLocale(), true);
        this.setSuccess(response, message);
    }

    protected void setWarning(HttpServletResponse response, String message) {
        response.setHeader("X-HRTools-Status", ResponseStatus.WARN.name());
        response.setHeader("X-HRTools-Message", this.encodeMessage(message));
    }

    protected void setWarning(HttpServletResponse response, Class<?> cls, String key) {
        String message = this.translator.translate(cls.getName(), key, LocaleContextHolder.getLocale(), true);
        this.setSuccess(response, message);
    }

    private String encodeMessage(String message) {
        try {
            return this.codec.encode(message);
        } catch (EncoderException var3) {
            LOGGER.warn("Failde to encode message");
            return message;
        }
    }*/
}
