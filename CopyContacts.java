import java.util.HashMap;
import java.util.Map;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class CopyContacts {

    public static void main(String[] args) {//

        HashMap<String, String> Contact = new HashMap<String, String>();

//        PhoneBook ph = new PhoneBook();

        Scanner scan = new Scanner(System.in);

        String fName, lName, contactName, areaCode, Number, contactNumber;
        int input;
        boolean check = false;


        do {
            System.out.println("\n\n\n\n\n\n-------------------------------------------------------------------------------");
            System.out.println("Phone Book\n");
            System.out.println("-------------------------------------------------------------------------------");

            System.out.println("Description :\n");
            System.out.println("Enter 1 for create a contact");
            System.out.println("Enter 2 for list and find a contact");
            System.out.println("Enter 3 for update a contact");
            System.out.println("Enter 4 for delete a contact");
            System.out.println("Enter 5 to exit");
            System.out.println("-------------------------------------------------------------------------------\n\n\n");


            try {
                input = scan.nextInt();

                switch (input) {
                    case 1:
                        System.out.print("Enter the area code : ");
                        areaCode = scan.next();


                        System.out.print("Enter the number : ");
                        Number = scan.next();

                        contactNumber = areaCode.concat(" " + Number);

                        if (Contact.containsKey(contactNumber)) {
                            System.out.println(contactNumber + " is already in contacts \n You can Update by entering '3'.");
                            continue;
                        } else {
                            System.out.print("Enter first name of the person : ");
                            fName = scan.next();

                            System.out.print("Enter last name of the person : ");
                            lName = scan.next();

                            contactName = fName.concat(" " + lName);
                            Contact.put(contactNumber, contactName);
                        }


                        System.out.println("-------------------------------------------------------------------------------");
                        System.out.println("Contact created successfully \n Name : " + contactName + "\t\t\tNumber :" + contactNumber + "\n");
                        break;

                    case 2:
                        System.out.println("-------------------------------------------------------------------------------");
                        System.out.println("Contacts Stored : \n Name\t\t\t\t Phone Number");
                        System.out.println("-------------------------------------------------------------------------------");

                        check = false;


                        for (Map.Entry<String, String> entries : Contact.entrySet())
                            System.out.println(entries.getValue() + "\t\t\t" + entries.getKey() + "\n");

                        System.out.println("Find contact by name");

                            System.out.print("Enter the First name need to be searched : ");

                            fName = scan.next();

                            System.out.print("Enter the Last name need to be searched : ");

                            lName = scan.next();

                            contactName = fName.concat(" " + lName);

                            for (Map.Entry<String, String> entries : Contact.entrySet())
                                if (entries.getValue().equals(contactName)) {
                                    check = true;
                                    System.out.println("The Contact number of " + contactName + " is " + entries.getKey());
                                    System.out.println("-------------------------------------------------------------------------------");
                                    break;
                                }

                            if(check == false)
                                System.out.println("No records found");


                        break;

                    case 3:

                        System.out.println("Update Phone number by using name(1) or Update Name ");

                        int i = scan.nextInt();

                        check = false;

                        if (i == 1) {



                            System.out.print("Enter the First name need to be search for updating : ");

                            fName = scan.next();

                            System.out.print("Enter the Last name need to be search for updating : ");

                            lName = scan.next();

                            contactName = fName.concat(" " + lName);

                            for (Map.Entry<String, String> entries : Contact.entrySet()) {

                                if (entries.getValue().equals(contactName)) {
                                    check = true;
                                    String ExistingPHNo = entries.getKey();
                                    Contact.remove(ExistingPHNo);
                                    System.out.print("Enter the area code :");
                                    areaCode = scan.next();
                                    System.out.print("Enter the Number :");
                                    Number = scan.next();

                                    contactNumber = areaCode.concat(" "+Number);

                                    Contact.put(contactNumber, contactName);
                                    System.out.println("Contact Successfully updated");
                                    break;
                                }

                            }

                            if(check == false){
                                System.out.println("No records found");
                            }
                            for (Map.Entry<String, String> entries : Contact.entrySet())
                                System.out.println(entries.getKey() + "\t\t\t" + entries.getValue() + "\n");



                        }

//
                        else {

                            System.out.println("Enter the First name of update contact");
                            fName = scan.next();

                            System.out.println("Enter the Last name of update contact");
                            lName = scan.next();

                            contactName = fName.concat(" " + lName);

                            check = false;

                            for (Map.Entry<String, String> entries : Contact.entrySet()) {
                                if (entries.getValue().equals(contactName)) {
                                    check = true;
                                    String ExistingName = entries.getValue();
                                    Contact.remove(ExistingName);
                                    System.out.print("Enter the First name :");
                                    fName = scan.next();
                                    System.out.print("Enter the Last name :");
                                    lName = scan.next();

                                    contactName = fName.concat(" " + lName);

                                    String GetContact = entries.getKey();

                                    Contact.put(GetContact, contactName);
                                    System.out.println("Contact Successfully updated");

                                }

                            }

                            if(check==false)
                                System.out.println("No contacts found ");


                        }
                        break;

                            case 4:

                                System.out.println("Delete contact by using name");

                                check = false;


                                    System.out.print("Enter the First name :");
                                    fName = scan.next();

                                    System.out.print("Enter the Last name :");
                                    lName = scan.next();

                                    String dContactName = fName.concat(" " + lName);

                                        for (Map.Entry<String, String> entries : Contact.entrySet())
                                            if (entries.getValue().equals(dContactName)) {
                                                check = true;
                                                System.out.println("Are you sure you want to delete, Enter<Yes or No Y|N>");

                                                char ch = scan.next().charAt(0);
                                                if(ch == 'Y') {

                                                    String dContactNumber = entries.getKey();
                                                    Contact.remove(dContactNumber);
                                                    System.out.println("Contact Successfully deleted");
                                                }
                                            }


                                if(check==false)
                                    System.out.println("No contacts found ");

                                    else{
                                            continue;
                                        }





                                break;


                            case 5:
                                System.out.println("Are you sure you want to exit, Enter<Y | N>");
                                char x = scan.next().charAt(0);
                                if ( x == 'Y')
                                    exit(0);
                                else
                                    continue;


                        }


                }
            catch(InputMismatchException e){
                    System.out.println("You've Entered a wrong data.");
                }



        } while (true);
    }

}



