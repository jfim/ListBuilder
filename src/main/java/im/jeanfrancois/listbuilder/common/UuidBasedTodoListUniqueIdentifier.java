package im.jeanfrancois.listbuilder.common;

import java.util.UUID;

/**
 * Document me!
 *
 * @author jfim
 */
class UuidBasedTodoListUniqueIdentifier implements TodoListUniqueIdentifier {
    UuidBasedTodoListUniqueIdentifier(UUID uuid) {
        this.uuid = uuid;
    }

    private UUID uuid;

    @Override
    public String toString() {
        return uuid.toString().toUpperCase();
    }
}
