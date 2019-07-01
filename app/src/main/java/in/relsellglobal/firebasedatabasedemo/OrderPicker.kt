package `in`.relsellglobal.firebasedatabasedemo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class OrderPicker : AppCompatActivity() {

    var pickButton : Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pickButton = findViewById(R.id.actionButton);
        pickButton!!.setEnabled(false)


        FirebaseDatabase.getInstance().getReference("").child("orderStatus").child("onlyOne").addListenerForSingleValueEvent(object:
            ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {

                if(p0 != null){

                    pickButton!!.text = p0.getValue(String::class.java)
                    pickButton!!.setEnabled(true)

                }

            }

        })

        pickButton!!.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(applicationContext, "Order Picked Up", Toast.LENGTH_LONG).show()
                pickButton!!.text = "Order picked up"

                var dbRef = FirebaseDatabase.getInstance().getReference();
                var pushedKey = dbRef.child("orderStatus").push().key;
                dbRef.child("orderStatus").child("onlyOne").setValue("Order Picked Up");

            }

        })
    }
}
