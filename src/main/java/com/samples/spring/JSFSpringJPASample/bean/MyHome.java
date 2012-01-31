/**
 * 
 */
package com.samples.spring.JSFSpringJPASample.bean;

import java.util.Map;

import javax.faces.context.FacesContext;

/**
 * Specific MyHome implementation to support some standard code utils.
 * @author frederic
 *
 */
public class MyHome {

	
	/**
	 * Return HTTP request parameter <code>parameterName</code> value.
	 * @param parameterName
	 * @return
	 */
	protected String getParameter(String parameterName){
		FacesContext context = FacesContext.getCurrentInstance();  
		Map<String,String> requestMap = context.getExternalContext().getRequestParameterMap();  
		String value = (String)requestMap.get(parameterName);   
		return value;
	}
}
