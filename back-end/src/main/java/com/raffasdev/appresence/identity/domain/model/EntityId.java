package com.raffasdev.appresence.identity.domain.model;

import java.util.Objects;
import java.util.UUID;

public class EntityId extends ValueObject {

    private final UUID value;

    private EntityId(UUID value) {
        this.value = value;
        validate();
    }

    public static EntityId from(UUID value) {
        return new EntityId(value);
    }

    public static EntityId newIdentifier() {
        return new EntityId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    private void validate() {
        if (value == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof EntityId))
            return false;
        EntityId entityId = (EntityId) o;
        return Objects.equals(value, entityId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
