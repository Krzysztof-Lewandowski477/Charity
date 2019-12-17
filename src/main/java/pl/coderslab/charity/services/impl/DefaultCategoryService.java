package pl.coderslab.charity.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.domain.repository.CategoryRepository;
import pl.coderslab.charity.services.CategoryService;
@Transactional
@Service @Slf4j @RequiredArgsConstructor
public class DefaultCategoryService implements CategoryService {

    private final CategoryRepository categoryRepository;

}
