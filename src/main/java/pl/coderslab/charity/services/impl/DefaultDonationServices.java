package pl.coderslab.charity.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.domain.entities.Donation;
import pl.coderslab.charity.domain.repository.DonationRepository;
import pl.coderslab.charity.dtos.DonationDataDTO;
import pl.coderslab.charity.services.DonationServices;




@Transactional
@Service @Slf4j
@RequiredArgsConstructor
public class DefaultDonationServices implements DonationServices {


    @Autowired
    private DonationRepository donationRepository;


    @Override
    public void addDonation(DonationDataDTO donationData) {
        ModelMapper modelMapper = new ModelMapper ();
        Donation donation = modelMapper.map(donationData, Donation.class);

        log.debug ( "zapis dotacji: {}", donation );
        donationRepository.save ( donation );
        log.debug("co się stało się? {}", donation);
    }

    @Override
    public Long sumQuantitiesBags() {
        return donationRepository.sumQuantitiesBag ();
    }

    @Override
    public Long institutionsSum() {
        return donationRepository.institutionsSum ();
    }
}
