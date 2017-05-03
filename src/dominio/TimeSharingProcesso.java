package dominio;

public class TimeSharingProcesso {

    private Integer idProcesso;
    private final Integer numero;
    private final Integer total;
    private final Integer quantum;

    public TimeSharingProcesso(Integer idProcesso, Integer numero, Integer total, Integer quantum) {
        this.idProcesso = idProcesso;
        this.numero = numero;
        this.total = total;
        this.quantum = quantum;
    }
    
    public Integer getQuantum(){
        return quantum;
    }
    
    public void executar(){
        try{
            LogProcesso.log("Executando processo %d (%d/%d)", this.idProcesso, this.numero, this.total);
            Thread.sleep(quantum * 1000);
        }catch(InterruptedException e){}
    }
}
