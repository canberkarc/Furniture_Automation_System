/**
*@author Canberk Arici
*
*/

public class BranchEmployee extends Branch implements Person {
	 /**
	 * Name of the branch employee.
	 */
	private String name;
	
	 /**
	 * Surname of the branch employee.
	 */
	private String surname;
	
	
	 /**
	 * That integer value is the Id of the branch employee.
	 */
	private int Id;

	/**
	 * That integer value is the Id of the branch employee's branch.
	 */
	private int branchId;

	
	 /** BranchEmployee parameter Constructor
	 * @param branchName string of the name of the branch.
	 * @param branchID integer value of the Id of the branch.
	 * @param name string of the branch employee's name.
	 * @param surname string of the branch employee's surname.
	 * @param Id int value of the branch employee's Id.
	 */
	public BranchEmployee(String branchName, int branchId, String name, String surname, int Id) {
		super(branchId, branchName);
		this.name = name;
		this.surname = surname;
		this.Id = Id;
		this.branchId = branchId;
	}

	/**
	 * That method gets the branch employee's name.
	 * @return name string of the branch employee's name.
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * That method sets the branch employee's name.
	 * @param name string of the branch employee's name.
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * That method gets the branch employee's surname.
	 * @return surname string of the branch employee's surname.
	 */
	@Override
	public String getSurname() {
		return surname;
	}

	/**
	 * That method sets the branch employee's surname.
	 * @param surname string of the branch employee's surname.
	 */
	@Override
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
	 * That method gets the branch employee's Id.
	 * @return Id integer value of the branch employee's Id.
	 */
	public int getId() {
		return Id;
	}

	/**
	 * That method sets the branch employee's Id.
	 * @param Id integer value of the branch employee's Id.
	 */
	public void setId(int Id) {
		this.Id = Id;
	}

	/**
	 * That method gets the branch employee's Id.
	 * @return Id integer value of the branch employee's Id.
	 */
	public int getBranchId() {
		return branchId;
	}

	/**
	 * That method sets the branch Id of branch employee.
	 * @param Id integer value of the branch Id of branch employee.
	 */
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	/**
	 * That method adds branch employee from a branch's employee list
	 * @param c Customer object of customer that will buy furniture
	 * @param f Furniture object furniture to be sold. 
	 */
	public void makeSale(Customer c, Furniture f){
		boolean check = c.buy(f);
		if(check == true)
			System.out.println("Sale is done.\n");
		else
			System.out.println("Sale is not successful.\n");
	}

	/**
	*	That method prints product list.
	*/
	public void seeProductList(){
		int count = 0;
		for(int i=0; i<numberOfFurnitures; i++){
			if(furnitureList[i].getNumberInStock() > 0){
				System.out.println("Product: " + furnitureList[i].getProduct());
				System.out.println("Model: " + furnitureList[i].getModel());
				System.out.println("Color: " + furnitureList[i].getColor());
				System.out.println("Number in stock: " + furnitureList[i].getNumberInStock());
				System.out.println("Branch: " + furnitureList[i].getWhichBranch());
				System.out.println("\n");
			}
			else{
				System.out.println("***SOLD OUT***");
				System.out.println("Product: " + furnitureList[i].getProduct());
				System.out.println("Model: " + furnitureList[i].getModel());
				System.out.println("Color: " + furnitureList[i].getColor());
				System.out.println("Number in stock: " + furnitureList[i].getNumberInStock());
				System.out.println("Branch: " + furnitureList[i].getWhichBranch());
				System.out.println("\n");
				count += 1;
			}
		}
		if(count == numberOfFurnitures)
			System.out.println("Sorry, all stock is empty now");
	}

	/**
	 * That method adds furniture as many as given number
	 * @param f Furniture object furniture to be added to stock
	 * @param numberToAdd integer value that is number of furniture to be added 
	 */
	public void addProduct(Furniture f, int numberToAdd){
		if(numberToAdd == 0){
			System.out.println("Number of product to be added must be greater than 1.\n");
		}
		else if(numberToAdd > 0 && numberOfFurnitures > 0){
			int check = -1;
			for(int i=0; i<numberOfFurnitures; i++){
				if(furnitureList[i].getProduct() == f.getProduct() && furnitureList[i].getModel() == f.getModel()){
					check = i;
					break;
				}
			}
			if(check != -1){
				furnitureList[check].setNumberInStock(furnitureList[check].getNumberInStock() + numberToAdd);
			}
			else
				System.out.println("There is no product that you want to add in stock.\n");
		}
		else
			System.out.println("There is no product that you want to add in stock.\n");
	}

	/**
	 * That method removes furniture as many as given number
	 * @param f Furniture object furniture to be removed from stock
	 * @param numbertoDelete integer value that is number of furniture to be removed 
	 */
	public void removeProduct(Furniture f, int numbertoDelete){
		if(numberOfFurnitures == 0)
			System.out.println("Stock is empty.\n");
		else{
			if(numbertoDelete <= f.getNumberInStock()){
				f.setNumberInStock(f.getNumberInStock() - numbertoDelete);
				System.out.println(f.getProduct() + " with model " + f.getModel() + " is removed by " + numbertoDelete + "\n");
			}
			else{
				System.out.println("There is no enough number of this product in stock.\n");
			}
		}
	}

	/**
	* That method checks whether given customer is subscribed or not
	* @param c Customer object to be checked in customer list
	* @return boolean Boolean value about subscription
	*/
	public boolean isSubscribed(Customer c){
		int check = -1;
		if(numberOfCustomers > 0){
			if(numberOfCustomers == 1){	
				if(customerList[0].getCustomerNumber() == c.getCustomerNumber())
					check = 1;
			}
			else{
				for(int i=0; i<numberOfCustomers; i++){
					if(customerList[i].getCustomerNumber() == c.getCustomerNumber()){
						check = 1;
						break;
					}
				}
			}
		}
		if(check == -1)
			return false;
		else
			return true;
	}

	/**
	 * That method subscribes customer to the system
	 * @param c Customer object customer to be added to be subscribed to the system
	 */
	public void addCustomer(Customer c){
		int check = 0;
		if(numberOfCustomers == 0){
			customerList[numberOfCustomers] = c;
			customerList[numberOfCustomers].setCustomerNumber(numberOfCustomers+1);
			System.out.println(customerList[numberOfCustomers].getName() + " " + customerList[numberOfCustomers].getSurname() + " is subscribed.\n");
			numberOfCustomers += 1;
		}
		else{
			if(!isSubscribed(c)){
				customerList[numberOfCustomers] = c;
				customerList[numberOfCustomers].setCustomerNumber(numberOfCustomers+1);
				System.out.println(customerList[numberOfCustomers].getName() + " " + customerList[numberOfCustomers].getSurname() + " is subscribed.\n");
				numberOfCustomers += 1;
			}
		}
	}

	/**
	* That method shows previous orders of a customer by using customer number
	* @param customerNumber integer value that is number of customer.
	*/
	public void viewPreviousOrders(int customerNumber){
		if(numberOfCustomers == 0)
			System.out.println("There is no customer who subscribed to the system.\n");
		else{
			int index = -1;
			for(int i=0; i<numberOfCustomers; i++){
				if(customerList[i].getCustomerNumber() == customerNumber){	
					index = i;
					break;
				}
			}
			if(index != -1){
				customerList[index].viewPreviousOrders();
			}
			else{
				System.out.println("There is no customer with this customer number.\n");
			}
		}
	}
}