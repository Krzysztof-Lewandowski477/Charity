package pl.coderslab.charity.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.domain.entities.Donation;
import pl.coderslab.charity.domain.repository.CategoryRepository;
import pl.coderslab.charity.domain.repository.DonationRepository;
import pl.coderslab.charity.domain.repository.InstitutionRepository;
import pl.coderslab.charity.domain.repository.UserRepository;
import pl.coderslab.charity.dtos.DeliverStatusDTO;
import pl.coderslab.charity.dtos.DonationDataDTO;
import pl.coderslab.charity.services.DonationServices;
import pl.coderslab.charity.util.Utils;


import java.time.LocalDateTime;



@Transactional
@Service @Slf4j
@RequiredArgsConstructor
public class DefaultDonationServices implements DonationServices {


    @Autowired
    private final DonationRepository donationRepository;
    private final UserRepository userRepository;




    @Override
    public void addDonation(DonationDataDTO donationData) {
        Donation donation = new Donation();
        donation.setQuantity(donationData.getQuantity());
        donation.setStreet(donationData.getStreet());
        donation.setCity(donationData.getCity());
        donation.setZipCode(donationData.getZipCode());
        donation.setPickUpDate(donationData.getPickUpDate());
        donation.setPickUpTime(donationData.getPickUpTime());
        donation.setPickUpComment(donationData.getPickUpComment());
        donation.setUser (userRepository.findUserByEmail( Utils.getName ()));
        donation.setStatus ("nieodebrany");
        donationRepository.save(donation);

    }

    @Override
    public Long sumQuantitiesBags() {
        return donationRepository.sumQuantitiesBag ();
    }

    @Override
    public Long institutionsSum() {
        return donationRepository.institutionsSum ();
    }

    @Override
    public void CourierVisit(DeliverStatusDTO statusDTO) {
        Donation donation = donationRepository.getOne(statusDTO.getId());
        donation.setStatus ("odebrany");
        donation.setDeliverTime(LocalDateTime.now());
        donationRepository.save(donation);
    }


}
