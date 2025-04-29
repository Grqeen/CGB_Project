package cgb.transfert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cgb.transfert.entity.Log;


@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
}
