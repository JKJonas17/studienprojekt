package com.example.lostc;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogFortschritt extends AppCompatDialogFragment {
    private ExampleDialogListener2 listener2;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Vorsicht!")
                .setMessage("Willst du wirklich deinen Spielfortschritt zurücksetzen? Dadurch gehen deine ganzen, gesammelten Punkte dauerhaft verloren.")
                .setNegativeButton("Zurück", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listener2.onYesClicked();
                    }
                });
        return builder.create();
    }

    public interface ExampleDialogListener2 {
        void onYesClicked();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener2 = (ExampleDialogListener2) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }
}
