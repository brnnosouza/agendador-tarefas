package com.brennodev.agendadortarefas.infrastructure.business.mapper;

import com.brennodev.agendadortarefas.infrastructure.business.dto.TarefasDTO;
import com.brennodev.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
public interface TarefaUpdateConverter {
    void uptadeTarefas(TarefasDTO dto, @MappingTarget TarefasEntity entity);
}
