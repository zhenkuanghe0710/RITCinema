//
// Generated By:JAX-WS RI IBM 2.1.1 in JDK 6 (JAXB RI IBM JAXB 2.1.3 in JDK 1.6)
//


package ritcinema.forms.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "retrieveAdminResponse", namespace = "http://forms.ritcinema/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "retrieveAdminResponse", namespace = "http://forms.ritcinema/")
public class RetrieveAdminResponse {

    @XmlElement(name = "return", namespace = "")
    private ritcinema.datas.AdminData _return;

    /**
     * 
     * @return
     *     returns AdminData
     */
    public ritcinema.datas.AdminData getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ritcinema.datas.AdminData _return) {
        this._return = _return;
    }

}
