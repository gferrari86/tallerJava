package uy.com.antel;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "fechaConverter")
public class FechaConverter  implements Converter {
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        System.out.println("String de Editorial es " + s);

/*

        public Date getXmlGregorianCalendarToDate(XMLGregorianCalendar xmlGregorianCalendar) {
            TimeZone.setDefault(TimeZone.getTimeZone("GMT-3:00"));
            System.out.println("xmlGregorianCalendarToDate");
            System.out.println(xmlGregorianCalendar);
            System.out.println(xmlGregorianCalendar.toGregorianCalendar().getTimeInMillis());
            return new Date(xmlGregorianCalendar.toGregorianCalendar().getTimeInMillis());
        }


        for (Editorial editorialIng: RevistaBean.editorialesIngresadas){
            if(editorialIng.getNombre().equals(s)){
                return editorialIng;

            }
        }
        return null;*/

        return null;
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return null;
    }
}
