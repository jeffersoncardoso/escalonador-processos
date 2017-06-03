package dominio;

public class TimeSharingProcesso {

    private Processo processo;
    private final Integer numero;
    private final Integer total;
    private final Integer quantum;

    public TimeSharingProcesso(Processo processo, Integer numero, Integer total, Integer quantum) {
        this.processo = processo;
        this.numero = numero;
        this.total = total;
        this.quantum = quantum;
    }
    
    public Integer getQuantum(){
        return quantum;
    }
    
    public void executar(){
        try{
            LogProcesso.log("Executando processo %d (%d/%d)", this.processo.getId(), this.numero, this.total);
            Thread.sleep(calcularTempoExecucao() * 1000);
        }catch(InterruptedException e){}
    }
    
    private int calcularTempoExecucao(){
        int tempoRestante = this.processo.getTempoRestante();
        int tempoExecucao = (tempoRestante >= quantum) ? quantum : tempoRestante;
        
        return tempoExecucao;
    }
}
