package fr.arthurbr02.vue3templateback.backend.app.file;

import fr.arthurbr02.vue3templateback.backend.app.file.constant.FicType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FicRepository extends CrudRepository<Fic, Long> {
    void deleteByUserIdAndType(Long userId, String type);

    Optional<Fic> findByUserIdAndType(Long userId, String type);
}
