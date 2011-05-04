package im.jeanfrancois.listbuilder.todolist;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Document me!
 *
 * @author jfim
 */
public class TodoListModel {
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    private String titleText = "My matrix list";
    private Font font = new Font("SansSerif", 0, 24);

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
