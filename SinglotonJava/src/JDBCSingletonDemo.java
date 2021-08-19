
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class JDBCSingletonDemo {
	static int count = 1;
	static int choice;

	public static void main(String[] args) throws IOException {

		JDBCSingleton jdbc = JDBCSingleton.getInstance();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println("DATABASE OPERATIONS");
			System.out.println(" --------------------- ");
			System.out.println(" 1. Insertion ");
			System.out.println(" 2. View      ");
			System.out.println(" 3. Delete    ");
			System.out.println(" 4. Update    ");
			System.out.println(" 5. Exit      ");

			System.out.print("\n");
			System.out.print("Please enter the choice what you want to perform in the database: ");

			choice = Integer.parseInt(br.readLine());
			switch (choice) {

			case 1: {
				System.out.print("Enter the Name you want to insert data into the database: ");
				String name = br.readLine();
				System.out.print("Enter the last Name you want to insert data into the database: ");
				String lname = br.readLine();
				System.out.print("Enter the Id you want to insert data into the database: ");
				String id = br.readLine();

				try {
					int i = jdbc.insert(name, lname, id);
					if (i > 0) {
						System.out.println((count++) + " Data has been inserted successfully");
					} else {
						System.out.println("Data has not been inserted ");
					}

				} catch (Exception e) {
					System.out.println(e);
				}

				System.out.println("Press Enter key to continue...");
				System.in.read();

			} // End of case 1
				break;
			case 2: {
				System.out.print("Enter the id : ");
				String id = br.readLine();

				try {
					jdbc.view(id);
				} catch (Exception e) {
					System.out.println(e);
				}
				System.out.println("Press Enter key to continue...");
				System.in.read();

			} // End of case 2
				break;
			case 3: {
				System.out.print("Enter the userid,  you want to delete: ");
				String id = br.readLine();

				try {
					int i = jdbc.delete(id);
					if (i > 0) {
						System.out.println((count++) + " Data has been deleted successfully");
					} else {
						System.out.println("Data has not been deleted");
					}

				} catch (Exception e) {
					System.out.println(e);
				}
				System.out.println("Press Enter key to continue...");
				System.in.read();

			} // End of case 3
				break;
			case 4: {
				System.out.print("Enter the Name,  you want to update: ");
				String fname = br.readLine();
				System.out.print("Enter the last name ");
				String lname = br.readLine();
				System.out.print("Enter the last name ");
				String id = br.readLine();

				try {
					int i = jdbc.update(fname, lname, id);
					if (i > 0) {
						System.out.println((count++) + " Data has been updated successfully");
					}

				} catch (Exception e) {
					System.out.println(e);
				}
				System.out.println("Press Enter key to continue...");
				System.in.read();

			} // end of case 4
				break;

			default:
				return;
			}

		} while (choice != 4);
	}
}