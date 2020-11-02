package ro.tuc.ds2020.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAccessDeniedHandler implements AccessDeniedHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAccessDeniedHandler.class);


    //invoked when user tries to access a secured REST resource without the necessary authorization
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException {
        LOGGER.error("Unauthorized error: {}", e.getMessage());
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Error: Unauthorized");
    }
}
