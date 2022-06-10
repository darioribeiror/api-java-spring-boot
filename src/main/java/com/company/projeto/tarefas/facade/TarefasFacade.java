package com.company.projeto.tarefas.facade;

import com.company.projeto.tarefas.dto.TarefasDTO;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TarefasFacade {
    private static final Map<Long, TarefasDTO> tarefas = new HashMap<>();

    public TarefasDTO criar(TarefasDTO tarefasDTO){
        Long proximoId = tarefas.keySet().size() + 1L;
        tarefasDTO.setId(proximoId);
        tarefas.put(proximoId, tarefasDTO);
        return tarefasDTO;
    }

    public TarefasDTO atualizar (TarefasDTO tarefasDTO, Long tarefaId){
        tarefas.put(tarefaId, tarefasDTO);
        return tarefasDTO;
    }

    public TarefasDTO getById (Long tarefaId){
        return tarefas.get(tarefaId);
    }

    public List<TarefasDTO> getAll (){
        return new ArrayList<>(tarefas.values());
    }

    public String delete (Long tarefaId){
        tarefas.remove(tarefaId);
        return "DELETED";
    }

}
