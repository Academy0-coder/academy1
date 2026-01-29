package Settimana3.EsercizioEsame.elezioni.entities;


import java.util.Optional;

public interface Cittadino {

	public String getNome();
	public String getCognome();

	public boolean haVotato();
	public void setVotato(boolean votato);

	public boolean isCandidato();
	public void setCandidato(boolean candidato);

	public boolean isCapolista();
	public void setCapolista(boolean capolista);

	public long getNumeroVoti();
	public void addVoto();

	public Optional<Lista> getLista();
	public void setLista(Lista lista);
}