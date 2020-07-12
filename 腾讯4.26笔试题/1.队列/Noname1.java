class  
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
int reputationOfExperiencedEmployees(int employeesCount, int[] employeeIDs, int[] employeeReputations, int numberOfLinks, ArrayList<Integer> empHierarchy) {
    int score = 0;
    ArrayList<Integer> idList = new ArrayList<>();
    ArrayList<Integer> indexList = new ArrayList<>();
    for (int i = 0; i < numberOfLinks; i++) {
        if ((i % 2 == 1) && (empHierarchy.get(i) != -1)) {
            indexList.add(i);
        }
    }
    for (int i = 0; i < indexList.size(); i++) {
        int index = indexList.get(i);
        if (index<numberOfLinks/2) {
            if ((empHierarchy.get(index * 2 + 1) == -1) && (empHierarchy.get(index * 2 + 1) == -1)) {
                idList.add(empHierarchy.get(index));
            }
        }else{
            idList.add(empHierarchy.get(index));
        }
    }
    for (int item : idList) {
        score += employeeReputations[item - 1];
    }

    return score;
}
}
