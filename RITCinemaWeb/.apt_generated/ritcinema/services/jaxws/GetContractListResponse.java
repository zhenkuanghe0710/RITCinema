//
// Generated By:JAX-WS RI IBM 2.1.1 in JDK 6 (JAXB RI IBM JAXB 2.1.3 in JDK 1.6)
//


package ritcinema.services.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getContractListResponse", namespace = "http://services.ritcinema/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getContractListResponse", namespace = "http://services.ritcinema/")
public class GetContractListResponse {

    @XmlElement(name = "return", namespace = "")
    private List<ritcinema.datas.ContractData> _return;

    /**
     * 
     * @return
     *     returns List<ContractData>
     */
    public List<ritcinema.datas.ContractData> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<ritcinema.datas.ContractData> _return) {
        this._return = _return;
    }

}
