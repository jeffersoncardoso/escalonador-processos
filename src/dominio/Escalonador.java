package dominio;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Escalonador {

    private Integer proximoIdProcesso = 1;
    private boolean estaEmExecucao = false;
    private final Integer numeroProcessosMaximoPorMinuto;
    private final Integer valorQuantum;
    
    private Integer countProcessosMinuto = 0;
    private final CopyOnWriteArrayList<Processo> processos; //Esse tipo de lista permite remover elementos ao iterar (thread safe)
    private CopyOnWriteArrayList<Processo> processosEmEspera; //Lista para processos IO-Bound

    public Escalonador(Integer numeroProcessosPorMinuto, Integer valorQuantum){
        this.numeroProcessosMaximoPorMinuto = numeroProcessosPorMinuto;
        this.valorQuantum = valorQuantum;
        this.processos = new CopyOnWriteArrayList();
        this.processosEmEspera = new CopyOnWriteArrayList();
        
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
        novoProcesso.setId(getIdNovoProcesso());
        if(numeroDeProcessosCriadosNaFila() < numeroProcessosMaximoPorMinuto){
            if(novoProcesso.getTipo() == TipoProcesso.CPUBound){
                criarNovoProcesso(novoProcesso);
            }else{
                criarNovoProcessoIOBound(novoProcesso);
            }
        }else{
            throw new RuntimeException("Número máximo de processos simultâneos excedido");
        }
    }
    
    private Integer numeroDeProcessosCriadosNaFila(){
        return processos.size() + processosEmEspera.size();
    }
    
    private void criarNovoProcesso(Processo novoProcesso){
        processos.add(novoProcesso);
        novoProcesso.gerarTimeSharing(valorQuantum);
        countProcessosMinuto++;
    }
    
    private void criarNovoProcessoIOBound(Processo novoProcesso){
        this.processosEmEspera.add(novoProcesso);
        
        Random gerador = new Random();
        novoProcesso.setTempoEspera(gerador.nextInt(10000));
        
        new Thread(){
            public void run(){
                try {
                    Thread.sleep(novoProcesso.getTempoEspera());
                    processosEmEspera.remove(novoProcesso);
                    criarNovoProcesso(novoProcesso);
                } catch (InterruptedException ex) {}
            }  
        }.start();
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

    public boolean possuiProcessosEmEspera() {
        return !processosEmEspera.isEmpty();
    }

    public CopyOnWriteArrayList<Processo> getProcessosEmEspera() {
        return processosEmEspera;
    }
    
    
}
