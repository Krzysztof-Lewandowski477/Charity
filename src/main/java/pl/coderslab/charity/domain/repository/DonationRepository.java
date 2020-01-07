package pl.coderslab.charity.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.domain.entities.Donation;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation,Long> {

    @Query(value = "SELECT sum(quantity) FROM donations " , nativeQuery = true)
     Long sumQuantitiesBag();

    @Query(value = "SELECT count(DISTINCT institution_id) FROM donations", nativeQuery = true)
    Long institutionsSum();

    @Query(value = "SELECT * FROM donations WHERE user_id = ? ORDER BY pick_up_date DESC", nativeQuery = true)
    List<Donation> findAllByUserId(Long id);

}
