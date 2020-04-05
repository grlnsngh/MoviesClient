
package com.mycompany.moviesoap.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addMovie complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addMovie">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="addMovie" type="{http://services.moviesoap.mycompany.com/}movies" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addMovie", propOrder = {
    "addMovie"
})
public class AddMovie {

    protected Movies addMovie;

    /**
     * Gets the value of the addMovie property.
     * 
     * @return
     *     possible object is
     *     {@link Movies }
     *     
     */
    public Movies getAddMovie() {
        return addMovie;
    }

    /**
     * Sets the value of the addMovie property.
     * 
     * @param value
     *     allowed object is
     *     {@link Movies }
     *     
     */
    public void setAddMovie(Movies value) {
        this.addMovie = value;
    }

}
