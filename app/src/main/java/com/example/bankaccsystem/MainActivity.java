package com.example.bankaccsystem;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etAmount;
    private TextView tvAccountDetails, tvTransactionLog;
    private BankAccount checkingAccount, savingsAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAmount = findViewById(R.id.etAmount);
        Button btnDeposit = findViewById(R.id.btnDeposit);
        Button btnWithdraw = findViewById(R.id.btnWithdraw);
        Button btnTransfer = findViewById(R.id.btnTransfer);
        tvAccountDetails = findViewById(R.id.tvAccountDetails);
        tvTransactionLog = findViewById(R.id.tvTransactionLog);

        checkingAccount = new CheckingAccount("YS", 1000, "1001", 500); // cincai
        savingsAccount = new SavingAccount("YS", 1500, "1002", 0.05); // cincai

        btnDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doDeposit();
            }
        });

        btnWithdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doWithdrawal();
            }
        });

        btnTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doTransfer();
            }
        });

        update();
    }

    private void doDeposit() {
        try {
            double amount = Double.parseDouble(etAmount.getText().toString());
            checkingAccount.deposit(amount);
            update();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid amount", Toast.LENGTH_SHORT).show();
        }
    }

    private void doWithdrawal() {
        try {
            double amount = Double.parseDouble(etAmount.getText().toString());
            if (!checkingAccount.withdraw(amount)) {
                Toast.makeText(this, "mainInsufficient funds", Toast.LENGTH_SHORT).show();
            }
            update();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid amount", Toast.LENGTH_SHORT).show();
        }
    }

    private void doTransfer() {
        try {
            double amount = Double.parseDouble(etAmount.getText().toString());
            if (!checkingAccount.transfer(savingsAccount, amount)) {
                Toast.makeText(this, "Transfer failed", Toast.LENGTH_SHORT).show();
            }
            update();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid amount", Toast.LENGTH_SHORT).show();
        }
    }

    private void update() {
        tvAccountDetails.setText(checkingAccount.getAccountDetails());
        tvTransactionLog.setText(checkingAccount.getTransactionHistory());
    }
}
