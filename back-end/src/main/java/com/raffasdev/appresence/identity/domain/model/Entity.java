package com.raffasdev.appresence.identity.domain.model;

public abstract class Entity<ID extends ValueObject> {

    private final ID id;

    protected Entity(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity<?> entity = (Entity<?>) o;

        return id != null ? id.equals(entity.id) : entity.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? (id.hashCode() + 31) : 0;
    }
}
