package hu.schonherz.blog.service.api.user.vo;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Name {

@SerializedName("title")
@Expose
private String title;
@SerializedName("first")
@Expose
private String first;
@SerializedName("last")
@Expose
private String last;

/**
* 
* @return
* The title
*/
public String getTitle() {
return title;
}

/**
* 
* @param title
* The title
*/
public void setTitle(String title) {
this.title = title;
}

/**
* 
* @return
* The first
*/
public String getFirst() {
return first;
}

/**
* 
* @param first
* The first
*/
public void setFirst(String first) {
this.first = first;
}

/**
* 
* @return
* The last
*/
public String getLast() {
return last;
}

/**
* 
* @param last
* The last
*/
public void setLast(String last) {
this.last = last;
}

}

