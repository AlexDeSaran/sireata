package br.edu.utfpr.dv.sireata.bo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.utfpr.dv.sireata.dao.AnexoDAO;
import br.edu.utfpr.dv.sireata.dao.ModelDAO;
import br.edu.utfpr.dv.sireata.model.Anexo;

public class AnexoBO extends ModelBO {

	public Anexo buscarPorId(int id) throws Exception {
		try {

			return getDAO().buscarPorId(id);
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);

			throw new Exception(e.getMessage());
		}
	}

	public List<Anexo> listarPorAta(int idAta) throws Exception {
		try {

			return new AnexoDAO().listarPorAta(idAta);
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);

			throw new Exception(e.getMessage());
		}
	}

	public void validarDados(Anexo anexo) throws Exception {
		if (anexo.getArquivo() == null) {
			throw new Exception("Efetue o envio do arquivo.");
		}
		if (anexo.getDescricao().isEmpty()) {
			throw new Exception("Informe a descrição do anexo.");
		}
	}

	public int salvar(Anexo anexo) throws Exception {
		try {
			if ((anexo.getAta() == null) || (anexo.getAta().getIdAta() == 0)) {
				throw new Exception("Informe a ata.");
			}

			this.validarDados(anexo);

			return getDAO().salvar(anexo);
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);

			throw new Exception(e.getMessage());
		}
	}

	public void excluir(int id) throws Exception {
		try {

			new AnexoDAO().excluir(id);
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);

			throw new Exception(e.getMessage());
		}
	}
	@Override
	public ModelDAO<Anexo> getDAO() {
		// TODO Auto-generated method stub
		return new AnexoDAO();
	}

}
