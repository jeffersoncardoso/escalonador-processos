package dominio;

public enum TipoProcesso{
    IOBound, CPUBound;
    
    public static TipoProcesso get(String tipo){
        switch(tipo){
            case "I": return IOBound;
            case "C": return CPUBound;
            default: throw new RuntimeException("Tipo de processo inválido");
        }
    }
    
    public String getDescricao(){
        switch(this){
            case IOBound  : return "IO-Bound";
            case CPUBound : return "CPU-Bound";
            default: return "";
        }
    }
}
