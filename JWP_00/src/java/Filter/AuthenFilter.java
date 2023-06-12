package Filter;

import java.io.IOException;
import javax.servlet.Filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();
        String loginURL = request.getContextPath() + "/login";

        boolean loggedIn = session != null && session.getAttribute("account") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURL);

        if (session != null && session.getAttribute("account") != null || request.getRequestURI().equals(loginURL)) {
            chain.doFilter(request, response); // Logged-in user found or already in login page, so just continue request.
            return;
        } else {
            response.sendRedirect(loginURL); // No logged-in user found and not already in login page, so redirect to login page.
        }
    }

      @Override
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    @Override
    public void init(FilterConfig filterConfig) {

    }
}
    

