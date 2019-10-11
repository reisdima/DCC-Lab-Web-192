/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 *
 * @author ice
 */
public class SessionLifeCycleEventDemo implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener{
    ServletContext servletContext;
    int counter = 0;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        servletContext = sce.getServletContext();
        servletContext.setAttribute("userCouter", Integer.toString(counter));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        this.counter += 1;
        servletContext.setAttribute("userCouter", Integer.toString(counter));
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        this.counter -= 1;
        servletContext.setAttribute("userCouter", Integer.toString(counter));
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        
    }
    
}
