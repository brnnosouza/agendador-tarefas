package com.brennodev.agendadortarefas.infrastructure.business;


import com.brennodev.agendadortarefas.infrastructure.business.dto.TarefasDTO;
import com.brennodev.agendadortarefas.infrastructure.business.mapper.TarefaConverter;
import com.brennodev.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.brennodev.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.brennodev.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.brennodev.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {
    private final TarefasRepository tarefasRepository;
    private final TarefaConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){

        String email = jwtUtil.extrairEmailDoToken(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PEDENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefaConverter.paraTarefaEntity(dto);
        return tarefaConverter.paraTarefaDTO(tarefasRepository.save(entity));
    }
    public List<TarefasDTO> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal){
        return tarefaConverter.paraListaTarefasDTO(tarefasRepository.findByDataEventoBetween(dataInicial, dataFinal));
    }
    public List<TarefasDTO> buscaTarefasPorEmail(String token){
        String email = jwtUtil.extrairEmailDoToken(token.substring(7));
        return tarefaConverter.paraListaTarefasDTO(tarefasRepository.findByEmailUsuario(email));
    }
}
