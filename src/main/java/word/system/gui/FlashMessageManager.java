package word.system.gui;

import javax.servlet.http.HttpSession;

public class FlashMessageManager {

    HttpSession session;

    enum Type {
        INFO, ERROR
    }

    public FlashMessageManager(HttpSession session) {
        this.session = session;
    }


    public void addMessage(String msg, Type type) {
        session.setAttribute("flashMessage", msg);
    }

    public boolean issetMessage() {
        return (session.getAttribute("flashMessage") != null);
    }

    public String getMessage() {
        String message = (String)session.getAttribute("flashMessage");
        session.setAttribute("flashMessage", null);
        return message;
    }
}
