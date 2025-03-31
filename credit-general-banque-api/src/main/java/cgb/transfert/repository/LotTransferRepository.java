package cgb.transfert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cgb.transfert.entity.LotTransfer; // Assure-toi que l'entité LotTransfer existe
import cgb.transfert.entity.Transfer;

@Repository
public interface LotTransferRepository extends JpaRepository<LotTransfer, Long> {
}
