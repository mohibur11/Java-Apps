import React, { useState } from "react";
import "./clientDashboard.css"; // Optional for styling
import { Account } from "../../types/account.type";
import { createAccount, getAccount, getBalance } from "../../services/account.service";

const ClientDashBoard: React.FC = () => {
  const [user_id, setUserId] = useState<string>("");
  const [withdrawUserId, setWithdrawUserId] = useState<string>("");
  const [withdrawAmount, setWithdrawAmount] = useState<string>("");
  const [depositUserId, setDepositUserId] = useState<string>("");
  const [depositAmount, setDepositAmount] = useState<string>("");
  const [errorMessage, setErrorMessage] = useState<string>("");
  const [newAccount, setNewAccount] = useState<Account>({
    user_id: "",
    name: "",
    email: "",
    balance: 0
  });
  const [accountData, setAccountData] = useState<Account | null>(null);

  // Mocked function to fetch data
  const fetchAccountData = async (user_id: string) => {
    // Replace with actual API call
    const resp = await getAccount(user_id);
    if (resp.status == "success") {
      const account: Account = resp.data;
      setAccountData(account);
    } else {
      showErrorMessage("get account by user id");
    }
  };

  const showErrorMessage = (message: string) => {
    setErrorMessage("Error Occured during " + message);
  }

  const handleWithdraw = () => {
    // Replace with withdraw logic
    console.log(`Withdrawing ${withdrawAmount} from account ${withdrawUserId}`);
  };

  const handleDeposit = () => {
    // Replace with deposit logic
    console.log(`Depositing ${depositAmount} to account ${depositUserId}`);
  };

  const handleAccountCreation = async() => {
    // Replace with account creation logic
    await createAccount(newAccount)
    console.log("Creating account:", newAccount);
  };

  return (
    <div className="banking-page">
      <header>
        <h1>Simple Banking</h1>
      </header>
      <div className="container">
        <div className="left-panel">
          {/* Check Balance Section */}
          <div className="section">
            <label>
              User ID:
              <input
                type="text"
                value={user_id}
                onChange={(e) => setUserId(e.target.value)}
                placeholder="Enter User ID"
              />
            </label>
            <button
              onClick={() => fetchAccountData(user_id)}
              disabled={!user_id.trim()}
            >
              Check Balance
            </button>
            {accountData && (
              <div>
                <p>Name: {accountData.name}</p>
                <p>Balance: ${accountData.balance}</p>
              </div>
            )}
          </div>

          {/* Withdraw Balance Section */}
          <div className="section">
            <label>
              User ID:
              <input
                type="text"
                value={withdrawUserId}
                onChange={(e) => setWithdrawUserId(e.target.value)}
                placeholder="Enter User ID"
              />
            </label>
            <label>
              Withdraw Amount:
              <input
                type="number"
                value={withdrawAmount}
                onChange={(e) => setWithdrawAmount(e.target.value)}
                placeholder="Enter Amount"
              />
            </label>
            <button
              onClick={handleWithdraw}
              disabled={!withdrawUserId.trim() || !withdrawAmount.trim()}
            >
              Withdraw Balance
            </button>
          </div>

          {/* Deposit Balance Section */}
          <div className="section">
            <label>
              User ID:
              <input
                type="text"
                value={depositUserId}
                onChange={(e) => setDepositUserId(e.target.value)}
                placeholder="Enter User ID"
              />
            </label>
            <label>
              Deposit Amount:
              <input
                type="number"
                value={depositAmount}
                onChange={(e) => setDepositAmount(e.target.value)}
                placeholder="Enter Amount"
              />
            </label>
            <button
              onClick={handleDeposit}
              disabled={!depositUserId.trim() || !depositAmount.trim()}
            >
              Deposit Balance
            </button>
          </div>
        </div>

        {/* Right Panel */}
        <div className="right-panel">
          <h2>Create Account</h2>
          <form
            onSubmit={(e) => {
              e.preventDefault();
              handleAccountCreation();
            }}
          >
            <label>
              User ID:
              <input
                type="text"
                value={newAccount.user_id}
                onChange={(e) =>
                  setNewAccount({ ...newAccount, user_id: e.target.value })
                }
                placeholder="Enter User ID"
              />
            </label>
            <label>
              Name:
              <input
                type="text"
                value={newAccount.name}
                onChange={(e) =>
                  setNewAccount({ ...newAccount, name: e.target.value })
                }
                placeholder="Enter Name"
              />
            </label>
            <label>
              Email:
              <input
                type="email"
                value={newAccount.email}
                onChange={(e) =>
                  setNewAccount({ ...newAccount, email: e.target.value })
                }
                placeholder="Enter Email"
              />
            </label>
            <button
              type="submit"
              disabled={
                !newAccount.user_id || !newAccount.name || !newAccount.email
              }
            >
              Create Account
            </button>
          </form>
        </div>
      </div>
      <div>
        <h4>{errorMessage}</h4>
      </div>
    </div>
  );
};

export default ClientDashBoard;
