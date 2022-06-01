package br.edu.utfpr.dv.sireata.bo;
import br.edu.utfpr.dv.sireata.dao.AtaDAO;
import br.edu.utfpr.dv.sireata.dao.ModelDAO;
//SEGUINDO O MESMO PADRÃO DO https://github.com/gabrielcostasilva/dp-factory-method NÃO USEI O NOME DE FACTORY PARA A CLASSE PARA NÃO CAUSAR CONFUSÃO.

public abstract class ModelBO<E> {

    public enum ITEMS {
        ANEXODAO,ATADAO,ATAPARTICIPANTEDAO,CAMPUSDAO,COMENTARIODAO,DEPARTAMENTODAO,ORGAODAO,PAUTADAO,USUARIODAO
    }
    public static ModelDAO from(ITEMS dataRetriever) {

        switch (dataRetriever) {
            case ANEXODAO:
                return new br.edu.utfpr.dv.sireata.bo.AnexoBO().getDAO();
            case ATADAO:
                return new br.edu.utfpr.dv.sireata.bo.AtaBO().getDAO();
            case ATAPARTICIPANTEDAO:
                return new br.edu.utfpr.dv.sireata.bo.AtaParticipanteBO().getDAO();
            case CAMPUSDAO:
                return new br.edu.utfpr.dv.sireata.bo.CampusBO().getDAO();
            case COMENTARIODAO:
                return new br.edu.utfpr.dv.sireata.bo.ComentarioBO().getDAO();
            case DEPARTAMENTODAO:
                return new br.edu.utfpr.dv.sireata.bo.DepartamentoBO().getDAO();
            case ORGAODAO:
                return new br.edu.utfpr.dv.sireata.bo.OrgaoBO().getDAO();
            case PAUTADAO:
                return new br.edu.utfpr.dv.sireata.bo.PautaBO().getDAO();
            case USUARIODAO:
                return new br.edu.utfpr.dv.sireata.bo.UsuarioBO().getDAO();
            default:
                return null;
        }
    }

    public abstract ModelDAO getDAO();
}
