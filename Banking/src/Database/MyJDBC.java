package Database;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyJDBC {
    // database config
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bankApp"; // enter database url here
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "shuvaranjan2004";

    public static User validateLogin(String username, String password) {
        try {
            // establish a connetion to the database
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // create a SQL Query
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ? AND password = ?");

            // replace the ? with values
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // execute query and store to a ResultSet
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // success
                // get id
                int UserId = resultSet.getInt("id");

                // get currrent balance
                BigDecimal currentBalance = resultSet.getBigDecimal("current_balance");

                // return user obj
                return new User(UserId, username, password, currentBalance);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // not valid user
        return null;
    }

    public static boolean register(String username, String password) {
        try {
            if (!checkUser(username)) {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO users(username,password,current_balance) " +
                                "VALUES(?,?,?)");
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setBigDecimal(3, new BigDecimal(0));

                preparedStatement.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // check if the username already exist in the database
    // true - user exists
    // false - user not exists
    private static boolean checkUser(String username) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE username=?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;

    }
    // true - update to db was success
    // false - update to db was fail

    public static boolean addTransactionToDatabase(Transaction transaction) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement insertTransaction = connection.prepareStatement(
                    "INSERT transactions(user_id, transaction_type, transaction_amount, transaction_date)" +
                            "VALUES(?, ?, ?, Now())");
            // NOW() will put in the current date

            insertTransaction.setInt(1, transaction.getUserId());
            insertTransaction.setString(2, transaction.getTransactioType());
            insertTransaction.setBigDecimal(3, transaction.getTransactionAmount());

            insertTransaction.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // true - update balance successful
    // false - update balance fail

    public static boolean updateCurrentBalance(User user) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement updateBalance = connection.prepareStatement(
                    "UPDATE users SET current_balance = ? WHERE id = ?");
            updateBalance.setBigDecimal(1, user.getCurrentBalance());
            updateBalance.setInt(2, user.getId());

            updateBalance.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // true - transfer was success
    // false - transfer was fail

    public static boolean transfer(User user, String transferedUsername, float transferAmount) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement queryUser = connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ?"

            );

            queryUser.setString(1, transferedUsername);
            ResultSet resultSet = queryUser.executeQuery();
            while (resultSet.next()) {
                // perform transfer
                User transferedUser = new User(
                        resultSet.getInt("id"),
                        transferedUsername,
                        resultSet.getString("password"),
                        resultSet.getBigDecimal("current_balance"));

                // create transaction
                Transaction transferTransaction = new Transaction(
                        user.getId(),
                        "Transfer",
                        new BigDecimal(-transferAmount),
                        null

                );
                // this transaction will being to be transferred user
                Transaction recievedTransaction = new Transaction(
                        transferedUser.getId(),
                        "Transfer",
                        new BigDecimal(transferAmount),
                        null);

                // update transfer user
                transferedUser
                        .setCurrentBalance(transferedUser.getCurrentBalance().add(BigDecimal.valueOf(transferAmount)));
                updateCurrentBalance(transferedUser);

                // update user current balance
                user.setCurrentBalance(user.getCurrentBalance().subtract(BigDecimal.valueOf(transferAmount)));
                updateCurrentBalance(user);

                // add these transaction to the Database
                addTransactionToDatabase(transferTransaction);
                addTransactionToDatabase(recievedTransaction);

                return true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // get all transactions(used for Show Transactions)
    public static ArrayList<Transaction> getPastTransaction(User user) {
        ArrayList<Transaction> pastTransactions = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement selectAllTransaction = connection.prepareStatement(
                    "SELECT * FROM transactions WHERE user_id = ?");

            selectAllTransaction.setInt(1, user.getId());
            ResultSet resultSet = selectAllTransaction.executeQuery();

            while (resultSet.next()) {
                // create transaction object
                Transaction transaction = new Transaction(
                        user.getId(),
                        resultSet.getString("transaction_type"),
                        resultSet.getBigDecimal("transaction_amount"),
                        resultSet.getDate("transaction_date")

                );

                // store into Array List
                pastTransactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pastTransactions;
    }
}
