package fr.arthurbr02.vue3templateback.backend.app.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    Optional<User> findByEmail(String email);

    @Query("SELECT COUNT(u) FROM user u WHERE u.email = :email")
    Integer countByEmail(String email);

    Optional<User> findByResetToken(String token);

    @Query("SELECT u FROM user u WHERE u.email = :email")
    Optional<List<User>> findAllByEmail(String email);
}
