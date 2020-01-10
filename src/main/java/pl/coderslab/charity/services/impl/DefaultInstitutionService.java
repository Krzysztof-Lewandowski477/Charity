package pl.coderslab.charity.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.domain.entities.Institution;
import pl.coderslab.charity.domain.repository.InstitutionRepository;
import pl.coderslab.charity.dtos.InstitutionDataDTO;
import pl.coderslab.charity.services.InstitutionService;

@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultInstitutionService implements InstitutionService {

    @Autowired
    private InstitutionRepository institutionRepository;

    @Override
    public void save(InstitutionDataDTO institutionDataDTO) {
        ModelMapper modelMapper = new ModelMapper ();
        Institution institution = modelMapper.map(institutionDataDTO,Institution.class);
        institutionRepository.save ( institution );
    }

    @Override
    public void delete(InstitutionDataDTO institutionDataDTO, Long id) {
        ModelMapper modelMapper = new ModelMapper ();
        Institution institution = modelMapper.map ( institutionDataDTO, Institution.class );
        institutionRepository.delete ( institution );
    }

    @Override
    public void update(InstitutionDataDTO institutionDataDTO, Long id) {
            ModelMapper modelMapper = new ModelMapper ();
            Institution institution = modelMapper.map ( institutionDataDTO, Institution.class );
            institutionRepository.findById ( id );
            institutionRepository.save ( institution );
    }
}
