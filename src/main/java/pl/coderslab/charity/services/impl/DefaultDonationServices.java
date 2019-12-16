package pl.coderslab.charity.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.charity.domain.repository.DonationRepository;
import pl.coderslab.charity.services.DonationServices;

public class DefaultDonationServices implements DonationServices {

    @Autowired
    private DonationRepository donationRepository;

    @Override
    public Long sumQuantities() {
        return donationRepository.sumQuantities ();
    }
}
