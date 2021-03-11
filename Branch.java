/**
*@author Canberk Arici
*
*/

public class Branch extends Company{

	/**
	 * This integer value is the Id of the branch.
	 */
	private int branchId;

	/**
	 * This string is the name of the branch.
	 */
	private String branchName;

	/**
	 * Branch two-parameter Constructor
	 * @param name string of the branch's name.
	 * @param brId integer value of the branch's ID.
	 */
	public Branch(int brId, String name){
		super();
		this.branchId = brId;
		this.branchName = name;
	}

	/**
	 * This method sets the Id of branch.
	 * @param Id int value of the Id of branch.
	 */
	public void setBranchId(int Id){
		this.branchId = Id;
	}

	/**
	 * This method gets the Id of branch.
	 * @return Id integer value of the Id of branch.
	 */
	public int getBranchId(){
		return branchId;
	}

	/**
	 * This method sets the branch's name.
	 * @param name string of the branch's name.
	 */
	public void setBranchName(String name){
		this.branchName = name;
	}

	/**
	 * This method gets the branch name.
	 * @return string of the branch name.
	 */
	public String getBranchName(){
		return branchName;
	}

	/**
	 *This method returns string representation of Branch object.
	 *@return string of representation of Branch object
	 */
	@Override
	public String toString(){
		String str = "";
		if(employeeList.length > 0){
			str += "\n Information of Branch Employees in Branch: " + branchId + "\n";
			str += "Name          Surname          EmployeeID\n";
			for(BranchEmployee emp: employeeList){
				str += emp.getName();
				for(int i=0; i<10; ++i)
					str += " ";
				
				str += emp.getSurname();
				for(int i=0; i<10; ++i)
					str += " ";
				
				str += emp.getId();
				for(int i=0; i<10; ++i)
					str += " ";
				str += "\n";
			}
		}
		return str;
	}

}