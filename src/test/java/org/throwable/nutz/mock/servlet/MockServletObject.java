package org.throwable.nutz.mock.servlet;

import javax.servlet.ServletContext;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class MockServletObject{
    
    private Map<String, String> initParameterMap = new HashMap<String, String>();
    
    protected ServletContext servletContext;
    
    public String getInitParameter(String key) {
        return initParameterMap.get(key);
    }

    public Enumeration<String> getInitParameterNames() {
        return new Vector<String>(initParameterMap.keySet()).elements();
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

    public void addInitParameter(String key, String value){
        initParameterMap.put(key, value);
    }
    
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
