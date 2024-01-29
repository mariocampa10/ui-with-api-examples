package test;

import api.client.PetStoreApiClient;
import api.models.Pet;
import api.models.UserData;
import api.utils.PetNameCounter;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.List;

public class Exercise2Test {

    //Test data
    private static final String SOLD_STATUS = "sold";
    private List<Pet> pets;

    @Test
    public void createNewUser() {
        UserData userData = new UserData();
        userData.setId("0");
        userData.setUsername("mariotest");
        userData.setFirstName("mario");
        userData.setLastName("test");
        userData.setEmail("mariotest@mail.com");
        userData.setPassword("test");
        userData.setPhone("666666666");
        userData.setUserStatus("0");

        Response response = PetStoreApiClient.createUser(userData);
        System.out.println("User response data: ");
        System.out.println(response.getBody().asString());
    }

    @Test
    public void printSoldPets() {
        Response response = PetStoreApiClient.findPetByStatus(SOLD_STATUS);
        pets = response.jsonPath().getList("", Pet.class);

        System.out.println("List of sold pets: ");
        for (Pet pet : pets) {
            System.out.println("{" + pet.getId() + ", " + pet.getName() + "}");
        }
    }

    @Test(dependsOnMethods = {"printSoldPets"})
    public void printSoldPetsWithSharedName() {
        PetNameCounter petNameCounter = new PetNameCounter(pets);
        System.out.println("List of sold pets with repeated name: ");
        petNameCounter.printPetsWithRepeatedName();
    }
}
