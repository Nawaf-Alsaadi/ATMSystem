# ATM - Banking Simplified 🏦

This ATM application provides a simple and interactive console-based banking experience. Users can create accounts, log in, check balances, deposit, withdraw, and transfer money. The application is designed to simulate common ATM operations, allowing users to manage their finances effectively.

---

## Key Features ✨

- **Create Account**: Users can create a new bank account with a unique account number and PIN.
- **Log into Existing Account**: Users can log in to their accounts securely using their account number and PIN.
- **Check Balance**: Users can view their current account balance at any time.
- **Deposit Money**: Users can deposit funds into their accounts.
- **Withdraw Money**: Users can withdraw funds from their accounts, subject to balance limits.
- **Transfer Money**: Users can transfer funds between accounts with ease.

---


## Installation Guide ⚙️

To run the ATM application, follow these steps for **Windows**, **macOS**, and **Linux**:

```bash
git clone https://github.com/Nawaf-Alsaadi/ATMSystem.git
cd ATMSystem
javac ATM.java
java ATM
```

## User Guide 📖

### Creating an Account

To create a new account in the ATM application, follow these steps:

1. Run the application.
2. Select **1. Create Account** from the main menu.
3. Enter a unique account number.
4. Set a new PIN for your account.
5. Specify an initial deposit amount.

### Collaboration Features 🤝

The ATM application does not include collaboration features as it is designed for individual use. However, if integrated into a broader system, potential collaboration features could include:

| Collaboration Option | Description                               |
|----------------------|-------------------------------------------|
| *Shared Accounts*      | Multiple users can access a single account. |
| *Task Assignments*     | Assign tasks related to account management.  |
| *Communication Tools*  | In-app messaging for user support.       |

### Reporting 📊

Users can generate reports of their transactions by implementing a method to retrieve account activity. Below is an example of a generated report in JSON format:

```json
{
  "accountNumber": 123456,
  "transactions": [
    {
      "type": "Deposit",
      "amount": 200.00,
      "date": "2024-01-01",
      "description": "Initial deposit"
    },
    {
      "type": "Withdrawal",
      "amount": 50.00,
      "date": "2024-01-02",
      "description": "ATM withdrawal"
    },
    {
      "type": "Transfer",
      "amount": 100.00,
      "date": "2024-01-03",
      "description": "Transfer to account 654321"
    }
  ],
  "currentBalance": 50.00
}
```
## Troubleshooting 🛠️

### Common Issues

**Incorrect PIN**  
Users may enter the wrong PIN when attempting to log into their accounts. Ensure that you are entering the correct PIN associated with your account.

**Insufficient Funds**  
This error occurs when trying to withdraw or transfer an amount that exceeds the available balance in the account. Always check your balance before performing transactions.

**Account Not Found**  
If a user tries to log in with or transfer to an account number that does not exist, they will encounter this issue. Verify that you have entered the correct account number and that the account has been created.

## Advanced Usage

### Scripting

While the ATM application does not support direct scripting, users can enhance functionality by modifying the Java source code to automate certain tasks. For example, you could create a method to handle batch deposits for multiple accounts. Here’s an example script:

```java
// Example of a method to automate multiple deposits
public void batchDeposit(HashMap<Integer, Account> accounts, int accountNumber, double[] amounts) {
    Account account = accounts.get(accountNumber);
    if (account != null) {
        for (double amount : amounts) {
            account.deposit(amount);
        }
    } else {
        System.out.println("Account not found.");
    }
}
```


### Integrations 🌐

The ATM application can potentially integrate with various financial services and applications. Here’s a table outlining some possible integrations:
![Picture of Famous Saudi Banks](SaudiBanks.png)
| Application Name          | Description                                      | Website                                |
|---------------------------|--------------------------------------------------|----------------------------------------|
| PayPal                    | Online payment system                            | [paypal.com](https://www.paypal.com)           |
| STC Pay                  | Mobile wallet and payment service in Saudi Arabia | [stcpay.com](https://stcpay.com.sa/)          |
| Tamara                    | Buy now, pay later service                       | [tamara.co](https://www.tamara.co)            |
| Al Rajhi Bank            | Leading Islamic bank offering various financial services | [alrajhibank.com.sa](https://www.alrajhibank.com.sa) |
| SNB (Saudi National Bank) | Comprehensive banking services               | [ncb.com.sa](https://www.alahli.com/en/pages/personal-banking)          |


## Footnotes 📚

1. *Basic ATM Functionality*: For more information on the design and functionality of ATM systems, refer to [Bankrate - What Is an ATM?](https://www.bankrate.com/banking/what-is-an-atm/#transaction-examples).
2. *Ministry of Finance, Saudi Arabia*: For insights into financial policies and economic regulations, check out the [Ministry of Finance](https://www.mof.gov.sa/en/Pages/default.aspx).
