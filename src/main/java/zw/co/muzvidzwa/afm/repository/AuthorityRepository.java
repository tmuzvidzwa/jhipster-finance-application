package zw.co.muzvidzwa.afm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.muzvidzwa.afm.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
