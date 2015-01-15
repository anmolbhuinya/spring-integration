package crm.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

//Using JAXB2 to support integration with external CRM for international leads
@XmlRootElement
@XmlType(propOrder = {
	"firstName", "lastName",
	"address1", "address2", "city", "stateOrProvince", "postalCode", "country",
	"homePhone", "workPhone", "mobilePhone", "email" })
public class Lead {
	private static DateFormat dateFormat = new SimpleDateFormat();
	
	private String firstName;
	private String middleInitial;
	private String lastName;
	private String address1;
	private String address2;
	private String city;
	private String stateOrProvince;
	private String postalCode;
	private String country;
	private String homePhone;
	private String workPhone;
	private String mobilePhone;
	private String email;
	private Date dateCreated;
	
	public Lead() { }
	
	@XmlElement(name = "givenName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@XmlTransient
	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	@XmlElement(name = "surname")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	@XmlElement
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@XmlElement
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@XmlElement
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@XmlElement
	public String getStateOrProvince() {
		return stateOrProvince;
	}

	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}

	@XmlElement
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	@XmlElement
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public boolean isInternational() {
		boolean unknown = (country == null);
		boolean domestic = ("US".equals(country));
		return !(unknown || domestic);
	}
	
	@XmlElement
	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	@XmlElement
	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	@XmlElement
	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
	@XmlElement(name="emailAddress")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlTransient
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public String toString() {
		return "[Lead: firstName=" + firstName +
			", lastName=" + lastName +
			", middleInitial=" + middleInitial +
			", address1=" + address1 +
			", address2=" + address2 +
			", city=" + city +
			", stateOrProvince=" + stateOrProvince +
			", postalCode=" + postalCode +
			", country=" + country +
			", homePhone=" + homePhone +
			", workPhone=" + workPhone +
			", mobilePhone=" + mobilePhone +
			", email=" + email +
			", dateCreated=" + dateFormat.format(dateCreated) +
			"]";
	}
}
