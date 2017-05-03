package dominio;

import java.util.ArrayList;

public class Processo{
    
    private Integer id;
    private Integer tempo;
    private SituacaoProcesso situacao;
    
    private ArrayList<TimeSharingProcesso> timeSharing;
    
    public Processo(Integer tempo){
        this.tempo = tempo;
        this.situacao = SituacaoProcesso.Pendente;
    }

    public Integer getId(){
        return id;
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
            tempoRestante += thread.getQuantum();
        }
        
        return tempoRestante;
    }
    
    public void iniciar(){
        this.situacao = SituacaoProcesso.Executando;
    }
    
    public void parar(){
        this.situacao = SituacaoProcesso.Aguardando;
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
            this.timeSharing.add(new TimeSharingProcesso(this.id, i+1,quantidadeExecucoes,quantum));
        }
    }
    
    private Integer calcularQuantidadeDeExecucoes(Integer quantum){
        Integer quantidadeThreads = this.tempo/quantum;
        return (quantidadeThreads >= 1) ? quantidadeThreads: 1;
    }

    public void executar(){
        if(this.timeSharing == null) throw new RuntimeException();
        if(this.estaConcluido()) return;

        this.situacao = SituacaoProcesso.Executando;
        this.timeSharing.get(0).executar();
        this.timeSharing.remove(0);
        this.situacao = SituacaoProcesso.Aguardando;

        if(this.timeSharing.isEmpty()) this.encerrar();
    }
}
