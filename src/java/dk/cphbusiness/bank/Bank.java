package dk.cphbusiness.bank;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Bank implements Serializable
{

    private String reg;
    private String name;
    private String url;

    public Bank()
    {
    }

    public Bank(String reg, String name, String url)
    {
        this.reg = reg;
        this.name = name;
        this.url = url;
    }

    public String getReg()
    {
        return reg;
    }

    public void setReg(String reg)
    {
        this.reg = reg;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

}
