package pl.coderslab.charity.services;

import pl.coderslab.charity.dtos.InstitutionDataDTO;

public interface InstitutionService {

    void save(InstitutionDataDTO institutionDataDTO);
    void delete(InstitutionDataDTO institutionDataDTO, Long id);
    void update(InstitutionDataDTO institutionDataDTO, Long id);

}
