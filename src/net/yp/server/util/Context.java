package net.yp.server.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Context implements ApplicationContextAware
{
    
    private static ApplicationContext m_context;

    @SuppressWarnings ("static-access")
    public void setApplicationContext (ApplicationContext context) throws BeansException
    {
        this.m_context = context;
        
    }
    
    public static ApplicationContext getApplicationContext ()
    {
        return m_context;
    }
    
}
