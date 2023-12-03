
public class contactBST extends BST<Contact>{
	 
	public contactBST() {
		super();
		
	}


	
 
	public Contact findContact(String data, String Type) {
		//helper method
		if(empty())
			return null;
		Contact Ctmp = null;
    	BSTNode<Contact> tmp = root ;
    	if(Type.equalsIgnoreCase("Name")) {
    	Ctmp = findContactInTraversalByName(data);	
    	}
    	else {
    	Ctmp = findContactInTraversal(data, Type, tmp);}
    	if(Ctmp==null) {
    		return null;
    	}
    	return Ctmp;
    	}
	private Contact findContactInTraversalByName(String data) {
			//Time Complexity O(Log n)
			if(findKey(data))
				return current.data;
			else
				return null;
	    }
	
	private Contact findContactInTraversal(String data, String Type, BSTNode<Contact> p) {
		//Time Complexity O(n)
	    Contact result = null;

	    if (p != null) {
	        result = findContactInTraversal(data, Type, p.left);
	        if (result == null && p.data.getType(Type).equalsIgnoreCase(data)) {
	            result = p.data;
	        }
	        if (result == null) {
	            result = findContactInTraversal(data, Type, p.right);
	        }
	    }

	    return result;
	}

	public void searchByFirstName(String firstName) {
        boolean found = false;
        found = SearchByFirstNameInTraversal(root, firstName, found);
        if (!found)
            System.out.println("There is no contact with first name " + firstName + "\n");
    }

    
    private boolean SearchByFirstNameInTraversal(BSTNode<Contact> node, String firstName, boolean flag) {
        BSTNode<Contact> temp = node;
        String fname = "";
        int index;
        if (node == null)
            return flag;
        flag = SearchByFirstNameInTraversal(node.left, firstName, flag); 

        
        fname = temp.data.getContactName();

       
        if (temp.data.getContactName().contains(" ")) {
            index = temp.data.getContactName().indexOf(" "); 
            fname = temp.data.getContactName().substring(0, index); 
        }

        
        if (fname.equalsIgnoreCase(firstName)) {
            flag = true;
            
            System.out.println(temp.data.toString());
        }
        flag = SearchByFirstNameInTraversal(node.right, firstName, flag); 
        return flag; 
    }
	public void searchContact(String data, String type) {
		Contact tmp = findContact(data, type);   //Helper Method
		if(tmp!=null){
			System.out.println("---------------");
			if (type.equalsIgnoreCase("Email") || type.equalsIgnoreCase("birthday") || 
					type.equalsIgnoreCase("Address")) {
				saerchContactInTraversal(data,type,root);
				}
			else {
				System.out.println("Contact Found!");
				System.out.println(tmp.toString());
				System.out.println("---------------");
			}
			
			}else {
				System.out.println("The Contact Not Found");
			}
	}
	private void saerchContactInTraversal(String data, String Type,  BSTNode<Contact> p) {
    	//Time Complexity
		//in case of name it is O(Log n)
		//Otherwise it is O(n)
		if (p.left != null)
			saerchContactInTraversal(data, Type, p.left);
        if(p.data.getType(Type).equalsIgnoreCase(data)) {
        	  System.out.println("Contact Found!");
        	  System.out.println( p.data.toString());  
        	  System.out.println("-----------------");
        	}
        	
        if (p.right != null)
        	 saerchContactInTraversal(data, Type, p.right);
        	}
	
	 public void Printcontact() {
		 	//helper Method
			if(!empty()){
			
			PrintcontactInTravelsal(root);
		}else {
			System.out.println("The List is empty");}}
	 
	 private void PrintcontactInTravelsal(BSTNode<Contact> p) {
		 //O(n) because it will throw over all contacts
			if (p.left != null)
				PrintcontactInTravelsal(p.left);
	        	
	        System.out.println(p.data.getContactName());
	        	  
	        if (p.right != null)
	        	PrintcontactInTravelsal(p.right);
	 }



}
