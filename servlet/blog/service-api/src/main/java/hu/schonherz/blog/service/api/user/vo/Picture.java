package hu.schonherz.blog.service.api.user.vo;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Picture {

	@SerializedName("large")
	@Expose
	private String large;
	@SerializedName("medium")
	@Expose
	private String medium;
	@SerializedName("thumbnail")
	@Expose
	private String thumbnail;

	/**
	 * 
	 * @return The large
	 */
	public String getLarge() {
		return large;
	}

	/**
	 * 
	 * @param large
	 *            The large
	 */
	public void setLarge(String large) {
		this.large = large;
	}

	/**
	 * 
	 * @return The medium
	 */
	public String getMedium() {
		return medium;
	}

	/**
	 * 
	 * @param medium
	 *            The medium
	 */
	public void setMedium(String medium) {
		this.medium = medium;
	}

	/**
	 * 
	 * @return The thumbnail
	 */
	public String getThumbnail() {
		return thumbnail;
	}

	/**
	 * 
	 * @param thumbnail
	 *            The thumbnail
	 */
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

}
