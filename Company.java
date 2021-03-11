/**
*@author Canberk Arici
*
*/ 

public class Company{

	/**
	* This static array in type Branch is the branches' list
	*/
	protected static Branch [] branchList = new Branch[50];
	/**
	* This static integer value is the number of branches
	*/
	protected static int numberOfBranches = 0;
	/**
	* This static array in type BranchEmployee is the employees' list
	*/
	protected static BranchEmployee [] employeeList = new BranchEmployee [50];
	/**
	* This static integer value is the number of employees
	*/
	protected static int numberOfEmployees = 0;
	/**
	* This static array in type Furniture is the furnitures' list
	*/
	protected static Furniture [] furnitureList = new Furniture [100];
	/**
	* This static integer value is the number of furnitures
	*/
	protected static int numberOfFurnitures = 0;
	/**
	* This static array in type Furniture is the customers' list
	*/
	protected static Customer [] customerList = new Customer[50];
	/**
	* This static integer value is the number of customers
	*/
	protected static int numberOfCustomers = 0;
	/**
	* This Administrator type value is administrator
	*/
	private Administrator admin;

	/** No parameter constructor
	*
	*/
	public Company(){}

	/**
	 * This method gives number of branches.
	 * @return integer.
	 */
	public int getNumberOfBranches(){
		return numberOfBranches;
	}

	/**
	 * This method gives number of furnitures.
	 * @return integer.
	 */
	public int getNumberOfFurnitures(){
		return numberOfFurnitures;
	}

	/**
	 * This method gives number of employees.
	 * @return integer.
	 */
	public int getNumberOfEmployees(){
		return numberOfEmployees;
	}

	/**
	 * This method gives number of customers.
	 * @return integer.
	 */
	public int getNumberOfCustomers(){
		return numberOfCustomers;
	}

	/**
	 * This method gives array of Branch objects.
	 * @return Branch type array.
	 */
	public Branch [] getBranchList(){
		return branchList;
	}

	/**
	 * This method gives array of BranchEmployee objects.
	 * @return BranchEmployee type array.
	 */
	public BranchEmployee [] getEmployeeList(){
		return employeeList;
	}

	/**
	 * This method gives array of Furniture objects.
	 * @return Furniture type array.
	 */
	public Furniture [] getFurnitureList(){
		return furnitureList;
	}

	/**
	 * This method gives array of Customer objects.
	 * @return Customer type array.
	 */
	public Customer [] getCustomerList(){
		return customerList;
	}

	/**
	 * That method sets the admin.
	 * @param admin the Administrator object.
	 */
	public void setAdmin(Administrator admin){
		this.admin = admin;
	}

	/**
	 * That method sets the admin.
	 * @param admin the Administrator object.
	 */
	public Administrator getAdmin(){
		return admin;
	}

	/**
	 * That method prints the branch array.
	 */
	public void showBranches(){
		String str = "";
		if(numberOfBranches > 0){	
			str += "Branches of Company: \n\n";
			for(int i=0; i<numberOfBranches; i++){
				str = str + "Branch Name: " + branchList[i].getBranchName();
				str += "\n";
				str = str + "Branch Id: " + branchList[i].getBranchId();
				str += "\n";
			str += "\n\n";
			}
		}
		System.out.println(str);
	}

	/**
	 * That method prints the customer array.
	 */
	public boolean showCustomers(){
		String str = "";
		if(numberOfCustomers > 0){	
			str += "Customers of Company: \n\n";
			for(int i=0; i<numberOfCustomers; i++){
				str = str + "Name: " + customerList[i].getName();
				str += "\n";
				str = str + "Surname: " + customerList[i].getSurname();
				str += "\n";
				str = str + "Customer Number: " + customerList[i].getCustomerNumber();
				str += "\n";
			str += "\n\n";
			}
		}
		else{
			str += "There is no customer yet.";
			return false;
		}
		System.out.println(str);
		return true;
	}

	/**
	 * That method prints the employee array.
	 */
	public void showEmployees(){
		String str = "";
		if(numberOfEmployees > 0){	
			str += "Employees of Company: \n\n";
			for(int i=0; i<numberOfEmployees; i++){
				str = str + "Name: " + employeeList[i].getName();;
				str += "\n";
				str = str + "Surname: " + employeeList[i].getSurname();
				str += "\n";
				str += "Employee Id: " + employeeList[i].getId();
				str += "\n";
				str = str + "Branch Id: " + employeeList[i].getBranchId();
				str += "\n";
				str += "Branch Name: ";
				str += branchList[i].getBranchName();
			str += "\n\n";
			}
		}
		System.out.println(str);
	}

	/**
	 * That method prints the furniture array.
	 */
	public void seeProductList(){
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
				System.out.println("All stock is empty now.\n");
			}
		}
	}

	/**
	 *This method returns string representation of Company object.
	 *@return string of representation of Company object
	 */
	@Override
	public String toString(){
		String str = "";
		if(numberOfBranches > 0){	
			str += "Branches of Company: \n\n";
			for(int i=0; i<numberOfBranches; i++){
				str = str + "Branch Name: " + branchList[i].getBranchName();
				str += "\n";
				str = str + "Branch Id: " + branchList[i].getBranchId();
				str += "\n";
			str += "\n\n";
			}
		}
		if(numberOfEmployees > 0){	
			str += "Employees of Company: \n\n";
			for(int i=0; i<numberOfEmployees; i++){
				str = str + "Name: " + employeeList[i].getName();;
				str += "\n";
				str = str + "Surname: " + employeeList[i].getSurname();
				str += "\n";
				str += "Employee Id: " + employeeList[i].getId();
				str += "\n";
				str = str + "Branch Id: " + employeeList[i].getBranchId();
				str += "\n";
				str += "Branch Name: ";
				str += branchList[i].getBranchName();
			str += "\n\n";
			}
		}
		if(numberOfCustomers > 0){	
			str += "Customers of Company: \n\n";
			for(int i=0; i<numberOfCustomers; i++){
				str = str + "Name: " + customerList[i].getName();
				str += "\n";
				str = str + "Surname: " + customerList[i].getSurname();
				str += "\n";
				str = str + "Customer Number: " + customerList[i].getCustomerNumber();
				str += "\n";
			str += "\n\n";
			}
		}
		return str;
	}


}