package word.system.gui;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class FlashMessageInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);

        FlashMessageManager flashMessageManager = new FlashMessageManager(request.getSession());


        if(modelAndView != null && modelAndView.getModelMap() != null && modelAndView.getModelMap() != null ) {
            modelAndView.getModelMap().addAttribute("flashMessageManager", flashMessageManager);
        }

    }
}
