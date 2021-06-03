
package banking.system;

import java.util.Scanner;

/**
 *
 * @author Abdallah mohamad abdellatif El_belkasy
 * ID 20190329
 * @author Mohamed Essam Said Hanafi
 * ID 20190462
 * @author Ahmed ragab eissa elsayed
 * ID 20190030
 * @version 3.1
 */
public class BankingSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        /*
          Create the bank system with name Bank and address Egypt and phone number 01111110000
         */
        Bank bank = new Bank("Bank", "Egypt", 1111110000);

        int AccountsNum = 11111;

        int select = 0;

        /*
          While the option number 4 is not selected do not exit this while loop
          print the main menu every time before reading a selection
         */

        while (select != 4) {

            System.out.println("""

                    1- Add New Client
                    2- List All Accounts / Clients
                    3- Withdraw / Deposit
                    4- Exit
                    """);

            select = input.nextInt();
            /*
              if select = 1 the Add new client
              if select = 2 list all accounts and clients
              if select = 3 withdraw or deposit from account
              if select = 4 exit and finish the program
              else continue
             */
            switch (select) {
                case 1 -> {
                    int s,select1=0;
                    Client client;
                    /*
                      Chose between Normal Client or Commercial Client
                     */
                    System.out.println("""

                            1- Normal Client
                            2- Commercial Client
                                                        
                            """);
                    s= input.nextInt();
                    if (s == 2) {
                        client = new CommercialClient();
                        client.setNationalid(0);
                    } else {
                        client = new Client();
                    }


                    while (select1 != 7) {
                        if (s == 2) {
                            System.out.println("""

                                    1- Set Client's Name
                                    2- Set Client's CommercialID
                                    3- Set Client's Address
                                    4- Set Client's Phone Number
                                    5- Add an Account to this Client
                                    6- Add a Special Account to this Client
                                    7- Bact To The Main MENU
                                                                    
                                    """);
                        }else{
                            System.out.println("""

                                    1- Set Client's Name
                                    2- Set Client's NationalId
                                    3- Set Client's Address
                                    4- Set Client's Phone Number
                                    5- Add an Account to this Client
                                    6- Add a Special Account to this Client
                                    7- Bact To The Main MENU
                                                                    
                                    """);
                        }

                        select1 = input.nextInt();
                        /*
                          select1 = 1 Set Client's Name
                          select1 = 2 Set Client's NationalId
                          select1 = 3 Set Client's Address
                          select1 = 4 Set Client's Address
                          select1 = 5 Set Client's Name
                          select1 = 6 Set Client's Name
                          select1 = 7 Set Client's Nam
                          else continue
                         */
                        switch (select1) {
                            case 1 -> {
                                String name;

                                System.out.print("Client's Name: ");
                                name = input.next();

                                client.setName(name);

                            }
                            case 2 -> {
                                if(s!=2) {
                                    int NationalId;

                                    System.out.print("Client's NationalId: ");

                                    NationalId = input.nextInt();

                                    client.setNationalid(NationalId);
                                }else{
                                    int CommercialID;

                                    System.out.print("Client's CommercialID: ");

                                    CommercialID = input.nextInt();

                                    client.setCommercialID(CommercialID);
                                }

                            }
                            case 3 -> {
                                String address;

                                System.out.print("Client's Address: ");

                                address = input.next();

                                client.setAddress(address);

                            }
                            case 4 -> {
                                int Phone;

                                System.out.print("Client's Phone Number: ");

                                Phone = input.nextInt();

                                client.setPhone(Phone);
                            }
                            case 5 -> {
                                Account account = new Account(0, AccountsNum--);

                                client.setAccount(account);

                                bank.addAccount(account);

                                System.out.print("The Account Number is " + account.getAccount_number() + "\n");

                            }
                            case 6 -> {
                                Account account = new SpecialAccount(0, AccountsNum--);

                                client.setSpecialAccount(account);

                                bank.addSpecialAccount(account);

                                System.out.print("The Account Number is " + account.getAccount_number() + "\n");

                            }
                        }
                    }

                    bank.addClient(client);
                }
                case 2 -> bank.display();
                case 3 -> {
                    boolean flag = true;
                    while (flag) {
                        System.out.println("Entre Account Number\n");
                        int AccNum;
                        AccNum = input.nextInt();

                        if (bank.existAccount(AccNum)) {
                            int select3 = 0;

                            while (select3 != 3) {

                                System.out.print("""

                                        1- Deposit
                                        2- Withdraw
                                        3- Bact To The Main MENU
                                                                                
                                        """);

                                select3 = input.nextInt();
                                /*
                                  select3 = 1 for Deposit
                                  select3 = 2 for Withdraw
                                  select3 = 3 for Bact To The Main MENU
                                 */
                                switch (select3) {
                                    case 1 -> {
                                        System.out.print("Set The Value You Want Deposit IT : ");
                                        int money;
                                        money = input.nextInt();
                                        bank.Depositfn(money, AccNum);
                                    }
                                    case 2 -> {
                                        System.out.print("Set The Value You Want Withdraw IT : ");
                                        int money;
                                        money = input.nextInt();
                                        if (bank.Withdrawfn(money, AccNum)) {
                                            System.out.print("done successfully\n");
                                        } else
                                            System.out.println("No Enough Money");
                                    }
                                    case 3 -> {
                                    }
                                }
                            }
                            flag = false;
                        } else
                            System.out.print("Wrong Number ---!\n");
                    }

                }
                case 4 -> {
                }
            }
        }

    }
}
