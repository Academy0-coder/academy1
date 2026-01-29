package Settimana3.esercizioEsame.elezioni.services;


import Settimana3.esercizioEsame.elezioni.entities.*;

import java.util.*;


public class ElezioneImpl implements Elezione {

	List<Cittadino> elettori;
	List<Lista> liste;
	int numeroVotanti;

	public ElezioneImpl(){
		elettori = new ArrayList<Cittadino>();
		liste = new ArrayList<Lista>();
		numeroVotanti = 0;
	}

	public boolean cittadinoPresent(String nome, String cognome){
		return elettori.stream().filter(cittadino ->
				cittadino.getNome().equalsIgnoreCase(nome) && cittadino.getCognome().equalsIgnoreCase(cognome))
				.findFirst()
				.isPresent();
	}
	
	public Cittadino aggiungiElettore(String nome, String cognome) throws CittadinoNonValido {
		if(cittadinoPresent(nome, cognome)){
			throw new CittadinoNonValido("Cittadino già presente");
		}
		Cittadino cittadino = new CittadinoImpl(nome, cognome);
		elettori.add(cittadino);
		return cittadino;

	}
	
	public Collection getElettori(){
		return elettori;
	}
	
	public Cittadino getElettore(String nome, String cognome) throws CittadinoNonValido {
		if(cittadinoPresent(nome, cognome)){
			return elettori.stream().filter(cittadino ->
							cittadino.getNome().equalsIgnoreCase(nome) && cittadino.getCognome().equalsIgnoreCase(cognome))
					.findFirst().get();
		}
		throw new CittadinoNonValido("Cittadino non presente");
	}
	
	public void registraLista(String nome, String motto){
		if(liste.stream()
				.filter(lista -> lista.getNome().equalsIgnoreCase(nome))
				.findFirst().isPresent()){
			throw new ListaNonValida("lista già presente");
		}
		liste.add(new ListaImpl(nome, motto));
	}

	public Lista getLista(String nome){
		return liste.stream().filter(lista ->
				lista.getNome().equalsIgnoreCase(nome))
				.findFirst().get();
	}

	public List<Lista> getListe(){
		return liste;
	}

    /**
     * Il cittadino votante esprime un voto per la lista ed 
     * un voto di preferenza per il candidato identificato
     * da nome e cognome
     * @throws TentatoDoppioVoto se il cittadino ha gi� votato
     * @throws TaglioNonPermesso se il candidato per cui si esprime
     * 							la preferenza non appartiene alla lista
     */	
	public void vota(Cittadino votante, String nomeLista, String nome, String cognome) throws TentatoDoppioVoto, TaglioNonPermesso, CittadinoNonValido {
		if(votante.haVotato()){
			throw new TentatoDoppioVoto("Il cittadino ha già votato");
		}
		try{
			Cittadino cittadino = getElettore(nome, cognome);
		}
		catch (CittadinoNonValido e) {}

		Cittadino eletto = getElettore(nome, cognome);

        try{liste.stream()
				.filter(lista -> lista.getNome().equalsIgnoreCase(nomeLista))
				.findFirst().get();
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}

		Lista listaScelta = liste.stream()
				.filter(lista -> lista.getNome().equalsIgnoreCase(nomeLista))
				.findFirst().get();

		if(!(listaScelta.getCandidati().contains(eletto) || listaScelta.getCapolista().equals(eletto))){
			throw new TaglioNonPermesso("Candidato non presente in quella lista");
		}

		votante.setVotato(true);
		eletto.addVoto();
		listaScelta.addVoto();
		numeroVotanti++;


	}

	/**
	 * Il cittadino votante esprime un voto per la lista
	 * il voto di preferenza va automaticamente al capolista
	 * @throws TentatoDoppioVoto se il cittadino ha gi� votato
	 */	
	public void vota(Cittadino votante, String nomeLista) throws TentatoDoppioVoto{
		if(votante.haVotato()){
			throw new TentatoDoppioVoto("Il cittadino ha già votato");
		}
		try{
			Lista listaScelta = liste.stream()
					.filter(lista ->
							lista.getNome().equalsIgnoreCase(nomeLista))
					.findFirst().get();
			votante.setVotato(true);
			listaScelta.addVoto();
			numeroVotanti++;
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}

	}
	
	public long getNumeroVotanti(){
		return numeroVotanti;
	}
	
	public List<Lista> getRisultatiListe(){
		return liste.stream()
				.sorted(Comparator.comparing(Lista::getNumeroVoti).reversed())
				.toList();
	}

	public List<Cittadino> getRisultatiCandidati(){
		return elettori.stream()
				.filter(Cittadino::isCandidato)
				.sorted(Comparator.comparing(Cittadino::getNumeroVoti).reversed())
				.toList();
	}
	
	
}
