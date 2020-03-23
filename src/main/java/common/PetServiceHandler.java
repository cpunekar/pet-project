package common;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import database.DatabaseClient;
import model.*;

public class PetServiceHandler {
	DatabaseClient dbClient = DatabaseClient.getInstance();
	
	private PetServiceHandler() {
		
	}
	
	private static class PetServiceHandlerInstance {
		private static final PetServiceHandler petServiceHandler = new PetServiceHandler();
	}
	
	public static PetServiceHandler getInstance() {
		return PetServiceHandlerInstance.petServiceHandler;
	}
	
	public List<Pet> getPet() {
		List<Pet> listOfPets = new ArrayList<Pet>();
		try {
			String sql = "select id, name, tag from pet";
			PreparedStatement prepStmt = dbClient.getConnection().prepareStatement(sql);
			ResultSet rs = prepStmt.executeQuery(sql);
			Pet pet;
			
			if (rs.next() == false) {
				System.out.printf("Result Set is empty for pets");
			} else {
				do {
					pet = new Pet();
					pet.setId(rs.getLong("id"));
					pet.setName(rs.getString("name"));
					pet.setTag(rs.getString("tag"));
					listOfPets.add(pet);
				} while (rs.next());
			}

			
		} catch (Exception e) {
			System.out.printf("No pets found");
		}
		return listOfPets;
	}
	
	public List<Pet> getPetById(Long id) {
		List<Pet> listOfPets = new ArrayList<Pet>();
		try {
			String sql = "select id, name, tag from pet where id= ?";
			PreparedStatement prepStmt = dbClient.getConnection().prepareStatement(sql);
			prepStmt.setLong(1, id);
			ResultSet rs = prepStmt.executeQuery();
			Pet pet;
			
			if (rs.next() == false) {
				System.out.printf("Result Set is empty for pets");
			} else {
				do {
					pet = new Pet();
					pet.setId(id);
					pet.setName(rs.getString("name"));
					pet.setTag(rs.getString("tag"));
					listOfPets.add(pet);
				} while (rs.next());
			}

			
		} catch (Exception e) {
			System.out.printf("No pets found", e);
			e.printStackTrace();
		}
		return listOfPets;
	}
	
	
	public Pet addPet(String name, String tag) {
		Pet response = new Pet();
		try {
			String sql = "insert into pet(name, tag) values (?, ?)";
			PreparedStatement prepStmt = dbClient.getConnection().prepareStatement(sql);
			prepStmt.setString(1, name);
			prepStmt.setString(2, tag);
			prepStmt.executeUpdate();
			
			response.setName(name.toString());
			response.setTag(tag.toString());
			
		} catch (Exception e) {
			System.out.printf("Failed to create pet");
			e.printStackTrace();
		}
		return response;
	}
	
	public List<Pet> deletePet(Long id) {
		List<Pet> listOfPets = new ArrayList<Pet>();
		try {
			String sql = "select id, name, tag from pet where id= ?";
			PreparedStatement prepStmt = dbClient.getConnection().prepareStatement(sql);
			prepStmt.setLong(1, id);
			ResultSet rs = prepStmt.executeQuery();
			Pet pet;
			
			if (rs.next() == false) {
				System.out.printf("Result Set is empty for pets");
			} else {
				do {
					pet = new Pet();
					pet.setId(id);
					pet.setName(rs.getString("name"));
					pet.setTag(rs.getString("tag"));
					listOfPets.add(pet);
				} while (rs.next());
			}

			
		} catch (Exception e) {
			System.out.printf("No pets found", e);
			e.printStackTrace();
		}
		return listOfPets;
	}

}
