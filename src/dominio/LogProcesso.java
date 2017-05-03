package dominio;

import java.util.ArrayList;

public class LogProcesso{
    
    public static ArrayList<String> log = new ArrayList();
    public static Integer ultimaQuantidadeDeLog;
    
    public static void log(String format, Object ... args){
        String message = String.format(format, args);
        System.out.println(message);
        log.add(message);
    }
    
    public static String getLog(){
        ultimaQuantidadeDeLog = log.size();
        
        StringBuilder builder = new StringBuilder();
        for(String string : log) {
            builder.append(string).append("\n");
        }
        
        return builder.toString();
    }
    
    public static boolean houveMudancas(){
        return log.size() != ultimaQuantidadeDeLog;
    }
}
