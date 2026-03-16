package com.brennodev.agendadortarefas.infrastructure.business.mapper;

import com.brennodev.agendadortarefas.infrastructure.business.dto.TarefasDTO;
import com.brennodev.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaConverter {
    TarefasEntity paraTarefaEntity(TarefasDTO dto);
    TarefasDTO paraTarefaDTO(TarefasEntity entity);
}
