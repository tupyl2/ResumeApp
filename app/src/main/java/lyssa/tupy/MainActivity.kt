package lyssa.tupy

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var workHistory = findViewById<Button>(R.id.workHistoryButton)

        workHistory.setOnClickListener{

            var moveToWorkHistory = Intent(getApplicationContext(), WorkHistoryActivity::class.java)
            startActivity(moveToWorkHistory)
        }

        var call = findViewById<Button>(R.id.callButton)

        call.setOnClickListener {
            println("Call")

            var phoneUri = Uri.parse("tel:18002343456")
            var callIntent = Intent(Intent.ACTION_DIAL, phoneUri)
            startActivity(callIntent)
        }

        var email = findViewById<Button>(R.id.emailButton)

        email.setOnClickListener {
            println("Email")

            var emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.setType("plain/text")
            emailIntent.putExtra(Intent.EXTRA_EMAIL, ("someemail@gmail.com"))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Let's Connect!")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "I really enjoyed your resume...")
            startActivity(emailIntent)
        }
    }
}