package extra;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;

public class Pharmacy {
    LinkedList<Medicine> medicines;
    Scanner sc = new Scanner(System.in);

    Pharmacy() {
        this.medicines = new LinkedList<>();
    }

    synchronized void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }

    synchronized void removeMedicine(String name) {
        Medicine medicineToRemove = null;
        for (Medicine medicine : medicines) {
            if (medicine.getName().equalsIgnoreCase(name)) {
                medicineToRemove = medicine;
                break;
            }
        }

        if (medicineToRemove != null) {
            medicines.remove(medicineToRemove);
            System.out.println("Medicine removed successfully!");
        } else {
            System.out.println("Medicine not found!");
        }
    }

    synchronized void updateMedicine(String name) {
        Medicine medicineToUpdate = null;
        for (Medicine medicine : medicines) {
            if (medicine.getName().equalsIgnoreCase(name)) {
                medicineToUpdate = medicine;
                break;
            }
        }

        if (medicineToUpdate != null) {
            System.out.print("Enter new price: ");
            double newPrice = sc.nextDouble();
            System.out.print("Enter new quantity: ");
            int newQty = sc.nextInt();
            sc.nextLine();

            medicineToUpdate.price = newPrice;
            medicineToUpdate.quantity = newQty;
            System.out.println("Medicine updated successfully.");
        } else {
            System.out.println("Medicine not found");
        }

    }

    void displayMedicine() {

        Iterator itr1 = medicines.iterator();
        while (itr1.hasNext()) {
            System.out.println(itr1.next());
        }
    }

    synchronized void sellMedicine(String name, int quantityToSell) {
        Medicine medicineToSell = null;
        for (Medicine medicine : medicines) {
            if (medicine.getName().equalsIgnoreCase(name)) {
                medicineToSell = medicine;
                break;
            }
        }

        if (medicineToSell != null) {
            if (medicineToSell.getQuantity() >= quantityToSell) {
                medicineToSell.quantity -= quantityToSell;
                System.out.println("Medicine sold successfully.");
            } else {
                System.out.println("Insufficient quantity. Available: " + medicineToSell.getQuantity());
            }
        } else {
            System.out.println("Medicine to sell not found.");
        }

    }
}

class Medicine {
    String name;
    double price;
    int quantity;

    Medicine(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }

    int getQuantity() {
        return quantity;
    }
}

class PMSystem extends Thread {
    static Pharmacy pharmacy = new Pharmacy();
    String medicineName;
    int quantity;

    PMSystem(String medicineName, int quantity) {
        this.medicineName = medicineName;
        this.quantity = quantity;
    }

    PMSystem() {
        runSystem();
    }

    public void run() {
        pharmacy.sellMedicine(medicineName, quantity);
    }

    void runSystem() {
        pharmacy.addMedicine(new Medicine("Paracetamol", 50.0, 20));
        pharmacy.addMedicine(new Medicine("Ibuprofen", 80.0, 15));
        pharmacy.addMedicine(new Medicine("Saridone", 120.0, 100));
        pharmacy.addMedicine(new Medicine("Dolo", 150.0, 30));
        pharmacy.addMedicine(new Medicine("Disprine", 200.0, 10));

        Scanner scanner = new Scanner(System.in);
        ArrayList<Thread> customerThreads = new ArrayList<>();

        while (true) {
            System.out.println("\n===== Pharmacy Management System =====");
            System.out.println("1. Display Medicines");
            System.out.println("2. Sell Medicine");
            System.out.println("3. Add Medicine");
            System.out.println("4. Remove Medicine by Name");
            System.out.println("5. Update Medicine");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    pharmacy.displayMedicine();
                    break;

                case 2:
                    System.out.print("Enter medicine name to sell: ");
                    String sellName = scanner.nextLine();
                    System.out.print("Enter quantity to sell: ");
                    int sellQty = scanner.nextInt();
                    scanner.nextLine();

                    PMSystem customer = new PMSystem(sellName, sellQty);
                    Thread t = new Thread(customer);
                    customerThreads.add(t);
                    t.start();
                    break;

                case 3:
                    System.out.print("Enter medicine name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter quantity: ");
                    int qty = scanner.nextInt();
                    scanner.nextLine();

                    pharmacy.addMedicine(new Medicine(name, price, qty));
                    System.out.println("Medicine added successfully.");
                    break;

                case 4:
                    System.out.print("Enter medicine name to remove: ");
                    String removeName = scanner.nextLine();
                    pharmacy.removeMedicine(removeName);
                    break;

                case 5:
                    System.out.print("Enter medicine name to update: ");
                    String updateName = scanner.nextLine();
                    pharmacy.updateMedicine(updateName);
                    break;

                case 6:
                    System.out.println("Exiting the system...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}