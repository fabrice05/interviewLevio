package ca.Levio.interview.model;
import jakarta.persistence.*;
 
    
    @Entity
@Table(name = "technicalAdvisor")
public class Interview {

	private long id;
	private String name;
	private String lastName;
	private String email;
        private boolean actif;
	
	public Interview() {
		
	}
	
	public Interview(String firstName, String lastName, String emailId) {
		this.name = firstName;
		this.lastName = lastName;
		this.email = emailId;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "first_name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "email_address", nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + name + ", lastName=" + lastName + ", emailId=" + email
				+ "]";
	}
	
}
    
