package com.example.streamr_controller.objects;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MovieData extends DataObject {
	private int ID;
	private String NAME;
	private int LENGTH;
	private String DIRECTOR;
	private String STAR;
	private String FILE;
	
	/**
	 * @return the string representation of the object
	 */
	@Override
	public String toString() {
		return NAME;
	}
	
	/**
	 * @return the id
	 */
	@Override
	public int getId() {
		return ID;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.ID = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return NAME;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.NAME = name;
	}
	
	/**
	 * @return the length
	 */
	public int getLength() {
		return LENGTH;
	}
	
	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.LENGTH = length;
	}
	
	/**
	 * @return the director
	 */
	public String getDirector() {
		return DIRECTOR;
	}
	
	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.DIRECTOR = director;
	}
	
	/**
	 * @return the star
	 */
	public String getStar() {
		return STAR;
	}
	
	/**
	 * @param star the star to set
	 */
	public void setStar(String star) {
		this.STAR = star;
	}
	
	/**
	 * @return the file
	 */
	public String getFile() {
		return FILE;
	}
	
	/**
	 * @param file the file to set
	 */
	public void setFile(String file) {
		this.FILE = file;
	}
}
