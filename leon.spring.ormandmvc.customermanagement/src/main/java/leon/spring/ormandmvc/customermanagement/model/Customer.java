package leon.spring.ormandmvc.customermanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_records")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_Id")
	private long customerId;
	@Column(name = "first_name", length = 512)
	private String custFirstName;
	@Column(name = "last_name", length = 512)
	private String lastName;
	@Column(name = "email_add", length = 512)
	private String emailAdd;

	public Customer() {
		super();
	}

	public Customer(String custFirstName, String lastName, String emailAdd) {
		super();
		this.custFirstName = custFirstName;
		this.lastName = lastName;
		this.emailAdd = emailAdd;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustFirstName() {
		return custFirstName;
	}

	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAdd() {
		return emailAdd;
	}

	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", custFirstName=" + custFirstName + ", lastName=" + lastName
				+ ", emailAdd=" + emailAdd + "]";
	}

}
