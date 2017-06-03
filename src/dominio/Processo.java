package dominio;

import java.util.ArrayList;

public class Processo{
    private Integer id;
    private Integer tempo;
    private TipoProcesso tipo;
    private SituacaoProcesso situacao;
    private Integer tempoEspera;
    
    private ArrayList<TimeSharingProcesso> timeSharing;
    
    public Processo(Integer tempo, TipoProcesso tipo){
        this.tempo = tempo;
        this.situacao = SituacaoProcesso.Pendente;
        this.tipo = tipo;
    }

    public Integer getId(){
        return id;
    }

    public TipoProcesso getTipo() {
        return tipo;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTempo(){
        return tempo;
    }

    public SituacaoProcesso getSituacao(){
        return situacao;
    }
    
    public Integer getTempoRestante(){
        Integer tempoRestante = 0;
        
        for(TimeSharingProcesso thread : timeSharing) {
            if(tempo < thread.getQuantum()){
                tempoRestante = tempo;
                break;
            }else{
                tempoRestante += thread.getQuantum();
            }
        }
        
        return tempoRestante;
    }
    
    public Integer getTempoEspera(){
        return tempoEspera;
    }
    
    public void setTempoEspera(Integer tempo){
        tempoEspera = tempo;
    }
    
    public void encerrar(){
        this.situacao = SituacaoProcesso.Pronto;
    }
    
    public boolean estaConcluido(){
        return this.situacao == SituacaoProcesso.Pronto;
    }
    
    public void gerarTimeSharing(Integer quantum){
        if(this.timeSharing != null) return;
        
        this.timeSharing = new ArrayList();
        Integer quantidadeExecucoes = calcularQuantidadeDeExecucoes(quantum);
        
        for (int i = 0; i < quantidadeExecucoes; i++){
            this.timeSharing.add(new TimeSharingProcesso(this, i+1,quantidadeExecucoes,quantum));
        }
    }
    
    private Integer calcularQuantidadeDeExecucoes(Integer quantum){
        Integer quantidadeThreads = this.tempo/quantum;
        return (quantidadeThreads >= 1) ? quantidadeThreads: 1;
    }

    public void executar(){
        if(this.timeSharing == null) throw new RuntimeException();
        if(this.estaConcluido()) return;

        this.situacao = SituacaoProcesso.Executando; //Ao iniciar a execução mudo o status para 'Executando'
        
        this.timeSharing.get(0).executar(); //Executo a thread
        this.timeSharing.remove(0); //Removo thread já executada da lista
        this.situacao = SituacaoProcesso.Aguardando; //Altero o status para Aguardando(Será executado na próxima iteração da fila)

        if(this.timeSharing.isEmpty()) this.encerrar(); //Quando a lista está vazia, todas as threads foram executadas   
    }
}
