package im.jeanfrancois.listbuilder.matrixlist;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


/**
 * Document me!
 *
 * @author jfim
 */
public class MatrixListModel {
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

	private String titleText = "";
	private Font font = new Font(null);
	private int x;
	private int y;
	private int size;
	private int spacing;
	private int strokeWidth;

	public int getStrokeWidth() {
		return strokeWidth;
	}

	public void setStrokeWidth(int newStrokeWidth) {
		propertyChangeSupport.firePropertyChange("strokeWidth", strokeWidth, newStrokeWidth);
		this.strokeWidth = newStrokeWidth;
	}

	public void setX(int newX) {
		propertyChangeSupport.firePropertyChange("x", x, newX);
		this.x = newX;
	}

	public void setY(int newY) {
		propertyChangeSupport.firePropertyChange("y", y, newY);
		this.y = newY;
	}

	public void setSize(int newSize) {
		propertyChangeSupport.firePropertyChange("size", size, newSize);
		this.size = newSize;
	}

	public void setSpacing(int newSpacing) {
		propertyChangeSupport.firePropertyChange("spacing", spacing, newSpacing);
		this.spacing = newSpacing;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSize() {
		return size;
	}

	public int getSpacing() {
		return spacing;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font newFont) {
		propertyChangeSupport.firePropertyChange("font", font, newFont);
		this.font = newFont;
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}

	public void addPropertyChangeListener(String propertyName,
	                                      PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public PropertyChangeListener[] getPropertyChangeListeners() {
		return propertyChangeSupport.getPropertyChangeListeners();
	}

	public PropertyChangeListener[] getPropertyChangeListeners(String propertyName) {
		return propertyChangeSupport.getPropertyChangeListeners(propertyName);
	}

	public String getTitleText() {
		return titleText;
	}

	public boolean hasListeners(String propertyName) {
		return propertyChangeSupport.hasListeners(propertyName);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(String propertyName,
	                                         PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(propertyName,
				listener);
	}

	public void setTitleText(String newTitleText) {
		propertyChangeSupport.firePropertyChange("titleText", titleText,
				newTitleText);
		this.titleText = newTitleText;
	}
}
