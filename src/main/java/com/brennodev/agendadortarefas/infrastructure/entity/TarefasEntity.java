package com.brennodev.agendadortarefas.infrastructure.entity;


import com.brennodev.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("tarefa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefasEntity {

    @Id
    private String id;

    private String nomeTarefa;
    private String descricao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataEvento;
    private String emailUsuario;
    private LocalDateTime dataAteracao;
    private StatusNotificacaoEnum statusNotificacaoEnum;

}
