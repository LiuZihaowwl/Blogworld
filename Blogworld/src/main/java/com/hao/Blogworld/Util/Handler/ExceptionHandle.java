package com.hao.Blogworld.Util.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.server.WebExceptionHandler;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
public class ExceptionHandle {
    private static final Logger log = LoggerFactory.getLogger(WebExceptionHandler.class);
    @ExceptionHandler
    public String methodArgumentNotValid(BindException e) {
        log.error("参数校验失败", e);
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        StringBuilder errorMessage = new StringBuilder();
        for (int i = 0; i < allErrors.size(); i++) {
            ObjectError error = allErrors.get(i);
            errorMessage.append(error.getDefaultMessage());
            if (i != allErrors.size() - 1) {
                errorMessage.append(", ");
            }
        }
        // do something
        return generateErrorInfo(1, errorMessage.toString(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler
    public String unknownException(Exception e) {
        log.error("发生了未知异常在这里: ", e);
        return generateErrorInfo(-99, "系统故障, 请稍后再试!");
    }
    /**
     * 生成错误信息, 放到 request 域中.
     * @param code          错误码
     * @param message       错误信息
     * @param httpStatus    HTTP 状态码
     * @return              SpringBoot 默认提供的 /error Controller 处理器
     */
    private String generateErrorInfo(int code, String message, int httpStatus) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.setAttribute("code", code);
        request.setAttribute("message", message);
        request.setAttribute("javax.servlet.error.status_code", httpStatus);
        return "forward:/error";
    }

    private String generateErrorInfo(int code, String message) {
        return generateErrorInfo(code, message, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

}
