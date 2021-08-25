package com.certant.pokedexliteengrupo.pokemon.atributos.pokemonenentrenamiento.entity;

public class PokemonEntrenadoAuxiliar {
	Long idPokemon;
	Integer nivelActual;
	
	public PokemonEntrenadoAuxiliar() {
		
	}
	
	public Long getIdPokemon() {
		return idPokemon;
	}
	public void setIdPokemon(Long idPokemon) {
		this.idPokemon = idPokemon;
	}
	public Integer getNivelActual() {
		return nivelActual;
	}
	public void setNivelActual(Integer nivelActual) {
		this.nivelActual = nivelActual;
	}

	@Override
	public String toString() {
		return "PokemonEntrenadoAuxiliar [" + idPokemon + "," + nivelActual + "]";
	}
	
}
