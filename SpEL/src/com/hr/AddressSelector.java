package com.hr;

public class AddressSelector {
	public Address getAddress(int choice){
		if(choice == 1)
			return new Address("Pune", "MH", "411029");
		else if (choice == 2)
			return new Address("Chennai", "TN", "411076");
		else
			return null;
		
	}
}
