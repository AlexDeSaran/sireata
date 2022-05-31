package br.edu.utfpr.dv.sireata.bo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.utfpr.dv.sireata.dao.CampusDAO;
import br.edu.utfpr.dv.sireata.dao.ModelDAO;
import br.edu.utfpr.dv.sireata.dao.ModelDAO;
import br.edu.utfpr.dv.sireata.model.Campus;

public class CampusBO extends ModelBO {

	public Campus buscarPorId(int id) throws Exception {
		try {

			return getDAO().buscarPorId(id);
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);

			throw new Exception(e.getMessage());
		}
	}

	public Campus buscarPorDepartamento(int idDepartamento) throws Exception {
		try {

			return new CampusDAO().buscarPorDepartamento(idDepartamento);
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);

			throw new Exception(e.getMessage());
		}
	}

	public List<Campus> listarTodos(boolean apenasAtivos) throws Exception {
		try {

			return new CampusDAO().listarTodos(apenasAtivos);
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);

			throw new Exception(e.getMessage());
		}
	}

	public List<Campus> listarParaCriacaoAta(int idUsuario) throws Exception {
		try {

			return new CampusDAO().listarParaCriacaoAta(idUsuario);
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);

			throw new Exception(e.getMessage());
		}
	}

	public List<Campus> listarParaConsultaAtas(int idUsuario) throws Exception {
		try {

			return new CampusDAO().listarParaConsultaAtas(idUsuario);
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);

			throw new Exception(e.getMessage());
		}
	}

	public int salvar(Campus campus) throws Exception {
		if (campus.getNome().isEmpty()) {
			throw new Exception("Informe o nome do câmpus.");
		}

		try {

			return getDAO().salvar(campus);
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);

			throw new Exception(e.getMessage());
		}
	}

	@Override
	public ModelDAO<Campus> getDAO() {
		// TODO Auto-generated method stub
		return new CampusDAO();
	}

}