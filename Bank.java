package banking.system;

/**
 * Banking system
 * @author Mohamed Essam Said Hanafi
 * ID 20190462
 */

public class Bank {
    /**
     * name of the bank
     */
    private String name_;

    /**
     * address of the bank
     */
    private String address_;

    /**
     * phone number of the bank
     */
    private int phone_;

    /**
     * the list of accounts in the bank
     */
    private Account[] accounts_;

    /**
     * the number of accounts in the bank
     */
    private int NumCurrAccounts_;

    /**
     * the maximum allowed numbers of accounts
     */
    private int MaxNumAccounts_;

    /**
     * the list of clients in the bank
     */
    private Client[] clients_;

    /**
     * number of clients in the bank
     */
    private int NumCurrClients_;

    /**
     * the maximum number of clients allowed in the bank
     */
    private int MaxNumClients_;

    /**
     * Bank's constructor
     *
     * @param name    Name of the bank
     * @param address Address of the bank
     * @param phone   the phone number of the bank
     */
    public Bank(String name, String address, int phone) {
        this.name_ = name;
        this.address_ = address;
        this.phone_ = phone;
        this.MaxNumAccounts_ = 1000;
        this.MaxNumClients_ = 1000;
        this.accounts_ = new Account[MaxNumAccounts_];
        this.clients_ = new Client[MaxNumClients_];
        this.NumCurrAccounts_ = 0;
        this.NumCurrClients_ = 0;
    }

    /**
     * Add a new account to the bank
     *
     * @param account the new account that will be added if there is enough space in the bank
     */
    public void addAccount(Account account) {

        if (NumCurrAccounts_ != MaxNumAccounts_) {
            this.accounts_[NumCurrAccounts_] = account;
            NumCurrAccounts_++;
        } else
            System.out.println("Can't add another account");
    }

    /**
     * Add a new special account to the bank
     *
     * @param account the new account that will be added if there is enough space in the bank
     */
    public void addSpecialAccount(Account account) {
        if (NumCurrAccounts_ != MaxNumAccounts_) {
            this.accounts_[NumCurrAccounts_] = account;
            NumCurrAccounts_++;
        } else
            System.out.println("Can't add another account");
    }

    /**
     * Add a new client into the bank
     *
     * @param client the new client that will be added if there is enough space in the bank
     */
    public void addClient(Client client) {
        if (NumCurrClients_ != MaxNumClients_) {
            this.clients_[NumCurrClients_++] = client;
        } else
            System.out.println("Can't add another client");
    }

    /**
     * find and account in the account available in the bank
     *
     * @param AccountNum the number of the account you want to find
     * @return ture if the account was found and false otherwise
     */
    public boolean existAccount(int AccountNum) {
        for (int i = 0; i < NumCurrAccounts_; i++) {
            if (this.accounts_[i].getAccount_number() == AccountNum)
                return true;
        }
        return false;
    }

    /**
     * Deposit money into an account with the account number
     *
     * @param Money      the money that is being deposited
     * @param AccountNum the account number to deposit into
     */
    public void Depositfn(int Money, int AccountNum) {
        if (NumCurrClients_ == 0)
            System.out.println("Not enough clients");
        else
            for (int i = 0; i < NumCurrAccounts_; i++) {
                if (this.clients_[i].getAccount().getAccount_number() == AccountNum) {
                    this.clients_[i].getAccount().deposit(Money);
                }
            }
    }

    /**
     * withdraws money from an account with the account number
     *
     * @param Money      the money you want to withdraw
     * @param AccountNum the number of the account you want to withdraw from
     * @return true of the account was found and withdrawn from and false if the account was not found or there was not enough money in the account
     */
    public boolean Withdrawfn(int Money, int AccountNum) {
        if (NumCurrClients_ == 0) {
            System.out.println("Not enough clients");
        } else
            for (int i = 0; i < NumCurrAccounts_; i++) {
                if (this.clients_[i].getAccount().getAccount_number() == AccountNum) {
                    if (this.clients_[i].getAccount().withdraw(Money))
                        return true;
                }
            }
        return false;
    }

    /**
     * Display all the Client in the bank
     */
    public void display() {
        if (NumCurrClients_ != 0) {
            for (int i = 0; i < NumCurrClients_; i++) {
                System.out.print("The client " + (i + 1) + ">> " + clients_[i].toString());
            }
        } else
            System.out.println("Not enough clients");
    }
}
