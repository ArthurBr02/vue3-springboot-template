package fr.arthurbr02.vue3templateback.backend.core.base;

import jakarta.annotation.Generated;
import jakarta.persistence.Id;

public abstract class BaseEntity {
    @Id
    @Generated({})
    private Long id;
}
