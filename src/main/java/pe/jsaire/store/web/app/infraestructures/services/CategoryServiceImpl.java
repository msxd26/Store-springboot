package pe.jsaire.store.web.app.infraestructures.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.jsaire.store.web.app.api.models.request.CategoryRequest;
import pe.jsaire.store.web.app.api.models.response.CategoryResponse;
import pe.jsaire.store.web.app.domain.entities.Category;
import pe.jsaire.store.web.app.domain.repositories.CategoryRepository;
import pe.jsaire.store.web.app.infraestructures.abstract_services.CategoryService;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse findById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        return entityToResponse(category);
    }

    @Override
    public CategoryResponse save(CategoryRequest request) {
        Category category = Category.builder()
                        .name(request.getName())
                        .description(request.getDescription())
                        .enabled(request.isEnabled())
                        .build();
        var categoryPersist = categoryRepository.save(category);
        return entityToResponse(categoryPersist);
    }

    @Override
    public CategoryResponse update(CategoryRequest categoryRequest, Long id) {
        Category categoryUpdate = categoryRepository.findById(id).orElseThrow();
        categoryUpdate.setName(categoryRequest.getName());
        categoryUpdate.setDescription(categoryRequest.getDescription());
        categoryUpdate.setEnabled(categoryRequest.isEnabled());
        var updatedCategory = categoryRepository.save(categoryUpdate);
        return entityToResponse(updatedCategory);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    private CategoryResponse entityToResponse(Category category) {
        CategoryResponse categoryResponse = new CategoryResponse();
        BeanUtils.copyProperties(category, categoryResponse);
        categoryResponse.setId(category.getIdCategory());
        return categoryResponse;
    }


}
