/**
*@author Canberk Arici
*
*/

public class Customer extends Company implements Person{

	private String name;

	private String surname;

	private String address;

	private String phoneNumber;

	private String email;

	private String password;

	private int customer_number;

	private Furniture [] previousOrders = new Furniture [20];

	private int previousOrdersIndex = 0;

	public Customer(String name, String surname, String email, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.address = "None";
		this.phoneNumber = "None";
		this.customer_number = 0;
	}

	public Customer(String name, String surname, String email, String password, String address, String phoneNumber) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.customer_number = 0;
	}

	public Furniture [] getPreviousOrders(){
		return previousOrders;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;	
	}

	@Override
	public String getSurname() {
		return surname;
	}

	@Override
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCustomerNumber() {
		return customer_number;
	}

	public void setCustomerNumber(int customer_number) {
		this.customer_number = customer_number;
	}
	
	public int getPreviousOrderIndex() {
		return previousOrdersIndex;
	}

	public void seeProductList(){
		for(int i=0; i<numberOfFurnitures; i++){
			if(furnitureList[i].getNumberInStock() > 0){
				System.out.println("Product: " + furnitureList[i].getProduct() + ".\n");
				System.out.println("Model: " + furnitureList[i].getModel() + ".\n");
				System.out.println("Color: " + furnitureList[i].getColor() + ".\n");
				System.out.println("Number: " + furnitureList[i].getNumberInStock() + ".\n");
				System.out.println("\n");
			}
			else{
				System.out.println("All stock is empty now.\n");
			}
		}
	}

	public boolean searchAproduct(Furniture fur){
		boolean check = false;
		for(int i=0; i<numberOfFurnitures; i++){
			if(furnitureList[i].getNumberInStock() > 0 && fur.getProduct() == furnitureList[i].getProduct() && fur.getModel() == furnitureList[i].getModel()){
				System.out.println("There is this type of office furniture in the stock.\n");
				return true;
			}
		}

		System.out.println("Sorry, we couldn't find product you wanted.\n");
		return false;
	}

	public void setPreviousOrders(Furniture f){
		if(this.previousOrdersIndex != this.previousOrders.length){
			this.previousOrders[this.previousOrdersIndex] = f;
			this.previousOrdersIndex += 1;
		}
		else{
			if(this.previousOrdersIndex == this.previousOrders.length){
				this.previousOrdersIndex -= 1;
			}
			
			for(int i=0; i<this.previousOrders.length-1; ++i){
				this.previousOrders[i] = this.previousOrders[i+1];
			}
			this.previousOrders[this.previousOrdersIndex] = f;
		}
	}

	public void viewPreviousOrders(){
		if(this.previousOrdersIndex >0){
			System.out.println("Previous Orders: \n\n");
			for(int i=0; i<this.previousOrdersIndex; i++){
				System.out.println("Product: " + this.previousOrders[i].getProduct() + ".\n");
				System.out.println("Model: " + this.previousOrders[i].getModel() + ".\n");
				System.out.println("Color: " + this.previousOrders[i].getColor() + ".\n");
				System.out.println("\n");
			}
		}
		else
			System.out.println("There is no previous order. \n");
	}

	public boolean buy(Furniture fur){
		int check = 0;
		if(numberOfFurnitures > 0){	
			for(int i=0; i<numberOfFurnitures; i++){
				if(furnitureList[i].getProduct().equals(fur.getProduct()) && furnitureList[i].getModel().equals(fur.getModel())) {
					check = 1;
					break;				
				}
			}
		}
		if(check == 1){
			this.setPreviousOrders(fur);
			return true;
		}
		else{
			System.out.println("Sorry, we couldn't find product you wanted.\n");
			return false;
		}
	}

	@Override
	public String toString(){
		String str = "";
		if(numberOfCustomers > 0){	
			str += "Customer Information: \n\n";
			str += "Name: ";
			str += this.getName();
			str += "\n";
			str += "Surname: ";
			str += this.getSurname();
			str += "\n";
			str += "Email: ";
			str += this.getEmail();
			str += "\n";
			str += "Customer Number: ";
			str += this.getCustomerNumber();
			str += "\n";
		}
		return str;
	}
}