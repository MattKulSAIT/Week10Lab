
package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AdminFilter", servletNames = {"LoginServlet"})
public class AdminFilter implements Filter {

   
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
            
            HttpServletRequest httpRequest = (HttpServletRequest)request;
            HttpSession session = httpRequest.getSession();
            
            int role = (int)session.getAttribute("role");
            
            if(role == 2){
                HttpServletResponse httpResponse = (HttpServletResponse)response;
                httpResponse.sendRedirect("notes");
                return;
            }
        
            chain.doFilter(request, response);
       
            //Code that gets ran after the stuff
        }

   @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void destroy() {
       
    }
}
