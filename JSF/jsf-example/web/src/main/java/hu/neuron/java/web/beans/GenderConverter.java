package hu.neuron.java.web.beans;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.EnumConverter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang3.StringUtils;

import hu.neuron.service.vo.Gender;

@FacesConverter(value = "genderConverter")
public class GenderConverter extends EnumConverter {

    public GenderConverter() {
        super(Gender.class);
    }
    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
    	return super.getAsObject(arg0, arg1, arg2);
    }
 
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
    	if(value!= null && StringUtils.isBlank(value.toString())){
    		return null;
    	} 
    	return super.getAsString(context, component, value);
    }
}
