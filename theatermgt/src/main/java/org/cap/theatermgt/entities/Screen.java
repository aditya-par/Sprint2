package org.cap.theatermgt.entities;

import javax.persistence.Column;
import javax.persistence.ElementCollection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import java.util.*;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="screen")
public class Screen {
	
	@Id
	@GeneratedValue
	@Column(name="screenId")
	private int screenId;
	@Column(name="theater_id")
	private int theaterId;
	private String screenName;
	@ElementCollection
	private List<Integer> showList;
	private int rows;
	private int columns;
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	public int getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public List<Integer> getShowList() {
		return showList;
	}
	public void setShowList(List<Integer> showList) {
		this.showList = showList;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
	@Override
	public String toString() {
		return "Screen [screenId=" + screenId + ", theaterId=" + theaterId + ", screenName=" + screenName
				+ ", showList=" + showList + ", rows=" + rows + ", columns=" + columns + "]";
	}
	
}
