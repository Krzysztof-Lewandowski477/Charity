package pl.coderslab.charity.services;

import pl.coderslab.charity.dtos.CategoryDataDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDataDTO> allCategory ();

    void save(CategoryDataDTO categoryDataDTO);

    void update(CategoryDataDTO categoryDataDTO ,Long id);

    void delete(CategoryDataDTO categoryDataDTO, Long id);


}
