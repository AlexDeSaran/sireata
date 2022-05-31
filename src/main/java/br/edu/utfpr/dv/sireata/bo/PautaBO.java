package br.edu.utfpr.dv.sireata.bo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.edu.utfpr.dv.sireata.dao.ModelDAO;
import br.edu.utfpr.dv.sireata.dao.PautaDAO;
import br.edu.utfpr.dv.sireata.model.Pauta;

public class PautaBO extends ModelBO {

	public Pauta buscarPorId(int id) throws Exception {
		try {

			return getDAO().buscarPorId(id);
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);

			throw new Exception(e.getMessage());
		}
	}

	public List<Pauta> listarPorAta(int idAta) throws Exception {
		try {

			return new PautaDAO().listarPorAta(idAta);
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);

			throw new Exception(e.getMessage());
		}
	}

	public void validarDados(Pauta pauta) throws Exception {
		if (pauta.getTitulo().isEmpty()) {
			throw new Exception("Informe o título da pauta.");
		}
	}

	public int salvar(Pauta pauta) throws Exception {
		try {
			if ((pauta.getAta() == null) || (pauta.getAta().getIdAta() == 0)) {
				throw new Exception("Informe a ata.");
			}

			this.validarDados(pauta);

			return getDAO().salvar(pauta);
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);

			throw new Exception(e.getMessage());
		}
	}

	public void excluir(int id) throws Exception {
		try {

			new PautaDAO().excluir(id);
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);

			throw new Exception(e.getMessage());
		}
	}

	@Override
	public ModelDAO<Pauta> getDAO() {
		// TODO Auto-generated method stub
		return new PautaDAO();
	}

}