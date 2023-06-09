package vn.kien.event.eventbe.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Le-Hong-Quan
 * Date: 19/02/2023
 * Time: 11:22
 */

/**
 *  Handle Unauthorized Error: AuthenticationException - 401
 */
@Component
public class AuthenticationExceptionHandler implements AuthenticationEntryPoint {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationExceptionHandler.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        logger.error("Unauthorized error: {}", authException.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Phiên đăng nhập đã hết hạn. Vui lòng đăng nhập lại");
    }
}
