package com.example.lostc;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogLogbuchinfo extends AppCompatDialogFragment {
    private DialogLogbuchinfo.ExampleDialogListener3 listener3;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Hinweis zum Spiel!")
                .setMessage("Im Bordbuch findest du hilfreiche Informationen zur Beantwortung der Fragen.\n" +
                        "\n" +
                        "In der Abfrage wird dein Können unter Beweis gestellt. Um ein Level weiterzukommen musst du mehr als 80 % der Fragen richtig beantworten. Sobald du alle Level durchgespielt hast wartet eine Belohnung auf dich, also halte durch bis zum Schluss!\n" +
                        "\n" +
                        "In Programmieren kannst du zusätzlich zur Theorie noch mit Programmieraufgaben dein Wissen vertiefen. \n")
                .setPositiveButton("Weiter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listener3.onYesClicked();
                    }
                });
        return builder.create();
    }

    public interface ExampleDialogListener3 {
        void onYesClicked();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener3 = (DialogLogbuchinfo.ExampleDialogListener3) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }
}