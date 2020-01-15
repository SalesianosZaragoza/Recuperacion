package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.CharacterAssembler;
import es.salesianos.model.Character;
import es.salesianos.model.Race;
import es.salesianos.repository.CharacterRepository;

public class CharacterService implements Service {

	private CharacterAssembler assembler = new CharacterAssembler();
	private CharacterRepository repository = new CharacterRepository();

	public CharacterService() {

	}

	public Character createNewCharacterFromRequest(HttpServletRequest req) {
		Character character = assembler.createCharacterFromRequest(req);
		return character;
	}

	public void insertCharacter(Character character) {
		repository.insert(character);
	}

	public List<Character> listAll() {
		return repository.listAll();
	}

	public void update(Character character) {
		repository.update(character);
	}

	public Race createNewRaceFromRequest(HttpServletRequest req) {
		return null;
	}

	public void insertRace(Race user) {

	}

	public List<Character> listCharacters() {
		return repository.listAll();
	}

	public List<Race> listRaces() {
		return null;
	}

}
