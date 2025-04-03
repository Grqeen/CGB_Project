package cgb.transfert.dto;

import java.sql.Date;
import java.time.LocalDate;

public class TransferDTO {
    private String sourceAccountNumber;
    private String destinationAccountNumber;
    private double amount;
    private LocalDate transferDate;
    private String description;

    // Constructeur par défaut
    public TransferDTO() {
    }

    // Constructeur avec paramètres
    public TransferDTO(String sourceAccountNumber, String destinationAccountNumber, double amount, LocalDate transferDate, String description) {
        this.sourceAccountNumber = sourceAccountNumber;
        this.destinationAccountNumber = destinationAccountNumber;
        this.amount = amount;
        this.transferDate = transferDate;
        this.description = description;
    }

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public void setSourceAccountNumber(String sourceAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
    }

    public String getDestinationAccountNumber() {
        return destinationAccountNumber;
    }

    public void setDestinationAccountNumber(String destinationAccountNumber) {
        this.destinationAccountNumber = destinationAccountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
