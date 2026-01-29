package Settimana3.esercizioEsame.elezioni.entities;

import Settimana3.esercizioEsame.elezioni.services.CandidatoNonValido;

import java.util.ArrayList;
import java.util.List;


public class ListaImpl implements Lista{

	private String nome;
	private String motto;
	private List<Cittadino> candidati;
	private Cittadino capolista;
	private long numeroVoti;

	public ListaImpl(String nome, String motto){
		this.nome = nome;
		this.motto = motto;
		candidati = new ArrayList<>();
		capolista = null;
		numeroVoti = 0;
	}

	@Override
	public String getNome(){
		return nome;
	}

	@Override
	public String getMotto(){
		return motto;
	}

	@Override
	public void assegnaCapolista(Cittadino cittadino) throws CandidatoNonValido {
		if(cittadino.getLista().isEmpty()){
			cittadino.setCapolista(true);
			cittadino.setCandidato(true);
			capolista = cittadino;
		}
		else if(cittadino.getLista().get() != this){
			throw new CandidatoNonValido("Candidato già presente in un'altra lista");
		}
		else if(!cittadino.isCapolista()){
			cittadino.setCapolista(true);
			candidati.remove(cittadino);
			capolista = cittadino;

		}

	}

	@Override
	public void aggiungiCandidato(Cittadino cittadino) throws CandidatoNonValido {
		if(cittadino.getLista().isEmpty()){
			cittadino.setCandidato(true);
			candidati.add(cittadino);
		}
		else if(cittadino.getLista().get() != this){
			throw new CandidatoNonValido("Candidato già presente in un'altra lista");
		}
		else if(cittadino.isCapolista()){
			cittadino.setCapolista(false);
			capolista = null;
			candidati.add(cittadino);
		}
	}

	@Override
	public Cittadino getCapolista(){
		return capolista;
	}

	/**
	 * Restuisce la collezione dei candidati
	 * (NON include il capolista)
	 */
	@Override
	public List<Cittadino> getCandidati(){
		return candidati;
	}

	@Override
	public long getNumeroVoti(){
		return numeroVoti;
	}

	@Override
	public void addVoto(){
		numeroVoti++;
	}

	@Override
	public double getPercentualeVoti(List<Lista> liste){
		Long allVotes = liste.stream()
				.mapToLong(Lista::getNumeroVoti)
				.sum();
		return numeroVoti*100/allVotes;
	}
}
