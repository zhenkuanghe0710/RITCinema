//
// Generated By:JAX-WS RI IBM 2.1.1 in JDK 6 (JAXB RI IBM JAXB 2.1.3 in JDK 1.6)
//


package ritcinema.services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getShowsList", namespace = "http://services.ritcinema/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getShowsList", namespace = "http://services.ritcinema/")
public class GetShowsList {

    @XmlElement(name = "arg0", namespace = "")
    private ritcinema.datas.ShowsData arg0;

    /**
     * 
     * @return
     *     returns ShowsData
     */
    public ritcinema.datas.ShowsData getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(ritcinema.datas.ShowsData arg0) {
        this.arg0 = arg0;
    }

}
