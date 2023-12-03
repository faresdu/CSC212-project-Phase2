import java.util.Date;
public class Event implements Comparable<Event>{
	private String eventTitle;
	private Date dateAndTime;
	private String location;
	private String Type; //event , \\apointment
	private contactBST contactstree;
	private Contact contact;
	
	
	
	public Event() {
		this.contactstree = new contactBST();
		this.eventTitle = null;
		this.location = null;
		
	}
	public Event(String eventTitle,Date date, String time, String location) {
		this.eventTitle = eventTitle;
		this.dateAndTime=date;
		this.location = location;
		
	}
	public String getEventTitle() {
		return eventTitle;
	}
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	
	public Date getDateAndTime() {
		return dateAndTime;
	}
	
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	

	public void printEventDet() {
	    System.out.println( "\nEvent found!\n" +
	            "Event title: " + getEventTitle() + "\n" +
	            "Contacts: " );
	    		contactstree.Printcontact();
	    		System.out.println(
	    "\n" +
	            "Event date and time: " + getDateAndTime() + "\n" +
	            "Event Location: " + getLocation() + "\n");
	}
	public void printApointmentDetails() {
	    System.out.println( "\nAppinment found!\n" +
	            "Apointment title: " + getEventTitle() + "\n" +
	            "Contacts: " );
	    		System.out.println(contact.getContactName());
	    		System.out.println(
	    "\n" +
	            "Apointment date and time: " + getDateAndTime() + "\n" +
	            "Apointment Location: " + getLocation() + "\n");
	}
	public boolean isEmptyContact() {
		return contactstree.empty();
	}
	public boolean findContactInEvent(String data) {
    	if(contactstree.empty()) {
    		return false;
    	}
		return contactstree.findKey(data);
    	
    	}

	public void addContacttoEvent(Contact a) {
		contactstree.insert(a.getContactName(),a);
	}
	public void removeContactInEvent(String key) {
		if(Type.equalsIgnoreCase("Event")) {
		contactstree.removeKey(key);}
	}
	
	public int compareTo(Event o) {  
        try {  
            return (this.eventTitle.compareTo(o.getEventTitle()));   
                                                    
        }  
        catch (Exception e)  
        {  
            throw new UnsupportedOperationException();  
        }  
    }
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}

	
	
	}