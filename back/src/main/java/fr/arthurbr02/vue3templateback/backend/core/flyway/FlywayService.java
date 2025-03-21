package fr.arthurbr02.vue3templateback.backend.core.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("flywayService")
public class FlywayService {
    @Autowired
    private transient Flyway flyway;

    public void migrate() {
        flyway.migrate();
    }
}
