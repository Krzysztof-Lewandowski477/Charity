package pl.coderslab.charity.services;

import pl.coderslab.charity.dtos.CategoryDataDTO;

public interface CategoryService {

    void save(CategoryDataDTO categoryDataDTO);

    void update(CategoryDataDTO categoryDataDTO ,Long id);

    void delete(CategoryDataDTO categoryDataDTO, Long id);
}
