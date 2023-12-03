public class Contact implements Comparable<Contact> {
    private String contactName;
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private String birthday;
    private String notes;
    private LinkedList<String> eventsCalendar;
    

    public Contact() {
        this.eventsCalendar = new LinkedList<>();
        this.contactName = null;
        this.phoneNumber = null;
        this.emailAddress = null;
        this.address = null;
        this.birthday = null;
        this.notes = null;
        
    }

    public Contact(Contact c) {
        
        this.contactName = c.contactName;
        this.phoneNumber = c.phoneNumber;
        this.emailAddress = c.emailAddress;
        this.address = c.address;
        this.birthday = c.birthday;
        this.notes = c.notes;
    }

    public Contact(String contactName, String phoneNumber, String emailAddress, String address, String notes, String birthday) {
        
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.notes = notes;
        this.birthday = birthday;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getType(String type) {
        if (type.equalsIgnoreCase("Name")) {
            return getContactName();
        } else if (type.equalsIgnoreCase("Email")) {
            return getEmailAddress();
        } else if (type.equalsIgnoreCase("Address")) {
            return getAddress();
        } else if (type.equalsIgnoreCase("PhoneNumber")) {
            return getPhoneNumber();
        } else if (type.equalsIgnoreCase("Birthday")) {
            return getBirthday();
        }
        return null;
    }

    public int compareTo(Contact o) {
        return this.contactName.compareTo(o.getContactName());
    }
    public int compareToType(Contact o, String Type) {
    	if(Type.equalsIgnoreCase("PhoneNumber"))
    		return this.phoneNumber.compareTo(o.getPhoneNumber());
    	else if(Type.equalsIgnoreCase("Adreass"))
    		return this.address.compareTo(o.getAddress());
    	else if(Type.equalsIgnoreCase("Email"))
    		return this.emailAddress.compareTo(o.getEmailAddress());
    	else
    		return 0;
    }
    @Override
    public String toString() {
        return "\nName: " + this.contactName +
                "\nPhone Number: " + this.phoneNumber +
                "\nEmail Address: " + this.emailAddress +
                "\nAddress: " + this.address +
                "\nBirthday: " + this.birthday +
                "\nNotes: " + this.notes + "\n";
    }
	public void addtoCaliender(String Date) {
		eventsCalendar.insert(Date);
	}
	
    
	public boolean conflictDate(String DateAndTime) {
		if (eventsCalendar.empty()) {
			return false;
		} else {
			eventsCalendar.findfirst();
			boolean Signal=true;
			while (Signal) {
				if (eventsCalendar.retrieve().equalsIgnoreCase(DateAndTime))
						{
					System.out.println(DateAndTime);
					return true;
				}
				if(eventsCalendar.last())
					break;
				eventsCalendar.findnext();;
			}
		}
		return false;
	}


	
}