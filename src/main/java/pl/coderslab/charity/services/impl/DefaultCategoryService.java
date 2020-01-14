package pl.coderslab.charity.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.domain.entities.Category;
import pl.coderslab.charity.domain.repository.CategoryRepository;
import pl.coderslab.charity.dtos.CategoryDataDTO;
import pl.coderslab.charity.services.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service @Slf4j @RequiredArgsConstructor
public class DefaultCategoryService implements CategoryService {


    @Autowired
     private CategoryRepository categoryRepository;


    @Override
    public List<CategoryDataDTO> allCategory() {
        ModelMapper modelMapper = new ModelMapper ();
        List<Category> categories = categoryRepository.findAll ();
        return categories.stream()
                .map(b->modelMapper.map(b, CategoryDataDTO.class)).collect( Collectors.toList());

    }

    @Override
    public void save(CategoryDataDTO categoryDataDTO) {
        ModelMapper modelMapper = new ModelMapper ();
        Category category = modelMapper.map ( categoryDataDTO,Category.class );
        categoryRepository.save ( category );
    }

    @Override
    public void update(CategoryDataDTO categoryDataDTO ,Long id) {

        ModelMapper modelMapper= new ModelMapper ();
        Category category = modelMapper.map(categoryDataDTO,Category.class);
        categoryRepository.findById ( id );
        categoryRepository.save ( category );
    }


    @Override
    public void delete(CategoryDataDTO categoryDataDTO, Long id) {
        ModelMapper modelMapper = new ModelMapper ();
        Category category = modelMapper.map ( categoryDataDTO, Category.class );
        categoryRepository.delete ( category );
    }


}
