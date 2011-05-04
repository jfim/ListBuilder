package im.jeanfrancois.listbuilder.common;

import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Document me!
 *
 * @author jfim
 */
@Singleton
public class UuidBasedTodoListUniqueIdentifierRegistry implements TodoListUniqueIdentifierRegistry {
    private Map<Integer, TodoListUniqueIdentifier> registry;

    public UuidBasedTodoListUniqueIdentifierRegistry() {
        clearIdentifierList();
    }

    @Override
    public TodoListUniqueIdentifier getIdentifierForTodoListIndex(int index) {
        if(!registry.containsKey(index)) {
            registry.put(index, new UuidBasedTodoListUniqueIdentifier(UUID.randomUUID()));
        }

        return registry.get(index);
    }

    @Override
    public void clearIdentifierList() {
        registry = new HashMap<Integer, TodoListUniqueIdentifier>();
    }
}
