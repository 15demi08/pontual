/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import beans.LoginMB;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author demetrius
 */
@WebFilter(filterName = "adminAccessFilter", urlPatterns = {"/faces/admin/*"})
public class AdminAccessFilter implements Filter {
    
    @Inject
    LoginMB loginMB;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        
        if (loginMB != null && loginMB.getLogado() != null && loginMB.getLogado().isAdmin()) {
            chain.doFilter(request, response);
        } else {
            resp.sendRedirect(req.getContextPath() + "/faces/usuario/index.xhtml");
        }
        
    }

    @Override
    public void destroy() {}
    
    
    
}
