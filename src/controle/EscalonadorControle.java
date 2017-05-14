package controle;

import dominio.Escalonador;
import dominio.LogProcesso;
import dominio.Processo;
import dominio.TipoProcesso;
import java.util.Iterator;
import javax.swing.JTextArea;

public class EscalonadorControle {

    private Escalonador escalonador;
    
    public EscalonadorControle(){
        
    }
    
    public boolean estalonadorEstaEmExecucao(){
        return this.escalonador instanceof Escalonador;
    }
    
    public void iniciarEscalonador(String qtdProcessos, String valorQuantum) throws RuntimeException{
        if(escalonador instanceof Escalonador) { return; }
        if(!isInteger(qtdProcessos)) throw new RuntimeException("Preencha corretamente o campo 'Processos por minuto'");
        if(!isInteger(valorQuantum)) throw new RuntimeException("Preencha corretamente o campo 'Quantum'");

        escalonador = new Escalonador(
            Integer.parseInt(qtdProcessos),
            Integer.parseInt(valorQuantum)
        );
        
        new Thread(){ //Rodando escalonador a cada 100ms
            public void run(){
                while(true){
                    try{
                        if(escalonador.possuiProcessos()){
                            escalonador.escalonar();
                        }else{
                            Thread.sleep(100);
                        }
                    }catch(InterruptedException e){}
                }
            }  
        }.start();
    }
    
    public void criarProcesso(String tempoVida, String tipo) throws RuntimeException{
        if(!isInteger(tempoVida)) throw new RuntimeException("Preencha corretamente o campo 'Tempo de vida'");
        if(Integer.parseInt(tempoVida) == 0) throw new RuntimeException("O tempo de vida do processo deve ser maior que zero");
        
        escalonador.criar(
            new Processo(Integer.parseInt(tempoVida), TipoProcesso.get(tipo))
        );
    }
    
    public String listarProcessosEmExecucao(){
        if(escalonador.possuiProcessos()){
            StringBuilder builder = new StringBuilder();
            
            builder.append("PID").append("\t")
                    .append("Tipo").append("\t")
                    .append("Situação").append("\t")
                    .append("Tempo Restante");
            
            for (Iterator<Processo> iterator = escalonador.getProcessos().iterator(); iterator.hasNext();) {
                Processo processo = iterator.next();
                builder.append("\n")
                        .append(processo.getId()).append("\t")
                        .append(processo.getTipo().getDescricao()).append("\t")
                        .append(processo.getSituacao().getDescricao()).append("\t")
                        .append(processo.getTempoRestante());
            }
            
            return builder.toString();
        }else{
            return "Não possui processos em execução";
        }
    }
    
    public String listarProcessosEmEspera(){
        if(escalonador.possuiProcessosEmEspera()){
            StringBuilder builder = new StringBuilder();
            
            builder.append("PID").append("\t")
                    .append("Tipo").append("\t")
                    .append("Situação").append("\t");
            
            for (Iterator<Processo> iterator = escalonador.getProcessosEmEspera().iterator(); iterator.hasNext();) {
                Processo processo = iterator.next();
                builder.append("\n")
                        .append(processo.getId()).append("\t")
                        .append(processo.getTipo().getDescricao()).append("\t")
                        .append(processo.getSituacao().getDescricao()).append("\t");
            }
            
            return builder.toString();
        }else{
            return "Não possui processos em espera";
        }
    }
    
    public JTextArea mostrarLogDeExecucao(JTextArea textArea_logProcesso){
        textArea_logProcesso.setText(LogProcesso.getLog());
        textArea_logProcesso.setCaretPosition(textArea_logProcesso.getText().length());
        
        return textArea_logProcesso;
    }
    
    
    private static boolean isInteger(String s) {
      boolean isValidInteger = false;
      try{
         Integer.parseInt(s);
         isValidInteger = true;
      }
      catch (NumberFormatException ex){
         // s is not an integer
      }
 
      return isValidInteger;
   }
}
