package exercise.mapper;

import exercise.dto.CategoryCreateDTO;
import exercise.dto.CategoryDTO;
import exercise.model.Category;
import org.mapstruct.*;

// BEGIN
@Mapper(
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class CategoryMapper {
//    @Mapping(target = "category.id", source = "categoryId")
    public abstract Category map(CategoryCreateDTO dto);

//    @Mapping(target = "categoryId", source = "category.id")
    public abstract CategoryDTO map(Category model);
}
// END
