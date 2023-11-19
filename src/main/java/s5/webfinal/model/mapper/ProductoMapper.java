package s5.webfinal.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import s5.webfinal.model.entity.Producto;
import s5.webfinal.model.dto.ProductoDto;

@Mapper
public interface ProductoMapper {
    ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);

    Producto mapToEntity(ProductoDto productoDto);

    ProductoDto mapToDto(Producto producto);
}
