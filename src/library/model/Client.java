package library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 *
 * @author hirwa
 */
@Entity
public class Client {
    @Id
    private String registrationNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private ClientType clientCategory;
    @Lob
    @Column(name = "image" ,columnDefinition = "LONGBLOB")
    private byte[] image;

    public Client() {
    }

    public Client(String registrationNumber, String firstName, String lastName, String phoneNumber, String email, ClientType clientCategory, byte[] image) {
        this.registrationNumber = registrationNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.clientCategory = clientCategory;
        this.image = image;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClientType getClientCategory() {
        return clientCategory;
    }

    public void setClientCategory(ClientType clientCategory) {
        this.clientCategory = clientCategory;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    
}
