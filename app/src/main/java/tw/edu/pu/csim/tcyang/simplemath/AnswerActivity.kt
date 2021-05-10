package tw.edu.pu.csim.tcyang.simplemath

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_answer.*

class AnswerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        val intent = getIntent()
        val you:String?=intent.getStringExtra("You")
        val correct:String?=intent.getStringExtra("Correct")

        var Result:String = ""
        Result = "您的答案為:" + you + "\n正確答案為:" + correct + "\n\n"
        if (you?.toFloat() == correct?.toFloat()){
            Result += "您答對了!"
        }
        else{
            Result += "您答錯了!"
        }
        txvMsg.text=Result

        btnBack.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                finish()
            }
        })
    }
}