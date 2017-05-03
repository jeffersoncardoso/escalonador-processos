package dominio;

import java.util.concurrent.CopyOnWriteArrayList;

public class Escalonador {

    private Integer proximoIdProcesso = 1;
    private boolean estaEmExecucao = false;
    private final Integer numeroProcessosMaximoPorMinuto;
    private final Integer valorQuantum;
    
    private Integer countProcessosMinuto = 0;
    private final CopyOnWriteArrayList<Processo> processos; //Esse tipo de lista permite remover elementos ao iterar

    public Escalonador(Integer numeroProcessosPorMinuto, Integer valorQuantum){
        this.numeroProcessosMaximoPorMinuto = numeroProcessosPorMinuto;
        this.valorQuantum = valorQuantum;
        this.processos = new CopyOnWriteArrayList();
        
        LogProcesso.log("Escalonador de processos iniciado");
    }
    
    public boolean estaEmExecucao(){
        return this.estaEmExecucao;
    }
    
    public boolean possuiProcessos(){
        return !processos.isEmpty();
    }
    
    public boolean naoPossuiProcessos(){
        return !possuiProcessos();
    }
    
    public void criar(Processo novoProcesso){
        if(numeroDeProcessosCriadosNoUltimoMinuto() < numeroProcessosMaximoPorMinuto){
            criarNovoProcesso(novoProcesso);
        }else{
            throw new RuntimeException("Número máximo de processos por mínuto excedido");
        }
    }
    
    private Integer numeroDeProcessosCriadosNoUltimoMinuto(){
        return countProcessosMinuto;
    }
    
    private void criarNovoProcesso(Processo novoProcesso){
        novoProcesso.setId(getIdNovoProcesso());
        processos.add(novoProcesso);
        novoProcesso.gerarTimeSharing(valorQuantum);
        countProcessosMinuto++;
    }
    
    private Integer getIdNovoProcesso(){
        Integer id = proximoIdProcesso;
        proximoIdProcesso++;
        return id;
    }
    
    public void escalonar(){
        if(naoPossuiProcessos()){
            estaEmExecucao = false;
            return;
        }
        
        estaEmExecucao = true;

        for(Processo processo : processos) {
            if(processo.estaConcluido())
                processos.remove(processo);
            else
                processo.executar();
        }

        escalonar(); //Chamada recursiva para apenas encerrar quando todos os processos estiverem encerrados
    }

    public CopyOnWriteArrayList<Processo> getProcessos() {
        return processos;
    }
    
    
}
