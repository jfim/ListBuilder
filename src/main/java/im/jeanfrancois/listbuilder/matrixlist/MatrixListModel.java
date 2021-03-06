package im.jeanfrancois.listbuilder.matrixlist;

import com.google.inject.Inject;
import im.jeanfrancois.listbuilder.common.TodoListUniqueIdentifierRegistry;

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

    private String titleText = "My matrix list";
    private Font font = new Font("SansSerif", 0, 24);
    private int x = 28;
    private int y = 18;
    private int size = 15;
    private int spacing = 3;
    private double strokeWidth = 1;
    private TodoListUniqueIdentifierRegistry uniqueIdentifierRegistry;

    @Inject
    public MatrixListModel(TodoListUniqueIdentifierRegistry uniqueIdentifierRegistry) {
        this.uniqueIdentifierRegistry = uniqueIdentifierRegistry;
    }

    public TodoListUniqueIdentifierRegistry getUniqueIdentifierRegistry() {
        return uniqueIdentifierRegistry;
    }

    public String getDefaultUniqueIdentifier() {
        return uniqueIdentifierRegistry.getIdentifierForTodoListIndex(0).toString();
    }

    public double getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(double newStrokeWidth) {
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

    public void resetUniqueIdentifierRegistry() {
        final String oldDefaultUniqueIdentifier = getDefaultUniqueIdentifier();
        uniqueIdentifierRegistry.clearIdentifierList();
        final String newDefaultUniqueIdentifier = getDefaultUniqueIdentifier();

        propertyChangeSupport.firePropertyChange("defaultUniqueIdentifier", oldDefaultUniqueIdentifier, newDefaultUniqueIdentifier);
    }
}
