package trace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;


public class TraceInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(TraceInterceptor.class);


    @Override
    public boolean preHandle(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            String requestId = request.getHeader("requestId");
            if (requestId == null || requestId.length() == 0) {
                requestId = UUID.randomUUID().toString().replace("-", "");
            }
            MDC.put("requestId", requestId);
            response.addHeader("requestId", requestId);
            // log.info("set requestId: {}", requestId);
        }
        return true;
    }

    @Override
    public void postHandle(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.remove("requestId");
    }
}
