package com.example.DemoSpringBoot.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.DemoSpringBoot.entities.Items;
import com.example.DemoSpringBoot.models.DTO.ItemDTO;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    ItemDTO item2DTO(Items item);

    List<ItemDTO> items2DTOs(List<Items> items);

    @InheritInverseConfiguration
    Items DTO2Item(ItemDTO itemDTO);

    
}
