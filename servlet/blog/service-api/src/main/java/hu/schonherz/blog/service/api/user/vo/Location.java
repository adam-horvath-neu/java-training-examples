package hu.schonherz.blog.service.api.user.vo;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Location {

@SerializedName("street")
@Expose
private String street;
@SerializedName("city")
@Expose
private String city;
@SerializedName("state")
@Expose
private String state;
@SerializedName("postcode")
@Expose
private Integer postcode;

/**
* 
* @return
* The street
*/
public String getStreet() {
return street;
}

/**
* 
* @param street
* The street
*/
public void setStreet(String street) {
this.street = street;
}

/**
* 
* @return
* The city
*/
public String getCity() {
return city;
}

/**
* 
* @param city
* The city
*/
public void setCity(String city) {
this.city = city;
}

/**
* 
* @return
* The state
*/
public String getState() {
return state;
}

/**
* 
* @param state
* The state
*/
public void setState(String state) {
this.state = state;
}

/**
* 
* @return
* The postcode
*/
public Integer getPostcode() {
return postcode;
}

/**
* 
* @param postcode
* The postcode
*/
public void setPostcode(Integer postcode) {
this.postcode = postcode;
}

}

