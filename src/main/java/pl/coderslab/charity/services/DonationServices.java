package pl.coderslab.charity.services;

import pl.coderslab.charity.dtos.DeliverStatusDTO;
import pl.coderslab.charity.dtos.DonationDataDTO;
public interface DonationServices {

     void addDonation(DonationDataDTO donationData);
     Long sumQuantitiesBags();
     Long institutionsSum();
     void CourierVisit(DeliverStatusDTO statusDTO);

}
