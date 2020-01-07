package pl.coderslab.charity.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.domain.entities.Donation;
import pl.coderslab.charity.domain.entities.User;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation,Long> {

    Donation findDonationById(Long id);


    @Query(value = "SELECT sum(quantity) FROM donations " , nativeQuery = true)
     Long sumQuantitiesBag();

    @Query(value = "SELECT count(DISTINCT institution_id) FROM donations", nativeQuery = true)
    Long institutionsSum();

    @Query(value = "SELECT * FROM donations WHERE user_id = ? ORDER BY pick_up_date DESC", nativeQuery = true)
    List<Donation> findAllByUserId(Long id);
    List<Donation>findAllByUserOrderByStatusDescPickUpDate(User user);

    @Modifying
    @Transactional
    @Query(value = "UPDATE donations SET status ='odebrany' WHERE id = ?1",nativeQuery = true)
    void changeStatusToGet(Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE donations SET status ='nieodebrany' WHERE id = ?1",nativeQuery = true)
    void changeStatusToUnGet(Long id);

}
