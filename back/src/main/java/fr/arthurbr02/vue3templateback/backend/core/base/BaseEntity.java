package fr.arthurbr02.vue3templateback.backend.core.base;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.util.Date;

public abstract class BaseEntity {
    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
