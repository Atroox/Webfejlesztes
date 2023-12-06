package com.example.webproject.utils;

import com.example.webproject.service.CustomerService;
import com.example.webproject.uito.ProductUITO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Service
public class ProductConverter implements Converter {

    @Autowired
    private CustomerService customerService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return ((ProductUITO) o).getProductName();
    }
}
