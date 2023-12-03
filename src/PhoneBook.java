

public class PhoneBook {
	private contactBST contactstree;
	private LinkedList<Event> eventslist;

	public PhoneBook() {
		this.contactstree = new contactBST();
		this.eventslist = new LinkedList<>();
		
	}
	
	
	public void addContact(Contact contact) {
		if(contactstree.empty()) {
		boolean Signal =contactstree.insert(contact.getContactName(), contact);
		if(Signal)
			System.out.println("Contact Added Successfully");
		}
		else {
			if(contactstree.findContact(contact.getPhoneNumber(), "PhoneNumber")!=null) {
				System.out.println("The phoneNumber of contact already exists!");
				return;
			}
			if(contactstree.findContact(contact.getContactName(),"Name")==null) {
				contactstree.insert(contact.getContactName(), contact);
				System.out.println("Contact Added Successfully");
			}
			else {
				System.out.println("The name of contact exists!");
			}
			
		}}

	public void deleteContact(String name) {
		if(contactstree.empty())
			System.out.println("The List is Empty");
		else {
			boolean tmp = contactstree.findKey(name);
			if(tmp==false) {
				System.out.println("The contact not founded");
				return;
			}
			if(!eventslist.empty()) {
				boolean RedSignal = true;
				eventslist.findfirst();
				while(!eventslist.last()) {
					RedSignal = true;
			        Event event = eventslist.retrieve();
			        if (event.getType().equalsIgnoreCase("Event")) {
			            if (event.findContactInEvent(name)) {
			                event.removeContactInEvent(name);
			            }
			            if (event.isEmptyContact()) {
			            	RedSignal=false;
			                eventslist.remove();
			            }
			        } else if (event.getType().equalsIgnoreCase("Appointment")) {
			            if (event.getContact().getContactName().equalsIgnoreCase(name)) {
			            	RedSignal=false;
			                event.setContact(null);
			                eventslist.remove();
			            }
			        }
			        if(RedSignal==true) {
					eventslist.findnext();}
				}
				if(eventslist.last()) {
					Event event = eventslist.retrieve();

			        if (event.getType().equalsIgnoreCase("Event")) {
			            if (event.findContactInEvent(name)) {
			                event.removeContactInEvent(name);
			            }

			            if (event.isEmptyContact()) {
			                eventslist.remove();
			            }
			        } else if (event.getType().equalsIgnoreCase("Appointment")) {
			            if (event.getContact().getContactName().equalsIgnoreCase(name)) {
			                event.setContact(null);
			                eventslist.remove();
			            }
			        }
				}
			}
			
			contactstree.removeKey(name);
			System.out.println("The Contact Has been Deleted");
		}
		
	}


	public void searchContact(String data, String type) {
		contactstree.searchContact(data, type);
	}


	public void scheduleEvent(Event event, String k) {
		String DateAndTime = event.getDateAndTime()+"";
        if (event.getType().equalsIgnoreCase("appointment")) {
            Contact tmp = contactstree.findContact(k, "Name"); 
            
            if (tmp == null) {
                System.out.println("Contact does not exist!");
                return;
            }
	        event.setContact(tmp);
	        
	        if(tmp.conflictDate(DateAndTime) == false) {
	            tmp.addtoCaliender(DateAndTime);
	            eventslist.insert(event);
	            System.out.println("The Appointment has schduled");
	        }
	        else {
	        	System.out.println("There is cnflict for user");
	        }
	    } else if(event.getType().equalsIgnoreCase("Event")){

	        String[] contactNames = k.split(",");
	        for (int i = 0; i < contactNames.length; i++) {  
	            String trimmedName = contactNames[i].trim();
	            Contact tmp1 = contactstree.findContact(trimmedName, "Name");
	            if(tmp1==null) {
	            	System.out.println(trimmedName+" contact is not in the System please try again");
	            	return;
	            }
	            if(tmp1.conflictDate(DateAndTime)) {
	            	System.out.println("There is conflict with contact " +tmp1.getContactName());
	            	return;
	            }
	            if ( event.findContactInEvent(trimmedName)==false 
	            		&& tmp1.conflictDate(DateAndTime) == false){
	                event.addContacttoEvent(tmp1);
	                tmp1.addtoCaliender(DateAndTime);
	            }

	           
	        }
	        if(event.isEmptyContact()) {
	        	System.out.println("The contact's is not exists");
	        	return;
	        }
	        eventslist.insert(event);
	        System.out.println("The event has schduled");
	    }
	}


	public void searchByFirstName(String b) {
		contactstree.searchByFirstName(b);
		}
	 public void PrintEvent() {
			if(!eventslist.empty()){
			eventslist.findfirst();
			while (!eventslist.last()) {
				System.out.println(eventslist.retrieve().getEventTitle());
				eventslist.findnext();
			}
			if (eventslist.last()) {
				System.out.println(eventslist.retrieve().getEventTitle());
				return;
			}
		}
			System.out.println("The List is empty");}
	 
		public void SearchEvent(String data, String Type) {
			if (eventslist.empty()) {
				System.out.println("The event list is empty! ");
				return;
			}
			boolean Signal = true;
			eventslist.findfirst();
			do{
				Event tmp = eventslist.retrieve();
				if (tmp.getEventTitle().equalsIgnoreCase(data) && Type.equalsIgnoreCase("Title")) {
					if(eventslist.retrieve().getType().equalsIgnoreCase("Event")) {
					tmp.printEventDet();}
					else if(eventslist.retrieve().getType().equalsIgnoreCase("appointment")){
					tmp.printApointmentDetails();
					}
					
	
				}else 
						if(contactstree.findKey(data)&&Type.equalsIgnoreCase("Name")) {
					if(eventslist.retrieve().getType().equalsIgnoreCase("Event")&&eventslist.retrieve().
							findContactInEvent(data)) {
					tmp.printEventDet();}
					else if(eventslist.retrieve().getType().equalsIgnoreCase
							("appointment")&&eventslist.retrieve().getContact().
							getContactName().equalsIgnoreCase(data)){
					tmp.printApointmentDetails();
					}
				}
				
				if(eventslist.last()) {
					Signal = false;
					return;}
					eventslist.findnext();
					}while(Signal);
					System.out.println("Event not founded! ");}



	}

