package im.jeanfrancois.listbuilder.common;

/**
 * Document me!
 *
 * @author jfim
 */
public interface TodoListUniqueIdentifierRegistry {
    public TodoListUniqueIdentifier getIdentifierForTodoListIndex(int index);
    public void clearIdentifierList();
}
