package org.apache.catalina.session;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Session {

    private final String id;
    private final Map<String, Object> values = new HashMap<>();

    Session() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setAttribute(final String name, final Object value) {
        if (values.containsKey(name)) {
            values.replace(name, value);
            return;
        }
        values.put(name, value);
    }

    public boolean hasAttribute(String key) {
        return values.containsKey(key);
    }
}
