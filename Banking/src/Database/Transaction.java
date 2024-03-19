package Database;
/*
 * Transation entity it is used to transaction data like Transaction_amount, Transaction_date,    Transaction_type
 */

import java.math.BigDecimal;
import java.sql.Date;

public class Transaction {
    private final int userId;
    private final String transactioType;
    private final BigDecimal transactionAmount;
    private final Date transactionDate;
    

    public Transaction(int userId, String transactionType, BigDecimal  transactionAmount, Date transactionDate) {
        this.userId = userId;
        this.transactioType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;

    }


    public int getUserId() {
        return userId;
    }


    public String getTransactioType() {
        return transactioType;
    }


    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }


    public Date getTransactionDate() {
        return transactionDate;
    }

    
}
