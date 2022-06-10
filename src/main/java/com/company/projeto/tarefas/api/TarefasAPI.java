package com.company.projeto.tarefas.api;

import com.company.projeto.tarefas.dto.TarefasDTO;
import com.company.projeto.tarefas.facade.TarefasFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping(value = "/tarefas", produces = MediaType.APPLICATION_JSON_VALUE)
public class TarefasAPI {
    @Autowired
    private TarefasFacade tarefasFacade;

    @PostMapping
    @ResponseBody
    public TarefasDTO criar(@RequestBody TarefasDTO tarefasDTO){
        return tarefasFacade.criar(tarefasDTO);
    }

    @PutMapping("/{Id}")
    @ResponseBody
    public TarefasDTO atualizar(@PathVariable("Id") Long Id,
                                @RequestBody TarefasDTO tarefasDTO){
        return tarefasFacade.atualizar(tarefasDTO, Id);
    }

    @GetMapping
    @ResponseBody
    public List<TarefasDTO> getAll(){
        return tarefasFacade.getAll();
    }

    @DeleteMapping("/{Id}")
    @ResponseBody
    public String deletar(@PathVariable("Id") Long Id){
        return tarefasFacade.delete(Id);
    }
}
