package com.example.android.navigation

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialogFragment
import com.example.android.navigation.models.Course
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.add_dialog.*

class AddFile : AppCompatDialogFragment() {
    private var editTextTitle: EditText? = null
    //    private EditText editTextPassword;
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        editTextTitle!!.setText("")
        val inflater = activity!!.layoutInflater
        val view = inflater.inflate(R.layout.add_dialog, null)
        builder.setView(view)
                .setTitle("Add")
                .setNegativeButton("Cancel") { dialog, i ->}
                .setPositiveButton("OK") { dialog, i ->

                    val name = editTextTitle!!.text.toString()
                    if (TextUtils.isEmpty(name))
                    {
                        editTextTitle!!.error = "please Fill up data"
                        editTextTitle!!.requestFocus()
                    }
                    else
                    {

                        Toast.makeText(context, "Data Updated", Toast.LENGTH_SHORT).show()

                    }
                }
        editTextTitle = view.findViewById(R.id.editText1)

        return builder.create()
    }
}
