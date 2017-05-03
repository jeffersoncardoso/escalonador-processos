package dominio;

public enum SituacaoProcesso {
    Pendente,Aguardando,Executando,Pronto;

    public String getDescricao() {
        if(this == SituacaoProcesso.Pendente) return "Pendente";
        if(this == SituacaoProcesso.Aguardando) return "Aguardando";
        if(this == SituacaoProcesso.Executando) return "Executando";
        if(this == SituacaoProcesso.Pronto) return "Pronto";
        
        return "";
    }
}
